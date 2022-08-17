package com.group.libraryapp.jpaex.domain.member

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface MemberRepository : JpaRepository<Member, Long> {

    @Query("select m from Member m join fetch m.orders")
    fun findAllFetchJoin(): List<Member>

}