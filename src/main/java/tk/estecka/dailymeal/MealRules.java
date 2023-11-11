package tk.estecka.dailymeal;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.gamerule.v1.rule.DoubleRule;
import net.minecraft.world.GameRules;
import net.minecraft.world.GameRules.*;
import static net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory.createDoubleRule;
import static net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory.createIntRule;

public class MealRules
{
	static public final Key<BooleanRule> NATURAL_REGENERATION = GameRules.NATURAL_REGENERATION;
	static public final	Key<DoubleRule>  DAILY_BONUS_DURATION = Register("dailyBonusDuration", createDoubleRule(1.0, 0.0));
	static public final	Key<IntRule>     SLEEP_COST = Register("sleepFoodCost", createIntRule(12, 0, 20));

	static public void	Register(){
	}

	static private <T extends Rule<T>> Key<T>	Register(String name, GameRules.Type<T> type){
		return GameRuleRegistry.register("dailyMeal."+name, Category.PLAYER, type);
	}
}
