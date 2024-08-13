package com.kimauto.portfolio.presentation.service

import com.kimauto.portfolio.domain.entity.Introduction
import com.kimauto.portfolio.presentation.dto.IntroductionDTO
import com.kimauto.portfolio.presentation.dto.LinkDTO
import com.kimauto.portfolio.presentation.dto.ProjectDTO
import com.kimauto.portfolio.presentation.dto.ResumeDTO
import com.kimauto.portfolio.presentation.repository.PresentationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.math.exp

@Service
class PresentationService(
    private val presentationRepository: PresentationRepository
) {
    @Transactional(readOnly = true) // 조회성 메서드 성능 이점 있음
    fun getIntroductions():List<IntroductionDTO> {
        val introductions = presentationRepository.getActiveIntroductions()
        return introductions.map { IntroductionDTO(it) }
    }

    @Transactional(readOnly = true)
    fun getLinks():List<LinkDTO> {
        val links = presentationRepository.getActiveLinks()

        return links.map { LinkDTO(it) }
    }


    @Transactional(readOnly = true)
    fun getResume() :ResumeDTO{
        val experiences = presentationRepository.getActiveExperiences()
        val achievements = presentationRepository.getActiveAchievements()
        val skills = presentationRepository.getActiveSkills()

        return ResumeDTO(
            experiences = experiences,
            achievements = achievements,
            skills = skills
        )
    }

    @Transactional(readOnly = true)
    fun getProjects():List<ProjectDTO> {
        val projects = presentationRepository.getActiveProjects()

        return projects.map { ProjectDTO(it) }
    }
}