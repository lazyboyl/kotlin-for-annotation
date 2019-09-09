package com.kotlin.annotation.auth.filter

import com.kotlin.annotation.auth.AuthController
import org.springframework.stereotype.Component
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerInterceptor
import java.util.regex.Pattern
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * 类描述：基于web的注解拦截的实现
 * @author linzf
 * @since 2019-09-09
 */
@Component
class AuthControllerInterceptor : HandlerInterceptor {


    /**
     * 功能描述： 拦截所有的请求
     */
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        /**
         * 这是为了防止跨域访问的时候嗅探方法的进入，因此直接放行
         */
        if ("OPTIONS" == request.method) {
            return true
        }
        /**
         * 对我们的js，css等直接放行
         */
        val actionUrl = request.servletPath
        val jsPattern = ".*.js"
        val cssPattern = ".*.css"
        val pngPattern = ".*.png"
        val gifPattern = ".*.gif"
        if (Pattern.matches(gifPattern, actionUrl) || Pattern.matches(jsPattern, actionUrl) || Pattern.matches(cssPattern, actionUrl) || Pattern.matches(pngPattern, actionUrl)) {
            return true
        }
        println("响应的地址是：$actionUrl")
        // 将handler强转为HandlerMethod, 前面已经证实这个handler就是HandlerMethod
        val handlerMethod = handler as HandlerMethod
        // 从方法处理器中获取出要调用的方法
        val method = handlerMethod.method
        // 获取出方法上的AuthController注解
        val authController = method.getAnnotation(AuthController::class.java) ?: return true
        for (a in authController.authorities) {
            println("注解的值是：$a")
        }
        return true
    }

}