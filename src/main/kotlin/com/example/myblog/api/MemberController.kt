package com.example.myblog.api

import com.example.myblog.domain.member.Member
import com.example.myblog.service.MemberService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(
    private val memberService: MemberService
) {

    @GetMapping("/members")
    fun findAll() : MutableList<Member> {
        return memberService.findAll()
    }
}