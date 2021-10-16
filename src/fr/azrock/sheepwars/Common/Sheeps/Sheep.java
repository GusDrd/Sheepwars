package fr.azrock.sheepwars.Common.Sheeps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_14_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent.TargetReason;
import org.bukkit.metadata.FixedMetadataValue;

import fr.azrock.sheepwars.SheepWars;
import fr.azrock.sheepwars.Common.Enums.EnumSheep;
import fr.azrock.sheepwars.Common.Enums.EnumTeam;
import net.minecraft.server.v1_14_R1.BlockPosition;
import net.minecraft.server.v1_14_R1.ChatComponentText;
import net.minecraft.server.v1_14_R1.DamageSource;
import net.minecraft.server.v1_14_R1.DifficultyDamageScaler;
import net.minecraft.server.v1_14_R1.Entity;
import net.minecraft.server.v1_14_R1.EntityInsentient;
import net.minecraft.server.v1_14_R1.EntityHuman;
import net.minecraft.server.v1_14_R1.EntityPlayer;
import net.minecraft.server.v1_14_R1.EntitySheep;
import net.minecraft.server.v1_14_R1.EntityTypes;
import net.minecraft.server.v1_14_R1.EnumColor;
import net.minecraft.server.v1_14_R1.EnumMobSpawn;
import net.minecraft.server.v1_14_R1.GeneratorAccess;
import net.minecraft.server.v1_14_R1.GenericAttributes;
import net.minecraft.server.v1_14_R1.GroupDataEntity;
import net.minecraft.server.v1_14_R1.Item;
import net.minecraft.server.v1_14_R1.ItemStack;
import net.minecraft.server.v1_14_R1.MinecraftKey;
import net.minecraft.server.v1_14_R1.NBTTagCompound;
import net.minecraft.server.v1_14_R1.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_14_R1.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_14_R1.PathfinderGoalSelector;
import net.minecraft.server.v1_14_R1.Vec3D;
import net.minecraft.server.v1_14_R1.World;
import net.minecraft.server.v1_14_R1.WorldServer;
import net.minecraft.server.v1_14_R1.Explosion.Effect;

public abstract class Sheep extends EntitySheep {
	
	/* ----------------------------------
	 *             ABSTRACT METHODS
	 *   ---------------------------------- */
	
	public abstract String getSheepName();
	
	public abstract EnumSheep getType();
	
	public abstract EnumColor getColor();
	
	public abstract float getExplosionForce();
	
	public abstract Item getBoostItem();

	public abstract void playParticle();
	
	public abstract void playAreaEffect();

	public abstract int getEffectSpeed();
	
	public abstract int getAreaSize();
	
	public abstract int getTickDuration();
	
	public abstract boolean isSupport();

	public abstract void onSpawn();
	
	public abstract boolean willExplode();
	
	public abstract void onEndLife();
	// ---------------------------------------------
	
	
	private org.bukkit.entity.Entity summoner;
	private EnumTeam team;
	
