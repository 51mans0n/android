package com.example.weatherapp.domain.usecase

class AddToListUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(name: String) = repository.addToList(name)
}