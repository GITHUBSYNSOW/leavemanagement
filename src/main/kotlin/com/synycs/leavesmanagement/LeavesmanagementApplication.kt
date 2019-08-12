package com.synycs.leavesmanagement

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = arrayOf("com.synycs.leavesmanagement"))
@EntityScan(basePackages = arrayOf("com.synycs.leavesmanagement"))
class LeavesmanagementApplication

fun main(args: Array<String>) {
    runApplication<LeavesmanagementApplication>(*args)
}