	public Sheep(EntityTypes<? extends EntitySheep> entityTypes, World world) {
		super(EntityTypes.SHEEP, world);
		
		goalSelector = new PathfinderGoalSelector( (world != null && world.getMethodProfiler() != null) ? world.getMethodProfiler() : null);
		targetSelector = new PathfinderGoalSelector( (world != null && world.getMethodProfiler() != null) ? world.getMethodProfiler() : null);
		
		goalSelector.a(1, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 6.0F));
		goalSelector.a(1, new PathfinderGoalRandomLookaround(this));
	}
	
	
	
	/* ----------------------------------
	 *             SHEEP METHODS
	 *   ---------------------------------- */
	
	public List<Player> getNearbyPlayers(int around) {
		Location loc = new Location(this.world.getWorld(), this.locX, this.locY, this.locZ);
		Collection<org.bukkit.entity.Entity> nearbyEntities = loc.getWorld().getNearbyEntities(loc,  around, around, around);
		
		List<Player> list = new ArrayList<Player>();
		
		for(org.bukkit.entity.Entity e : nearbyEntities) {
			if(e instanceof Player)
				list.add((Player)e);
		}
		
		return list;
	}
	
	public List<Player> getNearbyEnemies(int around) {
		List<Player> nearbyPlayers = getNearbyPlayers(around);
		List<Player> list = new ArrayList<Player>();
		
		for(Player p : nearbyPlayers) {
			// TODO  //
			//  TODO //
			// TODO  //
			//  TODO //
			// TODO  //
			//  TODO //
			// TODO  //
			//  TODO //
		}
		
		return list;
	}
	
	
	public void setTarget() {
		List<Player> enemies = getNearbyEnemies(8);
		if(!enemies.isEmpty()) {
			EntityPlayer target = ((CraftPlayer) enemies.get(0)).getHandle();
			setGoalTarget(target, TargetReason.CUSTOM, true);
		}
	}
	
	public void explode() {
		if(willExplode())
			getWorld().createExplosion(this, locX, locY + (double)(this.getHeight() / 16.0f), locZ, getExplosionForce(), false, Effect.DESTROY);
		
		die();
	}
	// ---------------------------------------------
	
	
	/* ----------------------------------
	 *          OVERWRITTEN METHODS
	 *   ---------------------------------- */
	
	@Override
	public int getExpValue(EntityHuman entity) {
		return 0;
	}
	
	@Override
	public MinecraftKey getDefaultLootTable() {
		return null;
	}
	
	@Override
	public boolean i(ItemStack item) {
		return item.getItem() == getBoostItem();
	}
	
	@Override
	public void die() {
		onEndLife();
		super.die();
	}
	
	@Override
	public boolean damageEntity(DamageSource source, float f) {
		if(source.equals(DamageSource.FALL))
			return false;
		
		return super.damageEntity(source, f);
	}
	
	@Override
	public GroupDataEntity prepare(GeneratorAccess access, DifficultyDamageScaler scaler, EnumMobSpawn enumMob, @Nullable GroupDataEntity dataGroup, @Nullable NBTTagCompound tagCompound) {
		GroupDataEntity group = super.prepare(access, scaler, enumMob, dataGroup, tagCompound);
		EntitySheep sheep = ((EntitySheep)this.getBukkitEntity().getHandle());
		
		String name = (isSupport() ? "&a[\u2764] " : "&c[\u27B8] ") + getSheepName();
		
		sheep.setColor(getColor());
		sheep.setCustomName(new ChatComponentText(name.replaceAll("&", "\u00A7")));
		
		return group;
	}
	
	@Override
	public void tick() {
		if(locY < 0) {
			die();
			return;
		}
		
		super.tick();
		
		
		int percentage = (int) ((float)ticksLived / (float)getTickDuration() * 100);
		
		if(percentage > 50) {
			double result = Math.cos((percentage-50) * (float)ticksLived / 100);
			if(result > 0)
				setColor(EnumColor.WHITE);
			else if(result < 0)
				setColor(getColor());
		}
		
		if(ticksLived % 20 == 0)
			setTarget();
			
		
		playParticle();
		playAreaEffect();
		
		if(percentage == 75 && willExplode())
			world.getWorld().playSound(new Location(world.getWorld(), locX, locY, locZ), Sound.ENTITY_TNT_PRIMED, 1.0f, 0.5f);
		
		if(getTickDuration() != -1 && ticksLived >= getTickDuration())
			explode();
		
	}
	// ---------------------------------------------
	
	
	
	public void setSummoner(org.bukkit.entity.Entity summoner) {
		this.summoner = summoner;
	}
	
	public void setTeam(EnumTeam team) {
		this.team = team;
	}
	
	
	public org.bukkit.entity.Entity getSummoner() {
		return summoner;
	}
	
	public EnumTeam getTeam() {
		return team;
	}
	
	
	/* ----------------------------------
	 *          STATIC METHODS
	 *   ---------------------------------- */
	public static org.bukkit.inventory.ItemStack getRandomSheepItem() {
		Random r = new Random();
		int i = r.nextInt(100);
		
		if(i < 49)
			return EnumSheep.getSheepByWool(Material.BLACK_WOOL).getWoolItem();
		else
			return EnumSheep.getSheepByWool(Material.PINK_WOOL).getWoolItem();
		
		
		// COMPLETE CHANCES OF GETTING EACH SHEEP.
		
		// TODO
		// TODO
	}
	
	public static Sheep summonSheep(org.bukkit.entity.Entity summoner, EnumSheep sheepType) {
		Location location = summoner.getLocation();
		WorldServer nmsWorld = ((CraftWorld) summoner.getWorld()).getHandle();
		
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("id", "minecraft:"+sheepType.getName());
		Vec3D vec = new Vec3D(location.getX(), location.getY(), location.getZ());
		
		Entity entity = EntityTypes.a(nbt, nmsWorld, entity1 -> {
			entity1.setPositionRotation(vec.x, vec.y, vec.z, entity1.yaw, entity1.pitch);
			return !nmsWorld.addEntitySerialized(entity1) ? null : entity1;
		});
		
		((EntityInsentient) entity).prepare(nmsWorld, nmsWorld.getDamageScaler(new BlockPosition(vec)), EnumMobSpawn.COMMAND, null, (NBTTagCompound)nbt);
		entity.setInvulnerable(true);
		
		Sheep sheep = (Sheep)entity;
		sheep.setSummoner(summoner);
		
		if(summoner instanceof Player)
			sheep.setTeam(EnumTeam.RED);
		else
			sheep.setTeam(EnumTeam.UNKWOWN);
		
		sheep.onSpawn();
		sheep.setInvulnerable(false);
		
		double health = 10.0d;
		
		sheep.getAttributeInstance(GenericAttributes.MAX_HEALTH).setValue(health);
		sheep.setHealth((float)health);
		sheep.getBukkitEntity().setMetadata("type", new FixedMetadataValue(SheepWars.get(), sheepType.getName()));
		
		return sheep;
	}
	
	// ---------------------------------------------
	
}
