package tk.estecka.dailymeal.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import com.mojang.datafixers.util.Either;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import tk.estecka.dailymeal.DailyMeal;
import tk.estecka.dailymeal.MealBonus;

@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin
{
	@Inject( method="trySleep", cancellable=true, at=@At(value="INVOKE", shift=Shift.BEFORE, target="net/minecraft/server/network/ServerPlayerEntity.isCreative ()Z") )
	private void FoodRequirements(BlockPos pos, CallbackInfoReturnable<Either<PlayerEntity.SleepFailureReason,?>> info){
		final ServerPlayerEntity player = (ServerPlayerEntity)(Object)this;

		if (!player.isCreative() && player.getHungerManager().getFoodLevel() <= MealBonus.MIN_FOOD_REQ){
			player.sendMessage(DailyMeal.ServersideTranslatable("dailyMeal.sleep.starving"), true);
			info.setReturnValue(Either.left(PlayerEntity.SleepFailureReason.OTHER_PROBLEM));
		}
	}
}
