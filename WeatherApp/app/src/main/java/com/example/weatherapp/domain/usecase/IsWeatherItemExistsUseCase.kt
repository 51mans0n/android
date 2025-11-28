package com.example.weatherapp.domain.usecase

class IsWeatherItemExistsUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(name: String) = repository.isWeatherItemExists(name)
}