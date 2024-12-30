package br.com.oliveira.forum.model

import java.time.LocalDateTime

data class Responses(
    val id:Long? = null,
    val message:String,
    val createdDate:LocalDateTime = LocalDateTime.now(),
    val author:User,
    val topic: Topic,
    val solution:Boolean
)