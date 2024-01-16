package com.play.jpaplayground.ch02_jpa_start1

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "members")
class Member(
    @Id
    @Column(name = "id")
    val id: String,

    @Column(name = "name")
    val username: String,

    // 매핑 정보가 없는 필드 => 프로퍼티명으로 컬럼명을 매핑한다.
    val age: Int
) {

}