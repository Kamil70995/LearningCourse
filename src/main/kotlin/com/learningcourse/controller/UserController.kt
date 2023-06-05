package com.learningcourse.controller

import com.learningcourse.entity.CourseEntity
import com.learningcourse.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("users")
class UserController(
    private val userService: UserService
) {
    /**
     * форма всех курсов у клиента
     */
    @GetMapping("course/all")
    fun getCoursesForUser(@PathVariable id: Long) {
        userService.getCoursesForUser(id)
    }

    /**
     * Форма добавления курса для клиента
     */
    @PostMapping("course/{id}")
    fun addCourseForUser(@PathVariable id: Long, courseEntity: CourseEntity) {
        userService.addCourseForUser(id, courseEntity)
    }
}