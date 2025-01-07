package br.com.oliveira.forum.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
data class Response(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long? = null,
    val message:String,
    val createdDate:LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val author:User,
    @ManyToOne
    val topic: Topic,
    val solution:Boolean
)