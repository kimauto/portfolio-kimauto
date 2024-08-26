package com.kimauto.portfolio.admin.context.link.service

import com.kimauto.portfolio.admin.context.link.form.LinkForm
import com.kimauto.portfolio.domain.entity.Introduction
import com.kimauto.portfolio.domain.repository.LinkRepository
import com.yongback.portfolio.admin.data.TableDTO
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminLinkService(
    private val linkRepository: LinkRepository
) {
    fun getLinkTable(): TableDTO {
        val classInfo = Introduction::class
        val entities = linkRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    @Transactional
    fun save(form: LinkForm) {
        val link = form.toEntity()

        linkRepository.save(link)
    }

    @Transactional
    fun update(id: Long, form: LinkForm) {
        val link = form.toEntity(id)

        linkRepository.save(link)
    }
}