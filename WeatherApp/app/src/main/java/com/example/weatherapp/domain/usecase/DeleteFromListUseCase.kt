package com.example.weatherapp.domain.usecase

class DeleteFromListUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(name: String) = repository.deleteFromList(name)
}