# Daily Meal

A hunger rework that aims to brings food away from the field and back at home.

Eating and being at full hunger no longer brings any immediate advantage. Instead, the food bar is consumed when sleeping, in exchange for day-long bonuses.

This mod was balanced around a single-player experience; player who don't participate in skipping the nigh may end up disadvantaged.

## Mechanics
### Sleeping
All food-related bonuses are cashed-out upon skipping the night.
Sleeping requires at least 3 food pips (same as for sprinting), but may consume a different amount.

Sleeping will immediately heal you back to full.

Sleeping with a full hunger bar will grant you **Regeneration I**.

All Saturation is consumed in exchange for a **Health Boost** of varying potency, up to +10 hearts.


### Gamerules
- `naturalRegeneration` _(Vanilla. Default True)_ now controls whether sleeping provides any healing and regeneration.
- `dailyMeal.doHealthBoost` _(Default true)_ Whether sleeping grants any health boost. 
- `dailyMeal.dailyBonusDuration` _(Default 3)_ How many in-game days the bonuses last. The default of 3 aligns with the apparition of phantoms. 
- `dailyMeal.sleepFoodCost` _(Default 12)_ The amount of food points (half-pip) consumed when sleeping.

### Food Rebalance
The stats of most vanilla food were adjusted such that:
- Uncooked food offer the lowest amount of Saturation.
- Single-ingredient or stackable cooked food offers moderate Saturation.
- Non-stackable food and food with many ingredients offer greatly increased Saturation, and can be consumed at any time.
- The Beetroot Soup (non-stackable) now requires multiple ingredients to craft.

### Other changes
- _(Clientside)_ The hunger bar no longer wiggles when you have no saturation. Instead, it wiggles when you don't have enough food to sleep.
