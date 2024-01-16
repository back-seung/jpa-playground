package com.play.jpaplayground.ch02_jpa_start1

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

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