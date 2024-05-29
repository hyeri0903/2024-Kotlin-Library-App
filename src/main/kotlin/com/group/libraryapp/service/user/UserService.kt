package com.group.libraryapp.service.user

import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.UserLoanStatus
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.domain.user.UserStatus
import com.group.libraryapp.dto.user.UserCreateRequest
import com.group.libraryapp.dto.user.UserUpdateRequest
import com.group.libraryapp.dto.user.UserResponse
import com.group.libraryapp.dto.user.response.BookHistoryResponse
import com.group.libraryapp.dto.user.response.UserLoanHistoryResponse
import com.group.libraryapp.util.fail
import com.group.libraryapp.util.findByIdOrThrow
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,   //생성자 주입
) {

    @Transactional
    fun saveUser(request: UserCreateRequest) {
        userRepository.save(User(request.name, UserStatus.ACTIVE, request.age))
    }

    @Transactional(readOnly = true)
    fun getUsers(): List<UserResponse> {
        return userRepository.findAll()
            .map(UserResponse::of)
    }

    @Transactional
    fun updateUserName(request: UserUpdateRequest) {
        val user = userRepository.findByIdOrThrow(request.id)
        user.updateName(request.name)
    }
    @Transactional
    fun deleteUser(name: String) {
        val user = userRepository.findByName(name) ?: fail()
        userRepository.delete(user)
    }

    @Transactional(readOnly = true)
    fun getUserLoanHistories(): List<UserLoanHistoryResponse> {
        val users = userRepository.findAllWithHistories()
        return users.map { user -> UserLoanHistoryResponse.of(user) }
    }
}