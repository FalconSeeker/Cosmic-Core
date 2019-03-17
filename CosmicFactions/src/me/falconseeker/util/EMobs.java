package me.falconseeker.util;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;

import me.falconseeker.end.endmonsters.EMobCreepers;
import me.falconseeker.end.endmonsters.EMobEnderMonster;
import net.minecraft.server.v1_12_R1.EntityHuman;
import net.minecraft.server.v1_12_R1.GenericAttributes;
import net.minecraft.server.v1_12_R1.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_12_R1.WorldServer;

/**
 * Util class for spawning End Mobs
 * 
 * @author Falcon_Seeker
 *
 */
public class EMobs {
	
	private EMobs() {}
	
	/**
	 * Spawns an EnderMonster
	 * @param loc - Location to spawn ender monster to
	 */
    public static void spawnEnderMonster(Location loc){

    	WorldServer nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
      
        EMobEnderMonster cz = new EMobEnderMonster(nmsWorld);
        cz.setPosition(loc.getX(), loc.getY(), loc.getZ());
        cz.h(loc.getYaw());
        cz.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget<EntityHuman>(cz, EntityHuman.class, 0, true, false, null));
        cz.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.28d);
        cz.getAttributeInstance(GenericAttributes.ATTACK_DAMAGE).setValue(3);
        cz.getAttributeInstance(GenericAttributes.FOLLOW_RANGE).setValue(20);
        
        nmsWorld.addEntity(cz);          
    }
    /**
     * Spawns a Creeper
     * @param loc - Location to spawn creeper to
     */
    public static void spawnCreeper(Location loc){

    	WorldServer nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
      
        EMobCreepers cz = new EMobCreepers(nmsWorld);
        cz.setPosition(loc.getX(), loc.getY(), loc.getZ());
        cz.h(loc.getYaw());
        cz.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget<EntityHuman>(cz, EntityHuman.class, 0, true, false, null));
        //We want only creepers to not be able to attack players, but they still look at them
        nmsWorld.addEntity(cz);          
    }
}
