package tk.estecka.dailymeal;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.gamerule.v1.rule.DoubleRule;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.GameRules;
import net.minecraft.world.GameRules.*;
import static net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory.createBooleanRule;
import static net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory.createDoubleRule;
import static net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory.createIntRule;

import net.fabricmc.fabric.api.gamerule.v1.CustomGameRuleCategory;

public class MealRules
{
	static public final CustomGameRuleCategory CATEGORY = new CustomGameRuleCategory(
		Identifier.of("daily-meal", "gamerules"),
		Text.translatable("gamerule.dailyMeal.category").formatted(Formatting.YELLOW, Formatting.BOLD)
	);

	static public final Key<BooleanRule> NATURAL_REGENERATION = GameRules.NATURAL_REGENERATION;
	static public final	Key<BooleanRule> DO_HEALTHBOOST = Register("doHealthBoost", createBooleanRule(true));
	static public final	Key<DoubleRule>  DAILY_BONUS_DURATION = Register("dailyBonusDuration", createDoubleRule(3.0, 0.0));
	static public final	Key<IntRule>     SLEEP_COST = Register("sleepFoodCost", createIntRule(12, 0, 20));

	static public void	Register(){
	}

	static private <T extends Rule<T>> Key<T>	Register(String name, GameRules.Type<T> type){
		return GameRuleRegistry.register("dailyMeal."+name, CATEGORY, type);
	}
}
