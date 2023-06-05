package com.learningcourse.repository

import com.learningcourse.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Long> {

    fun findByEmail(email: String): UserEntity?
}