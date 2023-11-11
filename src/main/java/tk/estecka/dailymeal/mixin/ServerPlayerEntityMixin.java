package tk.estecka.dailymeal.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import com.mojang.datafixers.util.Either;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import tk.estecka.dailymeal.MealBonus;

@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin
{
	@Unique
	static private final Text STARVING = Text.translatable("dailyMeal.sleep.starving");

	@Inject( method="trySleep", cancellable=true, at=@At(value="INVOKE", shift=Shift.BEFORE, target="net/minecraft/server/network/ServerPlayerEntity.isCreative ()Z") )
	private void FoodRequirements(BlockPos pos, CallbackInfoReturnable<Either<?,?>> info){
		final ServerPlayerEntity player = (ServerPlayerEntity)(Object)this;

		if (!player.isCreative() && player.getHungerManager().getFoodLevel() <= MealBonus.MIN_FOOD_REQ){
			player.sendMessage(STARVING, true);
			info.setReturnValue(Either.left(PlayerEntity.SleepFailureReason.OTHER_PROBLEM));
		}
	}
}
