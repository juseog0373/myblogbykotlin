package com.example.myblog.service

import com.example.myblog.domain.comment.MemberRepository
import com.example.myblog.domain.member.Member
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {

    @Transactional(readOnly = true)
    fun findAll(): MutableList<Member> = memberRepository.findAll()

}