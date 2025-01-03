package br.com.oliveira.forum.dto

import jakarta.validation.constraints.NotEmpty

data class NewResponseForm(
    @field:NotEmpty
    val message:String,
    val idAuthor:Long,
    var idTopic:Long? = null
)
