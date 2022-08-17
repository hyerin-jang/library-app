package com.group.libraryapp.jpaex

import com.group.libraryapp.jpaex.domain.member.Member
import com.group.libraryapp.jpaex.domain.member.MemberRepository
import com.group.libraryapp.jpaex.domain.orders.Orders
import com.group.libraryapp.jpaex.domain.orders.OrdersRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@Transactional
@SpringBootTest
class JpaTest @Autowired constructor(
    private val memberRepository: MemberRepository,
    private val ordersRepository: OrdersRepository,
    private val em: EntityManager,
) {

    @BeforeEach
    fun beforeEach() {

        val member = memberRepository.saveAll(
            listOf(
                Member("이름1"),
                Member("이름2")
            )
        )

        ordersRepository.saveAll(
            listOf(
                Orders("주문1", member[0]),
                Orders("주문2", member[0])
            )
        )

        em.flush()
        em.clear()

    }

    @Test
    fun findAllTest() {

        println(">> start")

        val members = memberRepository.findAll()

        println(">> end")
    }

    @Test
    fun afterFindAllTest() {

        println(">> start")

        val members = memberRepository.findAll()

        println(">> findAll 끝")

        members.forEach { it.orders.size }

        println(">> end")
    }

    @Test
    fun findAllFetchJoinTest() {

        println(">> start")

        val members = memberRepository.findAllFetchJoin()

        println(">> findAllFetchJoin 끝")

        members.forEach { it.orders.size }

        println(">> end")
    }

}