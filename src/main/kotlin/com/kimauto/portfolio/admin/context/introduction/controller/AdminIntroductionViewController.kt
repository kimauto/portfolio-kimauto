package com.kimauto.portfolio.admin.context.introduction.controller

import com.kimauto.portfolio.admin.context.introduction.service.AdminIntroductionService
import com.kimauto.portfolio.admin.data.DateFormElementDTO
import com.kimauto.portfolio.admin.data.FormElementDTO
import com.kimauto.portfolio.admin.data.SelectFormElementDTO
import com.kimauto.portfolio.admin.data.TextFormElementDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/introduction")
class AdminIntroductionViewController(
    private val adminIntroductionService: AdminIntroductionService
) {
    @GetMapping
    fun introduction(model: Model): String {
        val formElements = listOf<FormElementDTO>(
            TextFormElementDTO("content",10),
            SelectFormElementDTO("isActive",2, listOf(true.toString(), false.toString()))
        )
        model.addAttribute("formElements", formElements)

        val table = adminIntroductionService.getIntroductionTable()
        model.addAttribute("table", table)
        model.addAttribute("detailTable", null) // null 이면 아무것도 안보여줌

        val pageAttribute = mutableMapOf<String, Any>(
            Pair("menuName", "Index"),
            Pair("pageName", table.name),
            Pair("editable", "true"),
            Pair("deletable", "false"),
            Pair("hasDetails", "false")
        )
        model.addAllAttributes(pageAttribute)

        return "admin/page-table"
    }
}