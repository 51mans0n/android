package com.example.weatherapp.domain.usecase

class GetCurrentWeatherUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(q: String) = repository.getCurrentWeather(q)
}