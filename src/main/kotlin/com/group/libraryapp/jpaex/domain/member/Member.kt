package com.group.libraryapp.jpaex.domain.member

import com.group.libraryapp.jpaex.domain.orders.Orders
import org.hibernate.annotations.BatchSize
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Entity
class Member(
    val name: String,

//    @BatchSize(size = 100)
    @OneToMany(mappedBy = "member")
    val orders: MutableList<Orders> = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)