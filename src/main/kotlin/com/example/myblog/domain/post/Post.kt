package com.example.myblog.domain.post

import jakarta.persistence.*

@Entity
@Table(name = "tb_post")
class Post(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,

        @Column(name = "title", nullable = false)
        var title: String,

        @Column(name = "content", nullable = false)
        var cotent: String

) {


}