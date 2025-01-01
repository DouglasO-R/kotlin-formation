package br.com.oliveira.forum.model

import java.time.LocalDateTime

data class Topic(
    var id: Long? = null,
    val title: String,
    val message: String,
    val createDate: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: User,
    val status: StatusTopic = StatusTopic.UNANSWERED,
    val responses:List<Responses> = ArrayList()
)