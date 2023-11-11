package tk.estecka.dailymeal;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DailyMeal 
implements ModInitializer 
{
	static public final Logger LOGGER = LoggerFactory.getLogger("daily-meal");

	@Override
	public void onInitialize() {
		MealRules.Register();
		FoodRebalance.Register();
	}
}
