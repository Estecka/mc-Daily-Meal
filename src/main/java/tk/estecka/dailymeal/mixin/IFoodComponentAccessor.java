package tk.estecka.dailymeal.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;
import net.minecraft.component.type.FoodComponent;


@Mixin(FoodComponent.class)
public interface IFoodComponentAccessor
{
	@Mutable @Accessor void setNutrition(int value);
	@Mutable @Accessor void setSaturation(float value);
	@Mutable @Accessor void setCanAlwaysEat(boolean value);
}
