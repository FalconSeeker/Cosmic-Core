package me.falconseeker.cosmic.end.endmonsters;

import java.lang.reflect.Field;
import java.util.Set;

import me.falconseeker.util.Utils;
import net.minecraft.server.v1_12_R1.EntityCreeper;
import net.minecraft.server.v1_12_R1.EntityHuman;
import net.minecraft.server.v1_12_R1.GenericAttributes;
import net.minecraft.server.v1_12_R1.PathfinderGoalFloat;
import net.minecraft.server.v1_12_R1.PathfinderGoalHurtByTarget;
import net.minecraft.server.v1_12_R1.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_12_R1.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_12_R1.PathfinderGoalMoveThroughVillage;
import net.minecraft.server.v1_12_R1.PathfinderGoalMoveTowardsRestriction;
import net.minecraft.server.v1_12_R1.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_12_R1.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_12_R1.PathfinderGoalRandomStroll;
import net.minecraft.server.v1_12_R1.PathfinderGoalSelector;
import net.minecraft.server.v1_12_R1.World;

public class EnderCreeper extends EntityCreeper {

	private final double MONSTER_SPEED = 0.0d;
	private final double MONSTER_ATTACK = 0.0d;
	private final double MONSTER_FOLLOW = 4.0d;
	private final String MONSTER_NAME = Utils.color("&d&lEnder Creeper");
	
    public EnderCreeper(World world) {
      super(world);
      Set<?>  goalB = (Set<?> )getPrivateField("b", PathfinderGoalSelector.class, goalSelector); goalB.clear();
      Set<?>  goalC = (Set<?> )getPrivateField("c", PathfinderGoalSelector.class, goalSelector); goalC.clear();
      Set<?>  targetB = (Set<?> )getPrivateField("b", PathfinderGoalSelector.class, targetSelector); targetB.clear();
      Set<?>  targetC = (Set<?> )getPrivateField("c", PathfinderGoalSelector.class, targetSelector); targetC.clear();
     
      this.setPowered(true);
      this.setCustomName(MONSTER_NAME);
     
      this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget<EntityHuman>(this, EntityHuman.class, 1, true, false, null));
      this.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(MONSTER_SPEED);
      this.getAttributeInstance(GenericAttributes.ATTACK_DAMAGE).setValue(MONSTER_ATTACK);
      this.getAttributeInstance(GenericAttributes.FOLLOW_RANGE).setValue(MONSTER_FOLLOW);
      
      this.goalSelector.a(0, new PathfinderGoalFloat(this));
      this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
      this.goalSelector.a(5, new PathfinderGoalMoveTowardsRestriction(this, 0.2D));
      this.goalSelector.a(4, new PathfinderGoalMeleeAttack(this, 1.0, true));
      this.goalSelector.a(6, new PathfinderGoalMoveThroughVillage(this, 0.2D, false));
      this.goalSelector.a(7, new PathfinderGoalRandomStroll(this, 0.2D));
      this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
      this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this, false));
     }
    public static Object getPrivateField(String fieldName, Class<PathfinderGoalSelector> clazz, Object object) {
        Field field;
        Object o = null;
        try {
            field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            o = field.get(object);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return o;
    }
}
