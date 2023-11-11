package tk.estecka.dailymeal;

import org.joml.Math;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.GameRules;

public class MealBonus 
{
	static public final int DAILIGHT_CYCLE_DURATION = 24_000;
	static public final int MIN_FOOD_REQ = 6;

	static public void	ApplyMealBonus(ServerPlayerEntity player) {
		final HungerManager hunger = player.getHungerManager();
		final GameRules rules = player.getWorld().getGameRules();

		final boolean doRegen = rules.getBoolean(MealRules.NATURAL_REGENERATION);
		final int duration = (int)(DAILIGHT_CYCLE_DURATION * rules.get(MealRules.DAILY_BONUS_DURATION).get());
		final int foodCost = rules.getInt(MealRules.SLEEP_COST);

		int foodLevel = hunger.getFoodLevel();
		boolean isFull = !hunger.isNotFull();

		if (foodLevel >= 2){
			hunger.setFoodLevel(Math.max(2, foodLevel - foodCost));
			if (doRegen)
				player.heal(player.getMaxHealth());
		}

		if (doRegen && isFull){
			player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, duration, 0, false, false));
		}
		
		if (isFull && hunger.getSaturationLevel() >= 4){
			int potency = (int)(hunger.getSaturationLevel() / 4) - 1;
			player.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, duration, potency, false, false));
		}

		hunger.setExhaustion(0);
		hunger.setSaturationLevel(0);
	}
}
