package com.group.libraryapp.jpaex.domain.orders

import org.springframework.data.jpa.repository.JpaRepository

interface OrdersRepository : JpaRepository<Orders, Long> {
}