package com.example.myblog.domain.post

import com.example.myblog.domain.AuditingEntity
import com.example.myblog.domain.AuditingEntityId
import jakarta.persistence.*

@Entity
@Table(name = "tb_post")
class Post (
        title:String,
        content:String
) : AuditingEntity() {
        @Column(name = "title", nullable = false)
        var title: String = title
                protected set

        @Column(name = "content", nullable = false)
        var content: String = content
                protected set
}