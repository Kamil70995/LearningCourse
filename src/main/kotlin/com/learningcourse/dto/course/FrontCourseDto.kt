package com.learningcourse.dto.course

import com.learningcourse.dto.author.FrontAuthorDto
import com.learningcourse.dto.test.FrontTestDto
import java.time.LocalDate

data class FrontCourseDto(
    val courseTitle: String,
    val courseUploadDate: LocalDate
) {
    var id: Long? = null
    var content: String? = null
    var authorDto: FrontAuthorDto? = null
    var testDto: Set<FrontTestDto>? = setOf()
}