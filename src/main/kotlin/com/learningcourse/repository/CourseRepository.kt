package com.learningcourse.repository

import com.learningcourse.entity.CourseEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository : JpaRepository<CourseEntity, Long> {
}