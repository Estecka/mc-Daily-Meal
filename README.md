# Daily Meal

A hunger rework that brings food away from the battlefield and back at home.

Being at full hunger no longer brings any immediate advantage. Instead, food is consumed when sleeping, in exchange for day-long bonuses.

## Mechanics
### Sleeping
All food-related bonuses are cashed-out upon skipping the night. Sleeping requires at least 6 food points. It consumes all Saturation, and some of food points down to a minimum of 2.

Sleeping with any amount of food will immediately heal you back to full.

Sleeping with a full hunger bar will grant you **Regeneration**.
Additionally, a **Health Boost** of varying potency will be granted based on how much Saturation you have, up to +10 hearts.


### Gamerules
- `naturalRegeneration` _(Vanilla. Default True)_ now controls whether sleeping provides any healing and regeneration.
- `dailyMeal.dailyBonusDuration` _(Default 1.0)_ controls how many in-game days the bonuses last.
- `dailyMeal.sleepFoodCost` _(Default 12)_ The amount of food points consumed when sleeping.

### Food Rebalance
The stats of most vanilla food were adjusted such that:
- Uncooked food offer the lowest amount of Saturation.
- Single-ingredient or stackable cooked food offers moderate Saturation.
- Non-stackable food and food with many ingredients offer greatly increased Saturation, and can be consumed at any time.
- The Beetroot Soup (non-stackable) now requires multiple ingredients to craft.

### Other changes
- Fixes an issue that causes bonus hearts to be emptied when the Health Boost Effect is reapplied.
- _(Clientside)_ The hunger bar no longer wiggles when you have no saturation. Instead, it wiggles when you don't have enough food to sleep.
