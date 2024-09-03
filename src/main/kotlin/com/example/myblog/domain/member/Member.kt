package com.example.myblog.domain.member

import jakarta.persistence.*

@Entity
class Member(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,

        @Column(name = "email", nullable = false)
        var email: String,

        @Column(name = "password", nullable = false)
        var password: String,

        @Enumerated(EnumType.STRING)
        var role: Role

) {

}

enum class Role {
    USER, ADMIN
}