package tk.estecka.dailymeal.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.item.FoodComponent;

@Mixin(FoodComponent.class)
public interface IFoodComponentAccessor 
{
	@Mutable @Accessor void setHunger(int value);
	@Mutable @Accessor void setSaturationModifier(float value);
	@Mutable @Accessor void setAlwaysEdible(boolean value);
}
