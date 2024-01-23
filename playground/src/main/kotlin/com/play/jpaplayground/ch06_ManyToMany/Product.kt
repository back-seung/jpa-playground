package com.play.jpaplayground.ch06_ManyToMany

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name ="product")
class Product(
    var name:String
) {
    @Id @Column(name = "product_id")
    var productId: String?=null;

}