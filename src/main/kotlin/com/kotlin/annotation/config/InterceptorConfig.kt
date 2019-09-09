package com.kotlin.annotation.config

import com.kotlin.annotation.auth.filter.AuthControllerInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Component
class InterceptorConfig : WebMvcConfigurer {

    @Autowired
    lateinit var authControllerInterceptor: AuthControllerInterceptor

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(authControllerInterceptor).addPathPatterns("/**")
    }

}