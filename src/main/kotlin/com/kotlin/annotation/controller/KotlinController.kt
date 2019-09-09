package com.kotlin.annotation.controller

import com.kotlin.annotation.auth.AuthController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kotlin")
class KotlinController {


    /**
     * 带权限的注解的拦截
     */
    @GetMapping("hasAnnotation")
    @AuthController(authorities = ["roleAdmin"])
    fun hasAnnotation(): String {
        return "hasAnnotation"
    }

    /**
     * 带不权限的注解的拦截
     */
    @GetMapping("hasNoAnnotation")
    fun hasNoAnnotation(): String {
        return "hasNoAnnotation"
    }
}