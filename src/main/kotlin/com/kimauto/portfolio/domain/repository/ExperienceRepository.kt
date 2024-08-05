package com.kimauto.portfolio.domain.repository

import com.kimauto.portfolio.domain.entity.Achievement
import com.kimauto.portfolio.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository

interface ExperienceRepository:JpaRepository<Experience, Long> {
    

}