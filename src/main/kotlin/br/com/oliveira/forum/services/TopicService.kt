package br.com.oliveira.forum.services

import br.com.oliveira.forum.model.Course
import br.com.oliveira.forum.model.Topic
import br.com.oliveira.forum.model.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicService(private var topics: List<Topic>) {

    init {
        val topic = Topic(
            id = 1,
            title = "duvida kotlin",
            message = "Variaveis no kotlin",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programacao"
            ),
            author = User(
                id = 1,
                name = "Douglas",
                email = "douglas@oliveira.com"
            ),
        )

        val topic2 = Topic(
            id = 2,
            title = "duvida kotlin",
            message = "Variaveis no kotlin",
            course = Course(
                id = 2,
                name = "Kotlin",
                category = "Programacao"
            ),
            author = User(
                id = 2,
                name = "Douglas",
                email = "douglas@oliveira.com"
            ),
        )

        val topic3 = Topic(
            id = 3,
            title = "duvida kotlin",
            message = "Variaveis no kotlin",
            course = Course(
                id = 3,
                name = "Kotlin",
                category = "Programacao"
            ),
            author = User(
                id = 3,
                name = "Douglas",
                email = "douglas@oliveira.com"
            ),
        )

        topics = Arrays.asList(topic, topic2, topic3)

    }

    fun list(): List<Topic> {
        return topics
    }

    fun findById(id: Long): Topic {
        return topics.stream().filter({t -> t.id == id}).findFirst().get()
    }
}