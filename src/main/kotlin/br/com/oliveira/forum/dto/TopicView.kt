package br.com.oliveira.forum.dto

import br.com.oliveira.forum.model.StatusTopic
import java.time.LocalDateTime

data class TopicView(
    val id:Long?,
    val title:String,
    val message:String,
    val status: StatusTopic,
    val createDate:LocalDateTime
)
