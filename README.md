# Дядя Витя — Android AI-помощник рыбака

Готовый Android-проект под сборку через GitHub Actions без Android Studio на компьютере.

## Что внутри

- Kotlin + Jetpack Compose.
- Адаптивный интерфейс под телефон и планшет.
- Демо-режим без API-ключей.
- MockAIService и MockWeatherService.
- Заготовки под реальные AI / Weather / Maps API.
- Анализ места, индекс клёва, рыба, снасти, покупки, истории, чат.
- Режим речи: цензурный и 18+ после ручного включения.
- GitHub Actions для сборки APK в облаке.

## Как собрать без Android Studio

1. Создай новый репозиторий GitHub.
2. Загрузи содержимое этой папки в корень репозитория.
3. Открой `Actions`.
4. Запусти `Build Android APK in GitHub`.
5. Скачай APK из `Artifacts`.

Подробно смотри файл `GITHUB_ONLY_BUILD.md`.

## Правильная структура в GitHub

```text
app/
.github/workflows/android-build.yml
build.gradle.kts
settings.gradle.kts
gradlew
gradlew.bat
gradle.properties
README.md
```

## Демо-режим

Приложение запускается без ключей. Если ключей нет, используется mock-анализ.

## Безопасность

Прогноз клёва не является гарантией улова. Соблюдайте правила рыболовства, сезонные ограничения, нормы вылова и требования безопасности на воде.
