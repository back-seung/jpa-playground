package com.play.jpaplayground.ch06_ManyToMany

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table


@Entity
@Table(name = "member")
class Member (
    var userName: String,

){
    @Id @Column(name = "member_id")
    var memberId:String?=null;

    @ManyToMany
    @JoinTable(name = "member_product",
        joinColumns = @JoinColumn(name = "member_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    val products = MutableList<Product>();


}