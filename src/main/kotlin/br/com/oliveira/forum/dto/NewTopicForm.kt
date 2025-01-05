package br.com.oliveira.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class NewTopicForm(
    @field:NotEmpty(message = "Title can not be empty")
    @field:Size(min = 5, max = 100, message = "Title need have min 5 character and max 100 character")
    val title:String,

    @field:NotEmpty(message = "Message can not be empty")
    val message:String,

    @field:NotNull(message = "idCourse can not be null")
    val idCourse:Long,

    @field:NotNull(message = "idAuthor can not be null")
    val idAuthor:Long
)