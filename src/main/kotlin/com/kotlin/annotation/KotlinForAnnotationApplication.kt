package com.kotlin.annotation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinForAnnotationApplication

fun main(args: Array<String>) {
    runApplication<KotlinForAnnotationApplication>(*args)
}
