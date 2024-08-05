package com.kimauto.portfolio.domain.repository


import com.kimauto.portfolio.domain.entity.Introduction
import com.kimauto.portfolio.domain.entity.Link
import com.kimauto.portfolio.domain.entity.Project
import com.kimauto.portfolio.domain.entity.ProjectSkill
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectSkillRepository:JpaRepository<ProjectSkill, Long> {
    

}