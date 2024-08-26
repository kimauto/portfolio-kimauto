package com.kimauto.portfolio.admin.context.introduction.service

import com.kimauto.portfolio.domain.entity.Introduction
import com.kimauto.portfolio.domain.repository.IntroductionRepository
import com.yongback.portfolio.admin.context.introduction.form.IntroductionForm
import com.yongback.portfolio.admin.data.TableDTO
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminIntroductionService(
    private val introductionRepository: IntroductionRepository
) {
    fun getIntroductionTable(): TableDTO {
        val classInfo = Introduction::class
        val entities = introductionRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    @Transactional
    fun save(form: IntroductionForm) {
        val introduction = form.toEntity()
        introductionRepository.save(introduction)
    }

    @Transactional
    fun update(id: Long, form: IntroductionForm) {
        val introduction = form.toEntity(id)
        introductionRepository.save(introduction)
    }

}