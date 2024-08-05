package com.kimauto.portfolio.domain.repository


import com.kimauto.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository:JpaRepository<Introduction, Long> {
    

}