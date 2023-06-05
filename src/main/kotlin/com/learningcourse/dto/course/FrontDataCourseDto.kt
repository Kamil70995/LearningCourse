package com.learningcourse.dto.course

import java.time.LocalDate

data class FrontDataCourseDto (
    val courseTitle: String,
    val courseUploadDate: LocalDate
)