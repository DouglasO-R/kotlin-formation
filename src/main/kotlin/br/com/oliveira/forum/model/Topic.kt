package br.com.oliveira.forum.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Topic(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var title: String,
    var message: String,
    val createDate: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val course: Course,
    @ManyToOne
    val author: User,
    @Enumerated(value = EnumType.STRING)
    val status: StatusTopic = StatusTopic.UNANSWERED,
    @OneToMany(mappedBy = "topic")
    var responses:List<Response> = ArrayList()
)