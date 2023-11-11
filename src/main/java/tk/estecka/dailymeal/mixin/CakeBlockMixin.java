package tk.estecka.dailymeal.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import net.minecraft.block.CakeBlock;
import tk.estecka.dailymeal.FoodRebalance;

@Mixin(CakeBlock.class)
public class CakeBlockMixin 
{
	@ModifyArg( method="tryEat", at=@At( value="INVOKE", target="net/minecraft/entity/player/PlayerEntity.canConsume (Z)Z") )
	static private boolean isEdible(boolean original){
		return FoodRebalance.CAKE_SLICE.isAlwaysEdible();
	}

	@ModifyArgs( method="tryEat", at=@At( value="INVOKE", target="net/minecraft/entity/player/HungerManager.add (IF)V") )
	static private void foodValue(Args arguments){
		arguments.set(0, (int)FoodRebalance.CAKE_SLICE.getHunger());
		arguments.set(1, (float)FoodRebalance.CAKE_SLICE.getSaturationModifier());
	}
}
