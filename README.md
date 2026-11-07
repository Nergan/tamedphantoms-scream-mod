# Tamed Phantoms: Scream

**[English](README.md)** · **[Русский](README.ru.md)**

An addon for [Tamed Phantoms](https://github.com/Nergan/tamedphantoms-mod) on **Minecraft 1.21.1 and 26.3**, for NeoForge and Fabric. It is the cry. Without this addon the parent never screams: not from the key, not in self-defense, not in play, and not under a full moon. There is no server switch that turns the cry off. Install one loader, not both. The NeoForge builds use [Kotlin for Forge](https://modrinth.com/mod/kotlin-for-forge), the Fabric builds use [Fabric Language Kotlin](https://modrinth.com/mod/fabric-language-kotlin).

## Features

- **Rider.** The Scream key stays in Tamed Phantoms, because the zoom out of a loop and the charged barrel roll use it. A press those maneuvers do not take makes the ridden phantom cry. The owner hears how many seconds remain when the cry is still cooling down.
- **Self-defense.** A phantom that is defending cries once, when the cry is ready.
- **Play.** A released phantom sometimes cries at a nearby mob just to watch it run. That cry does not blind.
- **Full moon.** A released phantom can cry under a full moon. Anyone who hears it gets a short sickly yellow fog, and the secret advancement Sick Moon.
- **Stacked cries.** By default, cries that land on the same creature in one moment stack: closer and more numerous cries blind longer and hurt more. Armor and Protection do not reduce that damage, and a recent hit does not cancel it. Turn `stacked_screams` off and each cry only shoves mobs and blinds once.
- **Quiet after a barrel roll.** A charged barrel roll keeps that phantom quiet for five seconds. The parent used to do this itself; the addon does it now.
- **Echo.** Other tamed phantoms of the same owner that hear the rider's cry answer once. Their answer does not start another circle.
- **Advancements.** “Winged Beast” the first time the owner makes a phantom scream, and the secret “Sick Moon” for hearing a released phantom’s full-moon cry. They sit next to the Tamed Phantoms advancements.
- **Guidebook.** The Tamed Phantoms guidebook gets a *Scream* entry in the combat chapter: with [Patchouli](https://modrinth.com/mod/patchouli) on 1.21.1 and with [Modonomicon](https://modrinth.com/mod/modonomicon) on 26.3.
- **Settings.** NeoForge uses the server config. Fabric reads `config/tamedphantomsscream-server.toml`. Radius defaults to 32 blocks (4–128), cooldown to 4 seconds (1–600), and stacked cries to on.

The addon is needed on the server and on every client. The red eyes during a cry are drawn by the parent; this addon tells it when to flash them.

## Downloads

Jars live on [GitHub Releases](https://github.com/Nergan/tamedphantoms-scream-mod/releases/latest). A push to `main` updates one release page per Minecraft version and loader. Each page has everything for this addon and for Tamed Phantoms, and `all-jars.zip` with every jar on the page. Download one set and put those files in the `mods` folder. Do not install `*-sources.jar`.

### Minecraft 1.21.1, NeoForge

| File | Required | What it is |
| --- | --- | --- |
| `tamedphantomsscream-neoforge-1.21.1-1.0.0.jar` | Yes | this addon |
| `tamedphantoms-neoforge-1.21.1-1.0.31.jar` | Yes | [Tamed Phantoms](https://github.com/Nergan/tamedphantoms-mod) 1.0.31 or newer |
| `kotlinforforge-5.8.0-all.jar` | Yes | [Kotlin for Forge](https://modrinth.com/mod/kotlin-for-forge) |
| `Patchouli-1.21.1-93-NEOFORGE.jar` | No | [Patchouli](https://modrinth.com/mod/patchouli), only for the guidebook |

### Minecraft 1.21.1, Fabric

| File | Required | What it is |
| --- | --- | --- |
| `tamedphantomsscream-fabric-1.21.1-1.0.0.jar` | Yes | this addon |
| `tamedphantoms-fabric-1.21.1-1.0.31.jar` | Yes | [Tamed Phantoms](https://github.com/Nergan/tamedphantoms-mod) 1.0.31 or newer |
| `fabric-api-0.116.17+1.21.1.jar` | Yes | [Fabric API](https://modrinth.com/mod/fabric-api) |
| `fabric-language-kotlin-1.13.2+kotlin.2.1.20.jar` | Yes | [Fabric Language Kotlin](https://modrinth.com/mod/fabric-language-kotlin) |
| `cloth-config-15.0.140-fabric.jar` | Yes | [Cloth Config](https://modrinth.com/mod/cloth-config), required by Tamed Phantoms |
| `modmenu-11.0.4.jar` | No | [Mod Menu](https://modrinth.com/mod/modmenu), opens the Tamed Phantoms config screen |
| `placeholder-api-2.4.2+1.21.jar` | No | [Text Placeholder API](https://modrinth.com/mod/placeholder-api), required by Mod Menu |
| `Patchouli-1.21.1-93-FABRIC.jar` | No | [Patchouli](https://modrinth.com/mod/patchouli), only for the guidebook |

### Minecraft 26.3, NeoForge

| File | Required | What it is |
| --- | --- | --- |
| `tamedphantomsscream-neoforge-26.3-1.0.0.jar` | Yes | this addon |
| `tamedphantoms-neoforge-26.3-1.0.31.jar` | Yes | [Tamed Phantoms](https://github.com/Nergan/tamedphantoms-mod) 1.0.31 or newer |
| `kotlinforforge-6.4.0-all.jar` | Yes | [Kotlin for Forge](https://modrinth.com/mod/kotlin-for-forge) |
| `modonomicon-26.3-neoforge-2.20.0.jar` | No | [Modonomicon](https://modrinth.com/mod/modonomicon), only for the guidebook |

### Minecraft 26.3, Fabric

| File | Required | What it is |
| --- | --- | --- |
| `tamedphantomsscream-fabric-26.3-1.0.0.jar` | Yes | this addon |
| `tamedphantoms-fabric-26.3-1.0.31.jar` | Yes | [Tamed Phantoms](https://github.com/Nergan/tamedphantoms-mod) 1.0.31 or newer |
| `fabric-api-0.162.0+26.3.jar` | Yes | [Fabric API](https://modrinth.com/mod/fabric-api) |
| `fabric-language-kotlin-1.14.2+kotlin.2.4.21.jar` | Yes | [Fabric Language Kotlin](https://modrinth.com/mod/fabric-language-kotlin) |
| `cloth-config-fabric-26.3.159.jar` | Yes | [Cloth Config](https://modrinth.com/mod/cloth-config), required by Tamed Phantoms |
| `modmenu-21.0.0.jar` | No | [Mod Menu](https://modrinth.com/mod/modmenu), opens the Tamed Phantoms config screen |
| `placeholder-api-3.2.0+26.3.jar` | No | [Text Placeholder API](https://modrinth.com/mod/placeholder-api), required by Mod Menu |
| `modonomicon-26.3-fabric-2.20.0.jar` | No | [Modonomicon](https://modrinth.com/mod/modonomicon), only for the guidebook |

## Requirements

| Component | 1.21.1 | 26.3 |
| --- | --- | --- |
| Tamed Phantoms | 1.0.31 or newer, same loader | 1.0.31 or newer, same loader |
| NeoForge | 21.1.209 or newer | 26.3.0.76 or newer |
| Kotlin for Forge | 5.8.0, **NeoForge** build | 6.4.0 |
| Fabric Loader | 0.16.10 or newer | 0.19.5 or newer |
| Fabric API | 0.116.17+1.21.1 | 0.162.0+26.3 |
| Fabric Language Kotlin | 1.13.2+kotlin.2.1.20 | 1.14.2+kotlin.2.4.21 |
| Java | 21 | 25 |

## Building

From this directory, with JDK 21 and Gradle 8.11: `gradle build --stacktrace`. The 26.3 project is `versions/26.3`, JDK 25 and Gradle 9.7.0. Until Tamed Phantoms 1.0.31 is on GitHub Releases, pass `-Ptamedphantoms_local=<path to tamedphantoms-mod>` after that parent has been built.

## License

The code is [MPL-2.0](LICENSE).
