# Tamed Phantoms: Scream — инструкции для AI-агентов

Аддон Minecraft 1.21.1 и 26.3 для NeoForge и Fabric к `tamedphantoms-mod`: крик в самозащите, в игре, в полнолуние и с незанятой клавиши крика. Общие правила — `../../AGENTS.md`. Раскладка как у родителя: общий код в `src/main`, NeoForge в `src/neoforge`, Fabric в проекте `fabric/`. Сборка 26.3 — отдельный проект `versions/26.3`.

## Полная актуализация

Аддон выпускается для 1.21.1 и 26.3, Fabric и NeoForge. Игровая правка аддона входит во все эти сборки. На каждой странице его релиза лежит jar родителя `tamedphantoms-mod` той же версии Minecraft, того же загрузчика и текущего `mod_version` родителя. После релиза родителя подними `tamedphantoms_version` и `tamedphantoms_version_range` и запушь аддон, только когда этот jar родителя уже скачивается. Пока на какой-то странице родитель старше, релиз аддона не актуален.

## Правила

- Прежде чем писать своё, портировать или декомпилировать, найди готовый мод, порт или форк. Веб-поиск (Google, Perplexity) малоизвестные репозитории GitHub не видит: репозиторий без звёзд и без ссылки с уже проиндексированной страницы в их индекс не попадает. Ищи каталог GitHub. Перед поиском прочитай https://github.com/aaddrick/gh-cli-search/blob/main/skills/gh-search-repos/SKILL.md и для исходников https://github.com/aaddrick/gh-cli-search/blob/main/skills/gh-search-code/SKILL.md. Нижний порог звёзд не ставь: примеры `stars:>N` в скилле применяй только если владелец просил известные проекты. Скилл https://github.com/py-sit/github-search-skill отбрасывает репозитории без лицензии, без свежих коммитов и учебные, поэтому для порта и малоизвестного мода его не открывай. Сделай несколько запросов: `gh search repos` по имени, `--match readme` и `gh search code` по mod id; для порта добавь `--include-forks true` и список форков исходного репозитория. Дефис в имени совпадает со словами запроса. Минус в начале квалификатора — исключение: такой запрос отделяй `--`, в PowerShell ещё `gh --%`. Пустое описание, ноль звёзд и пустые topics результат не отменяют. Опубликованные моды дополнительно смотри в поиске Modrinth: исходник порта часто есть только на GitHub. Свою реализацию не начинай, пока этот поиск не сделан.
- Код — Kotlin. Исключение — клиентские Java-миксины тумана и неба, потому что так же устроен родитель.
- Крик живёт здесь. В родителе нет радиуса, перезарядки, сложения криков и выключателя `rider_scream`. Клавиша, пакет `PhantomScreamPayload`, рывок из петли и заряд бочки остаются в родителе. Свободное нажатие родитель отдаёт в `TamedPhantomsApi.riderCry`. Набор бочки родитель отдаёт в `TamedPhantomsApi.rollBurst`; пять секунд тишины ставит `PhantomCry.onRollBurst`.
- API не выноси в третий мод. `TamedPhantomsApi` ссылается на `TamedPhantomEntity`, а аддоны и так зависят от jar родителя.
- Красные глаза — синхронизированное поле родителя `screamEyeTicks`. Аддон ставит его в 20, родитель сам уменьшает каждый тик до `tickCry`. Второй раз в аддоне его не уменьшай.
- Состояние крика — строка `cooldown,lock,ticks,0|1,pause` через `exportState` / `importState`. Старые миры теряют прежний `ScreamCooldown`.
- Логика сложения без Minecraft живёт в `cry/PhantomScreamStack.kt` и покрыта `PhantomScreamStackTest`.
- Достижения — JSON с критерием `minecraft:impossible` в `data/tamedphantomsscream/advancement`, выдаёт их `cry/ScreamAdvancements.kt`. Родители в дереве — достижения Tamed Phantoms.
- Урон — тип `tamedphantomsscream:scream` и два тега обхода брони и чар. В родителе этого типа больше нет.
- `tamedphantoms_version` равен текущему `mod_version` родителя, диапазон `[x.y.z,)`. То же число стоит в README и `modrinth.md`. Пока нужного jar родителя на странице релиза нет, собирай с `-Ptamedphantoms_local=<каталог tamedphantoms-mod>`.
- Страница книги лежит в пространстве имён родителя. На 1.21.1 это Patchouli, на 26.3 — Modonomicon. Ключ `extend` не используй.
- Fabric читает `config/tamedphantomsscream-server.toml`, не мир. NeoForge — серверный конфиг, на 26.3 тип переписывается в `SYNCED`.
- Туман полнолуния: на 1.21.1 NeoForge это `MoonSkyMixin` плюс `ViewportEvent.ComputeFogColor`, на Fabric — `PhantomFogMixin`. На 26.3 NeoForge хватает события тумана. На 26.3 Fabric — `MoonFogMixin` в `versions/26.3/fabric`. Второй миксин тумана на NeoForge не добавляй: цвет сложится дважды.
- McnCDN у аддона нет. Новый пакет на CDN не заводи без прямой просьбы владельца.
- Коммит и пуш — только когда владелец прямо просит. Теги `minecraft-*` двигает workflow релиза.

