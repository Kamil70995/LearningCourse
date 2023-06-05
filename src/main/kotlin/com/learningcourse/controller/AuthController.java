//package com.learningcourse.controller;
//
//import com.learningcourse.dto.UserDto;
//import com.learningcourse.entity.UserEntity;
//import com.learningcourse.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@Controller
//public class AuthController {
//
//    private final UserService userService;
//
//    public AuthController(UserService userService) {
//        this.userService = userService;
//    }
//
//    // handler method to handle home page request
//    @GetMapping("index")
//    String home(/*model: Model*/) {
//        //model.addAttribute("user", userService.findAll())
//        return "index";
//    }
//
//    /*@GetMapping("/{id}")
//    fun show(@PathVariable("id") id: Long, model: Model) : String {
//        model.addAttribute("user", userService.findById(id))
//        return "show"
//    }*/
//
//
//    @GetMapping("/login")
//    String loginForm() {
//        return "login";
//    }
//
//    // handler method to handle user registration request
//    @GetMapping("register")
//    String showRegistrationForm(Model model) {
//        UserDto user = new UserDto();
//        model.addAttribute("user", user);
//        return "register";
//    }
//
//    // handler method to handle register user form submit request
//    @PostMapping("/register/save")
//    String registration(
//            @Valid @ModelAttribute("user")UserDto user,
//            BindingResult result,
//            Model model
//    ) {
////        val existing: UserEntity = userService.findById(user.id!!)
//        String email = user.getEmail();
//                UserEntity existing = userService.findUserByEmail(email);
//        if (existing != null) {
//            result.rejectValue("email", null, "There is already an account registered with that email");
//        }
//        if (result.hasErrors()) {
//            model.addAttribute("user", user);
//            return "register";
//        }
//        userService.save(user);
//        return "redirect:/register?success";
//    }
//
//    @GetMapping("/users")
//    String listRegisteredUsers(Model model) {
//         List<UserEntity> users= userService.findAll();
//        model.addAttribute("users", users);
//        return "users";
//    }
//}