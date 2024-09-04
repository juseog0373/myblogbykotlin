package com.example.myblog.domain.comment

import com.example.myblog.domain.member.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface MemberRepository : JpaRepository<Member, Long> {

}