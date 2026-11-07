# Tamed Phantoms: Scream

**[English](README.md)** · **[Русский](README.ru.md)**

Аддон для [Tamed Phantoms](https://github.com/Nergan/tamedphantoms-mod) на **Minecraft 1.21.1 и 26.3**, NeoForge и Fabric. Это и есть крик. Без этого аддона родитель не кричит вообще: ни с клавиши, ни в самозащите, ни в игре, ни в полнолуние. Серверного выключателя крика нет. Ставьте один загрузчик, не оба. Сборки NeoForge требуют [Kotlin for Forge](https://modrinth.com/mod/kotlin-for-forge), сборки Fabric — [Fabric Language Kotlin](https://modrinth.com/mod/fabric-language-kotlin).

## Возможности

- **Седок.** Клавиша крика остаётся в Tamed Phantoms: ею выходят из петли и заряжают бочку. Нажатие, которое эти приёмы не забрали, заставляет фантома крикнуть. Если крик ещё остывает, хозяин видит, сколько секунд осталось.
- **Самозащита.** Фантом, который защищается, кричит один раз, когда крик готов.
- **Игра.** Освобождённый фантом иногда кричит на моба рядом, просто чтобы тот убежал. Такой крик не ослепляет.
- **Полнолуние.** Освобождённый фантом может крикнуть в полнолуние. Кто слышит, на секунду видит болезненно-жёлтый туман и получает секретное достижение «Больная луна».
- **Сложенные крики.** По умолчанию крики, которые попали в одно существо в один момент, складываются: чем ближе и чем их больше, тем дольше слепота и тем больше урон. Броня и Защита этот урон не режут, и недавний удар его не отменяет. Выключите `stacked_screams`, и каждый крик только толкает мобов и ослепляет один раз.
- **Тишина после бочки.** Заряженная бочка пять секунд не даёт этому фантому кричать.
- **Эхо.** Другие прирученные фантомы того же хозяина, которые слышат крик седока, отвечают один раз. Их ответ новый круг не поднимает.
- **Достижения.** «Крылатая тварь» за первый крик хозяина и секретное «Больная луна» за крик освобождённого фантома в полнолуние. Они стоят рядом с достижениями Tamed Phantoms.
- **Гайд.** В книгу Tamed Phantoms добавляется запись «Крик» в главе боя: с [Patchouli](https://modrinth.com/mod/patchouli) на 1.21.1 и с [Modonomicon](https://modrinth.com/mod/modonomicon) на 26.3.
- **Настройки.** У NeoForge это серверный конфиг. Fabric читает `config/tamedphantomsscream-server.toml`. Радиус по умолчанию 32 блока (4–128), перезарядка 4 секунды (1–600), сложенные крики включены.

Аддон нужен и на сервере, и на каждом клиенте. Красные глаза на время крика рисует родитель; этот аддон говорит ему, когда их зажечь.

## Загрузки

Jar лежат на [GitHub Releases](https://github.com/Nergan/tamedphantoms-scream-mod/releases/latest). Пуш в `main` обновляет одну страницу релиза на каждую пару версии Minecraft и загрузчика. На странице есть всё для этого аддона и для Tamed Phantoms, и `all-jars.zip` со всеми jar страницы. Скачайте один набор и положите файлы в папку `mods`. Не ставьте `*-sources.jar`.

### Minecraft 1.21.1, NeoForge

| Файл | Нужен | Что это |
| --- | --- | --- |
| `tamedphantomsscream-neoforge-1.21.1-1.0.0.jar` | Да | этот аддон |
| `tamedphantoms-neoforge-1.21.1-1.0.32.jar` | Да | [Tamed Phantoms](https://github.com/Nergan/tamedphantoms-mod) 1.0.32 или новее |
| `kotlinforforge-5.8.0-all.jar` | Да | [Kotlin for Forge](https://modrinth.com/mod/kotlin-for-forge) |
| `Patchouli-1.21.1-93-NEOFORGE.jar` | Нет | [Patchouli](https://modrinth.com/mod/patchouli), только для книги |

### Minecraft 1.21.1, Fabric

| Файл | Нужен | Что это |
| --- | --- | --- |
| `tamedphantomsscream-fabric-1.21.1-1.0.0.jar` | Да | этот аддон |
| `tamedphantoms-fabric-1.21.1-1.0.32.jar` | Да | [Tamed Phantoms](https://github.com/Nergan/tamedphantoms-mod) 1.0.32 или новее |
| `fabric-api-0.116.17+1.21.1.jar` | Да | [Fabric API](https://modrinth.com/mod/fabric-api) |
| `fabric-language-kotlin-1.13.2+kotlin.2.1.20.jar` | Да | [Fabric Language Kotlin](https://modrinth.com/mod/fabric-language-kotlin) |
| `cloth-config-15.0.140-fabric.jar` | Да | [Cloth Config](https://modrinth.com/mod/cloth-config), нужен Tamed Phantoms |
| `modmenu-11.0.4.jar` | Нет | [Mod Menu](https://modrinth.com/mod/modmenu), открывает экран настроек Tamed Phantoms |
| `placeholder-api-2.4.2+1.21.jar` | Нет | [Text Placeholder API](https://modrinth.com/mod/placeholder-api), нужен Mod Menu |
| `Patchouli-1.21.1-93-FABRIC.jar` | Нет | [Patchouli](https://modrinth.com/mod/patchouli), только для книги |

### Minecraft 26.3, NeoForge

| Файл | Нужен | Что это |
| --- | --- | --- |
| `tamedphantomsscream-neoforge-26.3-1.0.0.jar` | Да | этот аддон |
| `tamedphantoms-neoforge-26.3-1.0.32.jar` | Да | [Tamed Phantoms](https://github.com/Nergan/tamedphantoms-mod) 1.0.32 или новее |
| `kotlinforforge-6.4.0-all.jar` | Да | [Kotlin for Forge](https://modrinth.com/mod/kotlin-for-forge) |
| `modonomicon-26.3-neoforge-2.20.0.jar` | Нет | [Modonomicon](https://modrinth.com/mod/modonomicon), только для книги |

### Minecraft 26.3, Fabric

| Файл | Нужен | Что это |
| --- | --- | --- |
| `tamedphantomsscream-fabric-26.3-1.0.0.jar` | Да | этот аддон |
| `tamedphantoms-fabric-26.3-1.0.32.jar` | Да | [Tamed Phantoms](https://github.com/Nergan/tamedphantoms-mod) 1.0.32 или новее |
| `fabric-api-0.162.0+26.3.jar` | Да | [Fabric API](https://modrinth.com/mod/fabric-api) |
| `fabric-language-kotlin-1.14.2+kotlin.2.4.21.jar` | Да | [Fabric Language Kotlin](https://modrinth.com/mod/fabric-language-kotlin) |
| `cloth-config-fabric-26.3.159.jar` | Да | [Cloth Config](https://modrinth.com/mod/cloth-config), нужен Tamed Phantoms |
| `modmenu-21.0.0.jar` | Нет | [Mod Menu](https://modrinth.com/mod/modmenu), открывает экран настроек Tamed Phantoms |
| `placeholder-api-3.2.0+26.3.jar` | Нет | [Text Placeholder API](https://modrinth.com/mod/placeholder-api), нужен Mod Menu |
| `modonomicon-26.3-fabric-2.20.0.jar` | Нет | [Modonomicon](https://modrinth.com/mod/modonomicon), только для книги |

## Требования

| Компонент | 1.21.1 | 26.3 |
| --- | --- | --- |
| Tamed Phantoms | 1.0.32 или новее, тот же загрузчик | 1.0.32 или новее, тот же загрузчик |
| NeoForge | 21.1.209 или новее | 26.3.0.76 или новее |
| Kotlin for Forge | 5.8.0, сборка **NeoForge** | 6.4.0 |
| Fabric Loader | 0.16.10 или новее | 0.19.5 или новее |
| Fabric API | 0.116.17+1.21.1 | 0.162.0+26.3 |
| Fabric Language Kotlin | 1.13.2+kotlin.2.1.20 | 1.14.2+kotlin.2.4.21 |
| Java | 21 | 25 |

## Сборка

Из этого каталога, JDK 21 и Gradle 8.11: `gradle build --stacktrace`. Проект 26.3 — `versions/26.3`, JDK 25 и Gradle 9.7.0. Если этого jar Tamed Phantoms ещё нет на GitHub Releases, передайте `-Ptamedphantoms_local=<путь к tamedphantoms-mod>` после сборки родителя.

## Лицензия

Код — [MPL-2.0](LICENSE).
