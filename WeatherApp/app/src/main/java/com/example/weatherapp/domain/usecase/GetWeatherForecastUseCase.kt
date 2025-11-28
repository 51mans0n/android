package com.example.weatherapp.domain.usecase

class GetWeatherForecastUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(q: String, days: Int) = repository.getWeatherForecast(q, days)
}