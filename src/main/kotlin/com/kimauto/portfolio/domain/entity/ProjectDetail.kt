package com.kimauto.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class ProjectDetail(content: String, url: String?, isActive: Boolean) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_detail_id")
    var id: Long? = null

    var content: String = content

    var url: String? = url

    var isActive: Boolean = isActive

    fun update(content: String, url: String?, isActive: Boolean) {
        this.content = content
        this.url = url
        this.isActive = isActive
    }
}

