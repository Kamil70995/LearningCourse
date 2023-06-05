package com.learningcourse.controller

import com.learningcourse.dto.UserDto
import com.learningcourse.entity.UserEntity
import com.learningcourse.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import javax.validation.Valid

@Controller
class AuthController(
    private val userService: UserService
) {

    // handler method to handle home page request
    @GetMapping("index")
    fun home(
        model: Model
    ): String {
        //model.addAttribute("user", userService.findAll())
        return "index"
    }

    @GetMapping("/{id}")
    fun show(@PathVariable("id") id: Long, model: Model): String {
        model.addAttribute("user", userService.findById(id))
        return "show"
    }


    @GetMapping("/login")
    fun loginForm(): String {
        return "login"
    }

    // handler method to handle user registration request
    @GetMapping("register")
    fun showRegistrationForm(model: Model): String {
        val user = UserDto()
        model.addAttribute("user", user)
        return "register"
    }

    // handler method to handle register user form submit request
    @PostMapping("/register/save")
    fun registration(
        @Valid @ModelAttribute("user") user: UserDto,
        result: BindingResult,
        model: Model
    ): String {
//        val existing: UserEntity = userService.findById(user.id!!)
        val email = user.email!!
        val existing = userService.findUserByEmail(email)
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email")
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user)
            return "register"
        }
        userService.save(user)
        return "redirect:/register?success"
    }

    @GetMapping("/users")
    fun listRegisteredUsers(model: Model): String? {
        val users: List<UserEntity> = userService.findAll()
        model.addAttribute("users", users)
        return "users"
    }
}
