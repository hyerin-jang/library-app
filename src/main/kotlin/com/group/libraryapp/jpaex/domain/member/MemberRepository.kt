package com.group.libraryapp.jpaex.domain.member

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface MemberRepository : JpaRepository<Member, Long> {

    @Query("select distinct m from Member m join fetch m.orders")
    fun findAllFetchJoin(): List<Member>

    @EntityGraph(attributePaths = ["orders"])
//    @Query("select distinct m from Member m")
    override fun findAll(): List<Member>

//    @EntityGraph(attributePaths = ["orders"])
//    @Query("select m from Member m")
//    fun findAllPage(pageable: Pageable): Page<Member>?

    @Query(
        value = "select distinct m from Member m join fetch m.orders",
        countQuery = "select count (distinct m) from Member m inner join m.orders"
    )
    fun findAllPage(pageable: Pageable): Page<Member>?

    override fun findAll(pageable: Pageable): Page<Member>?

}