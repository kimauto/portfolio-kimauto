package com.kimauto.portfolio.domain.repository


import com.kimauto.portfolio.domain.entity.Introduction
import com.kimauto.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository:JpaRepository<Link, Long> {
    

}