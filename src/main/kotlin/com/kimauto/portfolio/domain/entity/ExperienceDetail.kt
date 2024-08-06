package com.kimauto.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class ExperienceDetail(
    content: String,
    isActive: Boolean
) : BaseEntity() {

    @Id //필드가 pk다
    @GeneratedValue(strategy = GenerationType.IDENTITY) // identity my sql 이 알아서 pk를 만들어줌
    @Column(name = "experience_detail_id")
    var id: Long? = null

    var content: String = content

    // is_active
    var isActive: Boolean = isActive

    fun update(content: String, isActive: Boolean) {
        this.content = content
        this.isActive = isActive
    }


}