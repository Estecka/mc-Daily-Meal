package tk.estecka.dailymeal.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import net.minecraft.entity.player.HungerManager;

@Mixin(HungerManager.class)
public interface IHungerManagerAccessor
{
	@Accessor void setExhaustion(float value);
}
