package tk.estecka.dailymeal.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import tk.estecka.dailymeal.MealBonus;

@Mixin(InGameHud.class)
public class InGameHudMixin 
{
	@Redirect( method="renderStatusBars", at=@At(value="INVOKE", target="net/minecraft/entity/player/HungerManager.getSaturationLevel ()F") )
	private float	getHungerOverflow(HungerManager hunger, @Local PlayerEntity player){
		return hunger.getFoodLevel() - MealBonus.MIN_FOOD_REQ;
	}
}
