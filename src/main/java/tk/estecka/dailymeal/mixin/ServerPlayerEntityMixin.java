package tk.estecka.dailymeal.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import com.mojang.datafixers.util.Either;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import tk.estecka.dailymeal.DailyMeal;
import tk.estecka.dailymeal.MealBonus;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin
extends PlayerEntity
{
	// Prevents digestion from occuring multiple times during the same sleep.
	@Unique private boolean hasDigested = false;

	private ServerPlayerEntityMixin(){ super(null, null, 0, null); }

	@Inject( method="trySleep", cancellable=true, at=@At(value="INVOKE", shift=Shift.BEFORE, target="net/minecraft/server/network/ServerPlayerEntity.isCreative ()Z") )
	private void FoodRequirements(BlockPos pos, CallbackInfoReturnable<Either<PlayerEntity.SleepFailureReason,?>> info){
		final ServerPlayerEntity player = (ServerPlayerEntity)(Object)this;

		if (!player.isCreative() && player.getHungerManager().getFoodLevel() <= MealBonus.MIN_FOOD_REQ){
			player.sendMessage(DailyMeal.ServersideTranslatable("dailyMeal.sleep.starving"), true);
			info.setReturnValue(Either.left(PlayerEntity.SleepFailureReason.OTHER_PROBLEM));
		}
	}

	@Inject( method="playerTick", at=@At(value="INVOKE", target="net/minecraft/entity/player/PlayerEntity.tick()V") )
	public void disgest(CallbackInfo ci) {
		// Cannot succeed if the night will be skipped immediately upon sleeping enough.
		if (this.TryDigest())
			this.sendMessage(DailyMeal.ServersideTranslatable("dailyMeal.sleep.complete"));
	}

	@Inject( method="wakeUp(ZZ)V", at=@At("HEAD") )
	public void wakeUp(boolean skipSleepTimer, boolean updateSleepingPlayers, CallbackInfo ci) {
		// Fallback for when the night is skipped immediately.
		this.TryDigest();
		this.hasDigested = false;
	}

	private boolean TryDigest(){
		if (!this.hasDigested && this.canResetTimeBySleeping()){
			MealBonus.ApplyMealBonus((ServerPlayerEntity)(Object)this);
			this.hasDigested = true;
			return true;
		}
		else
			return false;
	}

}
