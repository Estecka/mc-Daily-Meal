package tk.estecka.dailymeal;

import net.minecraft.item.FoodComponent;
import tk.estecka.dailymeal.mixin.IFoodComponentAccessor;
import static net.minecraft.item.FoodComponents.*;

public class FoodRebalance {
	static public final FoodComponent CAKE_SLICE = new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).build();

	static public void Register(){
		setQuality(0, POISONOUS_POTATO, ROTTEN_FLESH, SPIDER_EYE);
		setQuality(0.15f, CHICKEN, PUFFERFISH);
		setQuality(0.3f, BEETROOT, CARROT, COOKIE);
		setQuality(0.5f, BREAD, BAKED_POTATO, BEETROOT_SOUP, COOKED_BEEF, COOKED_CHICKEN, COOKED_COD, COOKED_MUTTON, COOKED_PORKCHOP, COOKED_RABBIT, COOKED_SALMON, PUMPKIN_PIE);

		setQuality(1f,  MUSHROOM_STEW, BEETROOT_SOUP, RABBIT_STEW, SUSPICIOUS_STEW, CAKE_SLICE);
		setEdible(true, MUSHROOM_STEW, BEETROOT_SOUP, RABBIT_STEW, SUSPICIOUS_STEW, CAKE_SLICE);
	}

	static private void	setHunger(int hunger, FoodComponent... foods){
		for (FoodComponent f : foods)
			((IFoodComponentAccessor)f).setHunger(hunger);
	}

	static private void	setQuality(float quality, FoodComponent... foods){
		for (FoodComponent f : foods)
			((IFoodComponentAccessor)f).setSaturationModifier(quality);
	}

	static private void	setEdible(boolean setEdible, FoodComponent... foods){
		for (FoodComponent f : foods)
			((IFoodComponentAccessor)f).setAlwaysEdible(setEdible);;
	}
}
