package com.kimauto.portfolio.domain.repository

import com.kimauto.portfolio.domain.entity.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface HttpInterfaceRepository : JpaRepository<HttpInterface, Long> {

    fun countAllByCreatedDateTimeBetween(dateTime: LocalDateTime, end: LocalDateTime): Long


}