package com.learningcourse.service

import com.learningcourse.dto.UserDto
import com.learningcourse.entity.CourseEntity
import com.learningcourse.entity.UserEntity
import com.learningcourse.repository.UserRepository
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class UserService(
    private val userRepository: UserRepository
) {

    fun getCoursesForUser(id: Long): Set<CourseEntity> {
        val userById = userRepository.findById(id).orElseThrow()
        return userById.courses
    }

    fun addCourseForUser(id: Long, courseEntity: CourseEntity) {
        val userById = userRepository.findById(id).orElseThrow()
        val courses = userById.courses
        courses.add(courseEntity)
    }

    fun findAll(): List<UserEntity> {
        return userRepository.findAll()
    }

    fun save(user: UserEntity): UserEntity {
        return userRepository.save(user)
    }

    fun save(user: UserDto): UserEntity {
        val userEntity = UserEntity(
            user.name!!,
            user.lastName!!,
            user.email!!,
            user.password!!,
            LocalDate.parse(user.birthdate)!!
        )
        return userRepository.save(userEntity)
    }

    fun findById(id: Long): UserEntity {
        return userRepository.findById(id).orElseThrow()
    }

    fun findUserByEmail(email: String): UserEntity? {
        return userRepository.findByEmail(email)
    }
}