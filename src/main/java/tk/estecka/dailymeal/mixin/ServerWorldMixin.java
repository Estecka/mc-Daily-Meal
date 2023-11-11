package tk.estecka.dailymeal.mixin;

import java.util.function.Consumer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import tk.estecka.dailymeal.MealBonus;

@Mixin(ServerWorld.class)
public class ServerWorldMixin 
{
	@ModifyArg( method="wakeSleepingPlayers", at=@At(value="INVOKE", target="java/util/List.forEach (Ljava/util/function/Consumer;)V") )
	private Consumer<ServerPlayerEntity> ApplyMealBonus(Consumer<ServerPlayerEntity> original){
		return player -> {
			MealBonus.ApplyMealBonus(player);
			original.accept(player);
		};
	}
}
