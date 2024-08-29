package com.kimauto.portfolio.admin.context.skill.service

import com.kimauto.portfolio.admin.context.skill.forn.SkillForm
import com.kimauto.portfolio.domain.entity.Introduction
import com.kimauto.portfolio.domain.entity.Skill
import com.kimauto.portfolio.domain.repository.SkillRepository
import com.yongback.portfolio.admin.data.TableDTO
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminSkillService(
    private val skillRepository: SkillRepository,
) {
    fun getSkillTable(): TableDTO {
        val classInfo = Skill::class
        val entities = skillRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    @Transactional
    fun save(form: SkillForm) {
        val skill = form.toEntity()
        skillRepository.save(skill)
    }

    @Transactional
    fun update(id: Long, form: SkillForm) {
        val skill = form.toEntity(id)

        skillRepository.save(skill)
    }
}