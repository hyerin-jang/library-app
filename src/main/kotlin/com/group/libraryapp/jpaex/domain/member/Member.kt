package com.group.libraryapp.jpaex.domain.member

import com.group.libraryapp.jpaex.domain.orders.Orders
import javax.persistence.*

@Entity
class Member(
    val name: String,

    @OneToMany(mappedBy = "member")
    val orders: MutableList<Orders> = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)