package tk.estecka.dailymeal;

import net.fabricmc.api.ModInitializer;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Language;
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

	static public MutableText ServersideTranslatable(String key, Object ... args){
		String fallback = Language.getInstance().get(key);
		return Text.translatableWithFallback(key, fallback, args);
	}
}
