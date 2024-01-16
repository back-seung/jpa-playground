package com.play.jpaplayground.ch02_jpa_start1

import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class MemberService(
    val entityManager: EntityManager,
    val memberRepository: MemberRepository
) {

    @Transactional
    fun run() {
        val member = Member("1", "김철수", 23)
        entityManager.persist(member)
        entityManager.flush()
        println(memberRepository.findByIdOrNull("1")?.username)
    }
}