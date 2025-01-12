# Minecraft versions breaking changes

## 1.19.4
Initial Release

## 1.20.0
- Not documented. No code change required; may still require recompilation.

## 1.20.2
- Minecraft fixed health-boost re-application. The mod's own fix is no longer required.

## 1.21.0
- Rendering of hunger bar changed.
- Foodcomponent overhaul

## 1.21.2 ~ 1.21.4
- Recipe data format changed.
- `HungerManager::getExhaustion` was removed, use an accessor instead.
- `PlayerEntity::sendMessage`'s second parameter is no longer optional.
