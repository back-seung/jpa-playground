package com.play.jpaplayground.ch02_jpa_start1

import javax.persistence.Persistence

fun main() {

    val emf = Persistence.createEntityManagerFactory("jpabook")
    val entityManager = emf.createEntityManager()
    val transaction = entityManager.transaction

}