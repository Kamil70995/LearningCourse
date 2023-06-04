package com.learningcourse.service

import com.learningcourse.entity.CourseEntity
import com.learningcourse.entity.UserEntity
import com.learningcourse.repository.CourseRepository
import org.springframework.stereotype.Component

@Component
class CourseService(
    private val courseRepository: CourseRepository
) {

    fun findById(id: Long) : CourseEntity {
        return courseRepository.findById(id).orElseThrow()
    }
    fun findAll(): List<CourseEntity> {
        return courseRepository.findAll()
    }

    fun save(course: CourseEntity) : CourseEntity {
        return courseRepository.save(course)
    }
}