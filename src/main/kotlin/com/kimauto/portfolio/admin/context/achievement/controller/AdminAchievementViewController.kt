package com.kimauto.portfolio.admin.context.achievement.controller

import com.kimauto.portfolio.admin.context.achievement.service.AdminAchievementService
import com.kimauto.portfolio.admin.data.DateFormElementDTO
import com.kimauto.portfolio.admin.data.FormElementDTO
import com.kimauto.portfolio.admin.data.SelectFormElementDTO
import com.kimauto.portfolio.admin.data.TextFormElementDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/achievement")
class AdminAchievementViewController(
    private val adminAchievementService: AdminAchievementService
) {

    @GetMapping
    fun achievement(model: Model): String {
        val formElements = listOf<FormElementDTO>(
            TextFormElementDTO("title", 4),
            TextFormElementDTO("description", 4),
            DateFormElementDTO("achievedDate", 4),
            TextFormElementDTO("host", 4),
            SelectFormElementDTO("isActive", 2, listOf(true.toString(), false.toString()))
        )
        model.addAttribute("formElements", formElements)

        val table = adminAchievementService.getAchievementTable()
        model.addAttribute("table", table)
        model.addAttribute("detailTable", null) // null 이면 아무것도 안보여줌

        val pageAttribute = mutableMapOf<String, Any>(
            Pair("menuName", "Resume"),
            Pair("pageName", table.name),
            Pair("editable", true),
            Pair("deletable", false),
            Pair("hasDetails", false)
        )
        model.addAllAttributes(pageAttribute)

        return "admin/page-table"
    }
}