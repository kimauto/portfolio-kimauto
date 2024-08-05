package com.kimauto.portfolio.domain.repository


import com.kimauto.portfolio.domain.entity.*
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository:JpaRepository<Skill, Long> {
    

}