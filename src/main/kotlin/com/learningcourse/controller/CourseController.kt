package com.learningcourse.controller

import com.learningcourse.entity.CourseEntity
import com.learningcourse.service.CourseService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("courses")
class CourseController(
    private val courseService: CourseService
) {
    /**
     * Форма всех курсов
     */
    @GetMapping("course/all")
    fun getAllCourses() : List<CourseEntity> {
        return courseService.findAll()
    }

    /**
     * Форма подробности о курсе
     */
    @GetMapping("course/{id}")
    fun getCourseDescriptionForUser(@PathVariable id: Long): CourseEntity {
        return courseService.findById(id)
    }
}