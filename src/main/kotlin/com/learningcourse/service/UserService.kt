package com.learningcourse.service

import com.learningcourse.converter.toEntity
import com.learningcourse.converter.toFrontDataCourseDto
import com.learningcourse.converter.toFrontUserDto
import com.learningcourse.dto.course.FrontDataCourseDto
import com.learningcourse.dto.user.CreateUserDto
import com.learningcourse.dto.user.FrontUserDto
import com.learningcourse.dto.user.LoginUserDto
import com.learningcourse.entity.CourseEntity
import com.learningcourse.entity.UserEntity
import com.learningcourse.exception.BaseBusinessException
import com.learningcourse.exception.InternalErrorException
import com.learningcourse.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository
) {

    @Transactional
    fun createUserIfNotExists(createUserDto: CreateUserDto) {
        val userEntity = findUserByEmail(createUserDto.email)?.let {
            throw BaseBusinessException("Данный пользователь уже зарегистрирован")
        } ?: createUserDto.toEntity()

        userRepository.save(userEntity)
    }

    @Transactional
    fun loginUser(loginUserDto: LoginUserDto): FrontUserDto {
        val findUserByEmailAndPassword = findUserByEmailAndPassword(loginUserDto)
            ?: throw BaseBusinessException("Данного пользователя не существует")
        return findUserByEmailAndPassword.toFrontUserDto()
    }

    @Transactional
    fun findCoursesForUser(userId: Long): Set<FrontDataCourseDto> {
        val userEntity = userRepository.findById(userId)
            .orElseThrow { InternalErrorException("Не удалось получить курсы данного пользователя.") }

        return userEntity.courses.map { it.toFrontDataCourseDto() }.toSet()
    }

    @Transactional
    fun addCourseForUser(id: Long, courseEntity: CourseEntity) {
        val userById = userRepository.findById(id)
            .orElseThrow { InternalErrorException("Не удалось добавить курс") }
        val courses = userById.courses
        courses.add(courseEntity)
    }

    private fun findUserByEmail(email: String): UserEntity? {
        return userRepository.findByEmail(email)
    }

    private fun findUserByEmailAndPassword(loginUserDto: LoginUserDto): UserEntity? {
        return userRepository.findByEmailAndPassword(loginUserDto.email, loginUserDto.password)
    }
}