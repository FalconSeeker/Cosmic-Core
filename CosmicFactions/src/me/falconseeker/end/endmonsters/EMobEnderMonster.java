package me.falconseeker.end.endmonsters;

import java.lang.reflect.Field;
import java.util.Set;

import net.minecraft.server.v1_12_R1.EntityHuman;
import net.minecraft.server.v1_12_R1.EntitySkeletonWither;
import net.minecraft.server.v1_12_R1.GenericAttributes;
import net.minecraft.server.v1_12_R1.PathfinderGoalFloat;
import net.minecraft.server.v1_12_R1.PathfinderGoalHurtByTarget;
import net.minecraft.server.v1_12_R1.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_12_R1.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_12_R1.PathfinderGoalMoveThroughVillage;
import net.minecraft.server.v1_12_R1.PathfinderGoalMoveTowardsRestriction;
import net.minecraft.server.v1_12_R1.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_12_R1.PathfinderGoalRandomStroll;
import net.minecraft.server.v1_12_R1.PathfinderGoalSelector;
import net.minecraft.server.v1_12_R1.World;

public class EMobEnderMonster extends EntitySkeletonWither {

    public EMobEnderMonster(World world) {
      super(world);
      Set<?>  goalB = (Set<?> )getPrivateField("b", PathfinderGoalSelector.class, goalSelector); goalB.clear();
      Set<?>  goalC = (Set<?> )getPrivateField("c", PathfinderGoalSelector.class, goalSelector); goalC.clear();
      Set<?>  targetB = (Set<?> )getPrivateField("b", PathfinderGoalSelector.class, targetSelector); targetB.clear();
      Set<?>  targetC = (Set<?> )getPrivateField("c", PathfinderGoalSelector.class, targetSelector); targetC.clear();
      
      this.goalSelector.a(0, new PathfinderGoalFloat(this));
      this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
      this.goalSelector.a(5, new PathfinderGoalMoveTowardsRestriction(this, 0.2D));
      this.goalSelector.a(4, new PathfinderGoalMeleeAttack(this, 1.0, true));
      this.goalSelector.a(6, new PathfinderGoalMoveThroughVillage(this, 0.2D, false));
      this.goalSelector.a(7, new PathfinderGoalRandomStroll(this, 0.2D));
      this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
     
      this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this, false));
      this.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.20000000298023224D);
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
