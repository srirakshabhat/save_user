package com.digicollect.baatu.domain.usecases

import com.baatu.assignment.data.model.UserItem
import com.digicollect.baatu.domain.repository.UserLocalRepository

class SaveUserUseCase(private val userLocalRepository:UserLocalRepository) {
  suspend fun execute(userItem:UserItem) = userLocalRepository.inserUserData(userItem)
}