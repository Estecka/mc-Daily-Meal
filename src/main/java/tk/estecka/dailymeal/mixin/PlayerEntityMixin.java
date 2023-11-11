package tk.estecka.dailymeal.mixin;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin 
{
	/**
	 * @author Estecka
	 * @reason Completely eradicate food healing across the entire code.
	 */
	@Overwrite
	public boolean canFoodHeal() {
		return false;
	}
}
