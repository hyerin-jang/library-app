package com.group.libraryapp.jpaex.domain.orders

import com.group.libraryapp.jpaex.domain.member.Member
import javax.persistence.*

@Entity
class Orders(
    val name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    val member: Member,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)