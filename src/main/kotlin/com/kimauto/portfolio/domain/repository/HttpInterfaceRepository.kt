package com.kimauto.portfolio.domain.repository

import com.kimauto.portfolio.domain.entity.Achievement
import com.kimauto.portfolio.domain.entity.Experience
import com.kimauto.portfolio.domain.entity.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository

interface HttpInterfaceRepository:JpaRepository<HttpInterface, Long> {
    

}