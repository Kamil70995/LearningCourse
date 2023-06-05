package com.learningcourse.dto.author

data class FrontAuthorDto(
    val name: String,
    val lastName: String,
    val email: String
) {
    var id: Long? = null
}