package com.kimauto.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Project(
    name: String,
    description: String,
    startYear: Int,
    startMonth: Int,
    endYear: Int?, // 비어있으면 현재 개발중
    endMonth: Int?,
    isActive: Boolean
) : BaseEntity() {

    @Id //필드가 pk다
    @GeneratedValue(strategy = GenerationType.IDENTITY) // identity my sql 이 알아서 pk를 만들어줌
    @Column(name = "project_id")
    var id: Long? = null


    var name: String = name

    var description: String = description

    var startYear: Int = startYear

    var startMonth: Int = startMonth

    var endYear: Int? = null

    var endMonth: Int? = null

    var isActive: Boolean = isActive


    @OneToMany(
        targetEntity = ProjectDetail::class, fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL]
    ) // experienceDetail 1:N 관계, MutableList는 변할수 있는
    @JoinColumn(name = "project_id")
    var details: MutableList<ProjectDetail> = mutableListOf()

    @OneToMany(mappedBy = "project")
    var skills: MutableList<Skill> = mutableListOf()

    fun getEndYearMonth(): String {
        if (endYear == null || endMonth == null) {
            return "Present"
        }

        return "${endYear}.${endMonth}"
    }

    fun update(
        name: String, description: String, startYear: Int, startMonth: Int,
        endYear: Int?, endMonth: Int?, isActive: Boolean
    ) {
        this.name = name
        this.description = description
        this.startYear = startYear
        this.startMonth = startMonth
        this.endYear = endYear
        this.endMonth = endMonth
        this.isActive = isActive
    }

    fun addDetails(detail: MutableList<ProjectDetail>?) {
        if (detail != null) {
            this.details.addAll(details)
        }
    }


}