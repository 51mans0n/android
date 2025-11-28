package com.example.weatherapp.domain.usecase

class GetListOfWeather @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.getListOfWeather()
}