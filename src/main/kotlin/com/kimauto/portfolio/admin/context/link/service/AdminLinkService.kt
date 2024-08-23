package com.kimauto.portfolio.admin.context.link.service

import com.kimauto.portfolio.admin.data.TableDTO
import com.kimauto.portfolio.domain.entity.Introduction
import com.kimauto.portfolio.domain.repository.LinkRepository
import org.springframework.stereotype.Service

@Service
class AdminLinkService(
    private val linkRepository: LinkRepository
) {
    fun getLinkTable(): TableDTO {
        val classInfo = Introduction::class
        val entities = linkRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}