package com.learningcourse.exception.dto

data class ErrorDto(
    private val errorCode: String,
    private val errorMessage: String?
)