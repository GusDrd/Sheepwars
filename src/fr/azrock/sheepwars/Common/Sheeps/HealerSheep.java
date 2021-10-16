package fr.azrock.sheepwars.Common.Sheeps;

import java.util.Random;
import java.util.Set;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent.TargetReason;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.azrock.sheepwars.Common.Enums.EnumSheep;
import fr.azrock.sheepwars.Utils.AreaShape;
import net.minecraft.server.v1_14_R1.EntityPlayer;
import net.minecraft.server.v1_14_R1.EntitySheep;
import net.minecraft.server.v1_14_R1.EntityTypes;
import net.minecraft.server.v1_14_R1.EnumColor;
import net.minecraft.server.v1_14_R1.GenericAttributes;
import net.minecraft.server.v1_14_R1.Item;
import net.minecraft.server.v1_14_R1.Items;
import net.minecraft.server.v1_14_R1.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_14_R1.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_14_R1.World;

public class HealerSheep extends Sheep {

	public HealerSheep(EntityTypes<? extends EntitySheep> entityTypes, World world) {
		super(entityTypes, world);
	}

	@Override
	public String getSheepName() {
		return "&dHEALER";
	}

	@Override
	public EnumSheep getType() {
		return EnumSheep.HEALER;
	}

	@Override
	public EnumColor getColor() {
		return EnumColor.PINK;
	}

	@Override
	public float getExplosionForce() {
		return 8.0f;
	}

	@Override
	public Item getBoostItem() {
		return Items.APPLE;
	}
	
	@Override
	public int getEffectSpeed() {
		return 40;
	}

	@Override
	public int getAreaSize() {
		return 8;
	}

	@Override
	public int getTickDuration() {
		return 20 * 6;
	}

	@Override
	public boolean isSupport() {
		return true;
	}
	
	@Override
	public void setTarget() { 
		EntityPlayer player = ((CraftPlayer) getSummoner()).getHandle();
		setGoalTarget(player, TargetReason.CUSTOM, true);
	}
	
	@Override
	public void onSpawn() {
		this.getAttributeMap().b(GenericAttributes.ATTACK_DAMAGE);
		this.getAttributeInstance(GenericAttributes.ATTACK_DAMAGE).setValue(0d);
		this.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.30590000554919242d);
		targetSelector.a(0, new PathfinderGoalNearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, 10, true, true, p -> p.getUniqueID() == getSummoner().getUniqueId()));
		goalSelector.a(0, new PathfinderGoalMeleeAttack(this, 1.0D, false));
	}

	@Override
	public void playParticle() {
		if(ticksLived % getEffectSpeed()/4 == 0) {
			Random random = new Random();
			Set<Location> locations = AreaShape.getSquaredArea(new Location(world.getWorld(), locX, locY, locZ), getAreaSize());
			
			for(Location l : locations) {
				if(random.nextInt(100) < 5)
					world.getWorld().spawnParticle(Particle.HEART,
							l.getX() + (double) (this.random.nextFloat() * this.getWidth() * 2.0F) - (double) this.getWidth(),
							l.getY() + (double) (this.random.nextFloat() * this.getHeight() * 1.5F),
							l.getZ() + (double) (this.random.nextFloat() * this.getWidth() * 2.0F) - (double) this.getWidth(),
							1, 0.0D, 0.0D, 0.0D, 0.0D, null);
			}
		}
	}

	@Override
	public void playAreaEffect() {
		if(ticksLived % getEffectSpeed() == 0) {
			for(Player p : getNearbyPlayers(getAreaSize())) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, getEffectSpeed(), 2));
			}
		}
	}

	@Override
	public boolean willExplode() {
		return false;
	}

	@Override
	public void onEndLife() { }

}
