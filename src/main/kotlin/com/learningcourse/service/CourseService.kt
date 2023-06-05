package com.learningcourse.service

import com.learningcourse.converter.toFrontCourseDto
import com.learningcourse.converter.toFrontDataCourseDto
import com.learningcourse.dto.course.FrontCourseDto
import com.learningcourse.dto.course.FrontDataCourseDto
import com.learningcourse.entity.CourseEntity
import com.learningcourse.exception.InternalErrorException
import com.learningcourse.repository.CourseRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CourseService(
    private val courseRepository: CourseRepository
) {

    @Transactional
    fun findCourseById(courseId: Long): FrontCourseDto {
        val courseById: CourseEntity = courseRepository.findById(courseId)
            .orElseThrow { InternalErrorException("Невозможно отобразить информацию о курсе") }
        return courseById.toFrontCourseDto()
    }

    @Transactional
    fun findAllCourses(): Set<FrontDataCourseDto> {
        return courseRepository.findAll().map { it.toFrontDataCourseDto() }.toSet()
    }
}