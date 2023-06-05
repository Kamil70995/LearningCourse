package com.learningcourse.controller

import com.learningcourse.dto.course.FrontCourseDto
import com.learningcourse.dto.course.FrontDataCourseDto
import com.learningcourse.service.CourseService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("courses")
class CourseController(
    private val courseService: CourseService
) {
    /**
     * Отображение всех курсов в кратком виде
     */
    @GetMapping("/all")
    fun getAllCourses(): ResponseEntity<Set<FrontDataCourseDto>> {
        val allCourses = courseService.findAllCourses()
        return ResponseEntity.ok(allCourses)
    }

    /**
     * Подробности о курсе
     */
    @GetMapping("course/{id}")
    fun getCourseDescriptionForUser(@PathVariable("id") courseId: Long): ResponseEntity<FrontCourseDto> {
        val courseById: FrontCourseDto = courseService.findCourseById(courseId)
        return ResponseEntity.ok(courseById)
    }
}