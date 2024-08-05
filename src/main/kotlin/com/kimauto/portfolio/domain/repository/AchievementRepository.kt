package com.kimauto.portfolio.domain.repository

import com.kimauto.portfolio.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository

interface AchievementRepository:JpaRepository<Achievement, Long> {


}