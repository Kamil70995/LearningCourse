package com.learningcourse.dto.user

data class CreateUserDto(
    val name: String, //имя
    val lastName: String, // фамилия
    val email: String, // mail клиента
    val password: String, // пароль
    val birthdate: String, // дата рождения
)
