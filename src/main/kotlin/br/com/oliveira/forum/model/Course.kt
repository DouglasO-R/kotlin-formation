package br.com.oliveira.forum.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
data class Course(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long? = null,
    val name:String,
    val category:String
)
