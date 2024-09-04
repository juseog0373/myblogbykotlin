package com.example.myblog.domain.comment

import com.example.myblog.domain.AuditingEntity
import com.example.myblog.domain.post.Post
import jakarta.persistence.*
import jakarta.persistence.FetchType.LAZY
import jakarta.validation.constraints.Email

@Entity
@Table(name = "tb_comment")
class Comment(
    title: String,
    content: String,
    post: Post
) : AuditingEntity() {
    @Column(name = "content", nullable = false)
    var content: String = content
        protected set

    @ManyToOne(fetch = LAZY, targetEntity = Post::class)
    var post: Post = post
        protected set
}