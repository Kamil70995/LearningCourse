package com.learningcourse.controller

import com.learningcourse.dto.course.FrontDataCourseDto
import com.learningcourse.dto.user.CreateUserDto
import com.learningcourse.dto.user.FrontUserDto
import com.learningcourse.dto.user.LoginUserDto
import com.learningcourse.entity.CourseEntity
import com.learningcourse.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("users")
@RestController
class UserController(
    private val userService: UserService
) {

    /**
     * Добавление нового пользователя
     */
    @PostMapping("/create")
    fun createUser(@RequestBody createUserDto: CreateUserDto): ResponseEntity<Void> {
        userService.createUserIfNotExists(createUserDto)
        return ResponseEntity(HttpStatus.CREATED)
    }

    /**
     * Логин пользователя
     */
    @GetMapping("/login")
    fun loginUser(@RequestBody loginUserDto: LoginUserDto): ResponseEntity<FrontUserDto> {
        val loginUser: FrontUserDto = userService.loginUser(loginUserDto)
        return ResponseEntity.ok(loginUser)
    }

    /**
     * Поиск всех курсов у пользователя
     */
    @GetMapping("courses/{id}")
    fun getCoursesForUser(@PathVariable("id") userId: Long): ResponseEntity<Set<FrontDataCourseDto>> {
        val coursesForUser = userService.findCoursesForUser(userId)
        return ResponseEntity.ok(coursesForUser)
    }

    /**
     * Добавление курса для пользователя
     */
    @PostMapping("course/{id}")
    fun addCourseForUser(@PathVariable("id") userId: Long, courseEntity: CourseEntity): ResponseEntity<Void> {
        userService.addCourseForUser(userId, courseEntity)
        return ResponseEntity(HttpStatus.OK)
    }
}