package tk.estecka.dailymeal.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;

/**
 * Fix for hp being lost upon reapplying the Health-Boost effect.
 */
@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin
{
	@Shadow public abstract float	getHealth();
	@Shadow public abstract void	setHealth(float value);

	@Unique
	private float boostedHealth;

	@Inject( method="onStatusEffectUpgraded", at=@At(value="INVOKE", shift=Shift.BEFORE, target="net/minecraft/entity/effect/StatusEffect.onRemoved (Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/entity/attribute/AttributeContainer;I)V") )
	private void	Backup(StatusEffectInstance effect, boolean reapplyEffect, Entity source, CallbackInfo info) {
		this.boostedHealth = this.getHealth();
	}

	@Inject( method="onStatusEffectUpgraded", at=@At(value="INVOKE", shift=Shift.AFTER, target="net/minecraft/entity/effect/StatusEffect.onApplied (Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/entity/attribute/AttributeContainer;I)V") )
	private void	Restore(StatusEffectInstance effect, boolean reapplyEffect, Entity source, CallbackInfo info) {
		this.setHealth(boostedHealth);
	}
}
