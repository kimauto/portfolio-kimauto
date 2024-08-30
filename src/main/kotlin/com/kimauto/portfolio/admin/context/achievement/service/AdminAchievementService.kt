package com.kimauto.portfolio.admin.context.achievement.service

import com.kimauto.portfolio.admin.context.achievement.form.AchievementForm
import com.kimauto.portfolio.domain.entity.Achievement
import com.kimauto.portfolio.domain.repository.AchievementRepository
import com.kimauto.portfolio.admin.data.TableDTO
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminAchievementService(
    private val achievementRepository: AchievementRepository
) {

    fun getAchievementTable(): TableDTO {
        val classInfo = Achievement::class
        val entities = achievementRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    @Transactional
    fun save(form: AchievementForm) {
        val achievement = form.toEntity()
        achievementRepository.save(achievement)
    }

    @Transactional
    fun update(id: Long, form: AchievementForm) {
        val achievement = form.toEntity(id)
        achievementRepository.save(achievement)
    }
}