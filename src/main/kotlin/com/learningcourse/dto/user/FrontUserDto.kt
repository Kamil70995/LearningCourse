package com.learningcourse.dto.user

import com.learningcourse.dto.course.FrontDataCourseDto
import java.time.LocalDate

data class FrontUserDto(
    val name: String, //имя
    val lastName: String, // фамилия
    val email: String, // mail клиента
    val password: String, // пароль
    val birthdate: LocalDate, // дата рождения
    val courses: Set<FrontDataCourseDto>
) {
    var id: Long? = null
}