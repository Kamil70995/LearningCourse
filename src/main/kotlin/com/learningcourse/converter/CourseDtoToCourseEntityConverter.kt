@file:JvmName("CourseDtoToCourseEntityConverter")

package com.learningcourse.converter

import com.learningcourse.dto.course.FrontCourseDto
import com.learningcourse.dto.course.FrontDataCourseDto
import com.learningcourse.entity.CourseEntity

fun CourseEntity.toFrontCourseDto() = FrontCourseDto(
    this.courseTitle,
    this.courseUploadDate
).also {

    val testForCourse = this.tests
    val testDtoListForFront = testForCourse.map {entity -> entity.toTestFrontDto() }.toSet()

    it.id = this.id
    it.content = this.content
    it.authorDto = this.courseAuthor.toAuthorFrontDto()
    it.testDto = testDtoListForFront
}

fun CourseEntity.toFrontDataCourseDto() = FrontDataCourseDto(
    this.courseTitle,
    this.courseUploadDate
)

