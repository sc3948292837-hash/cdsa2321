# API-ключи и реальные сервисы

Проект специально сделан так, чтобы запускаться без ключей.

## Где хранить ключи

Ключи нельзя жёстко вшивать в код. Используй `local.properties`:

```properties
MAPS_API_KEY=your_google_maps_key
WEATHER_API_KEY=your_weather_key
AI_API_KEY=your_ai_key
```

## AI API

Сейчас используется `MockAIService`. Для боевого режима:

1. Открой `services/AIService.kt`.
2. В `RealAIService` добавь HTTP-запрос к выбранному API.
3. Передавай системный промт из `PromptBuilder.systemPrompt()`.
4. Обрабатывай ошибки и fallback на mock.

## Weather API

Сейчас используется `MockWeatherService`. Для боевого режима:

1. Открой `services/WeatherService.kt`.
2. В `RealWeatherService` добавь запрос к погодному API.
3. Верни данные в модель `WeatherReport`.

## Google Maps

Ключ передаётся через manifest placeholder `MAPS_API_KEY`. В боевом проекте добавь чтение из `local.properties` в Gradle и не публикуй ключ в репозиторий.

## Безопасность

- не публикуй `local.properties`;
- добавь ограничения ключей в Google Cloud Console;
- для production лучше проксировать AI-запросы через backend.
