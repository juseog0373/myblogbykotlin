package com.example.myblog.domain.post

import com.example.myblog.domain.AuditingEntity
import com.example.myblog.domain.AuditingEntityId
import com.example.myblog.domain.member.Member
import jakarta.persistence.*
import jakarta.persistence.FetchType.LAZY

@Entity
@Table(name = "tb_post")
class Post (
        title:String,
        content:String,
        member: Member,
) : AuditingEntity() {
        @Column(name = "title", nullable = false)
        var title: String = title
                protected set

        @Column(name = "content", nullable = false)
        var content: String = content
                protected set

        @ManyToOne(fetch = LAZY, targetEntity = Member::class)
        var member:Member = member
                protected set
}