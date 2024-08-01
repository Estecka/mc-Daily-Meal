package tk.estecka.dailymeal.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.player.HungerManager;
import tk.estecka.dailymeal.MealBonus;


@Mixin(InGameHud.class)
public class InGameHudMixin
{
	@Redirect( method="renderFood", at=@At(value="INVOKE", target="net/minecraft/entity/player/HungerManager.getSaturationLevel ()F") )
	private float	getHungerOverflow(HungerManager hunger){
		return hunger.getFoodLevel() - MealBonus.MIN_FOOD_REQ;
	}
}
