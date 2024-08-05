package com.kimauto.portfolio.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Achievement : BaseEntity() {

    @Id //필드가 pk다
    @GeneratedValue(strategy = GenerationType.IDENTITY) // identity my sql 이 알아서 pk를 만들어줌
    @Column(name = "achievement_id")
    var id: Long? = null




}