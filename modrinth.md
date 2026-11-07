Phantoms cry. An addon for [Tamed Phantoms](https://github.com/Nergan/tamedphantoms-mod) on Minecraft 1.21.1 and 26.3, for NeoForge and Fabric. Install one loader, not both.

Without this addon the parent never screams. There is no server switch that turns the cry back on inside the parent.

## What it does

- **Rider.** The Scream key stays in Tamed Phantoms. A press that the zoom out of a loop and the charged barrel roll do not take makes the ridden phantom cry.
- **Self-defense, play, and the full moon.** A defending phantom cries once. A released phantom sometimes cries at a nearby mob without blinding it, and under a full moon the cry tints the fog a sickly yellow.
- **Stacked cries.** Cries that land together blind longer and hurt more the closer and more numerous they are. Armor does not reduce that damage. `stacked_screams` can turn the stack off.
- **Quiet after a barrel roll.** A charged barrel roll keeps that phantom quiet for five seconds.
- **Advancements.** Winged Beast, and the secret Sick Moon.
- **Guidebook.** The Tamed Phantoms guidebook gets a *Scream* entry: with Patchouli on 1.21.1, with Modonomicon on 26.3.

The addon is needed on the server and on every client. Radius, cooldown, and stacked cries are this addon's settings.

## 1.21.1 NeoForge

Required: `tamedphantomsscream-neoforge-1.21.1-1.0.0.jar`, Tamed Phantoms 1.0.31 or newer, and Kotlin for Forge 5.8.0 (`kotlinforforge-neoforge`). Optional: Patchouli `1.21.1-93-neoforge` for the guidebook entry.

## 1.21.1 Fabric

Required: `tamedphantomsscream-fabric-1.21.1-1.0.0.jar`, Tamed Phantoms `1.0.31-fabric` or newer, Fabric API `0.116.17+1.21.1`, Fabric Language Kotlin `1.13.2+kotlin.2.1.20`, and Cloth Config `15.0.140` for Tamed Phantoms. Optional: Mod Menu 11.0.4 with Text Placeholder API for the Tamed Phantoms config screen, Patchouli `1.21.1-93-fabric` for the guidebook entry.

## 26.3 NeoForge

Required: `tamedphantomsscream-neoforge-26.3-1.0.0.jar`, Tamed Phantoms `1.0.31+26.3` or newer, and Kotlin for Forge 6.4.0. Optional: Modonomicon `26.3-2.20.0` for the guidebook entry.

## 26.3 Fabric

Required: `tamedphantomsscream-fabric-26.3-1.0.0.jar`, Tamed Phantoms `1.0.31+26.3-fabric` or newer, Fabric API `0.162.0+26.3`, Fabric Language Kotlin `1.14.2+kotlin.2.4.21`, and Cloth Config `26.3.159` for Tamed Phantoms. Optional: Mod Menu 21.0.0 with Text Placeholder API for the config screen, Modonomicon `26.3-2.20.0` for the guidebook entry.

The source code and every release jar, with all the jars Tamed Phantoms needs, are on [GitHub](https://github.com/Nergan/tamedphantoms-scream-mod). License: MPL-2.0.
