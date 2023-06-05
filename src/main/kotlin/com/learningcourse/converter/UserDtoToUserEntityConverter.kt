@file:JvmName("UserDtoToUserEntityConverter")

package com.learningcourse.converter

import com.learningcourse.dto.user.CreateUserDto
import com.learningcourse.dto.user.FrontUserDto
import com.learningcourse.entity.UserEntity
import java.time.LocalDate

fun CreateUserDto.toEntity() =
    UserEntity(this.name, this.lastName, this.email, this.password, LocalDate.parse(this.birthdate))

fun UserEntity.toFrontUserDto(): FrontUserDto {

    val userCourses = this.courses

    val userCoursesDto = userCourses.map { it.toFrontDataCourseDto() }.toSet()

    return FrontUserDto(
        this.name,
        this.lastName,
        this.email,
        this.password,
        this.birthdate,
        userCoursesDto
    ).also { it.id = this.id }
}