## Сборка 26.3

`versions/26.3` копирует общий Kotlin задачей `sharedKotlin` и переписывает строки функцией `rewriteFor26`. После смены правил подними `rewriteStamp`. Строки, которые должны совпасть дословно: `FMLEnvironment.dist`, `ModConfig.Type.SERVER`, `.displayClientMessage(`, `player.server.advancements.get(advancementId)`, `player.advancements.award`, `PayloadTypeRegistry.playS2C()`, `fun isFullMoonNight(level: ServerLevel): Boolean = level.moonPhase == 0 && level.isNight`, `registryOrThrow(...).getHolderOrThrow(key)`, `living.invulnerableTime = 0`, `living.hurt(DamageSource(holder), amount)`, `mob is FlyingMob || `.

## Готово

Из каталога аддона: `gradle build --stacktrace` (Gradle 8.11, JDK 21), затем `runClient` и `:fabric:runClient` до главного меню, `runServer` и `:fabric:runServer` до `Done`. То же в `versions/26.3` на Gradle 9.7.0 и JDK 25, сервер слушает `25567`. Складывание криков проверяет `PhantomScreamStackTest`.

## Modrinth

На Modrinth у каждой пары версии Minecraft и загрузчика одна версия: самая новая. Релиз снимает прежние версии этого слота и ставит на их место текущий jar.

## Craft Anything

[Craft Anything](https://github.com/storytold/craft-anything) — ранняя альфа. Она смотрит, как устроена чужая программа, сайт или игра, и только по отдельной просьбе владельца собирает свою версию. Агенту достаточно `craft-anything-cli`; те же средства отдаёт `craft-anything-cli mcp`. Если команды нет, в середине задачи её не ставить и чужой файл вместо неё не вскрывать.

По умолчанию чистая комната: исходник, файлы и код страницы закрыты. Наружу попадает только видимое: снимок, текст, размеры, цвета, шрифты, открытые меню. Deep включается флагом `--deep` и читает код и файлы своими декодерами, а при установленной Ghidra ещё и ей. Это не песочница системы и не обход защиты, входа или античита. Цель берут только ту, которую владелец имеет право изучать. Логотипы, фотографии и чужой текст в репозиторий не копируют. Запись инструмента — свидетельство с уверенностью и оговорками, не замена нашему коду. Новая сборка по умолчанию уходит в `Documents/Craft Anything`. Править этот репозиторий ею можно только когда владелец просил сборку, с `--project-folder` на каталог репозитория и `--existing edit`. Установка зависимостей выполняет код пакетов; согласие «always allow» для `npm` не давать. Сверка сайта на трёх ширинах уже работает, сверка поведения программ и игр ещё неполная. Статус — `docs/STATUS.md` в том репозитории.

Аддон крика. Родитель — исходник `tamedphantoms-mod`, его jar не вскрывать. Версия аддона и jar родителя на релизе сверяются как в разделе актуализации, не отчётом инструмента. Deep выключен. Новую сборку аддона в `Documents/Craft Anything` не уводить.
