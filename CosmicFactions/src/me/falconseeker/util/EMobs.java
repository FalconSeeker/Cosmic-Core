package me.falconseeker.util;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import me.falconseeker.end.endmonsters.EnderCreeper;
import me.falconseeker.end.endmonsters.EnderMonster;
import net.minecraft.server.v1_12_R1.WorldServer;

/**
 * Util class for spawning End Mobs
 * 
 * @author Falcon_Seeker
 *
 */
public final class EMobs extends Utils {

	private EMobs() {}
	
	/**
	 * Spawns an EnderMonster
	 * @param loc - Location to spawn ender monster to
	 */
    public static void spawnEnderMonster(Location loc){

    	WorldServer nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
      
        EnderMonster cz = new EnderMonster(nmsWorld);
        cz.setPosition(loc.getX(), loc.getY(), loc.getZ());
        cz.h(loc.getYaw());
        XTags.setEntityTag(cz.getBukkitEntity(), "EnderMonster", "MobType");

        nmsWorld.addEntity(cz);          
    }
    /**
     * Spawns a Creeper
     * @param loc - Location to spawn creeper to
     */
    public static void spawnCreeper(Location loc){

    	WorldServer nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
      
        EnderCreeper cz = new EnderCreeper(nmsWorld);
        cz.setPosition(loc.getX(), loc.getY(), loc.getZ());
        cz.h(loc.getYaw());
        XTags.setEntityTag(cz.getBukkitEntity(), "EnderCreeper", "MobType");

        nmsWorld.addEntity(cz);          
    }
}
