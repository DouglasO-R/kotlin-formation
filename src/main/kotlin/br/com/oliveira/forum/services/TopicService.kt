package br.com.oliveira.forum.services

import br.com.oliveira.forum.dto.NewTopicForm
import br.com.oliveira.forum.dto.TopicView
import br.com.oliveira.forum.dto.UpdateTopicForm
import br.com.oliveira.forum.exception.NotFoundException
import br.com.oliveira.forum.mapper.TopicFormMapper
import br.com.oliveira.forum.mapper.TopicViewMapper
import br.com.oliveira.forum.model.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
    private val notFoundMessage: String = "Topic not found"
) {

    fun list(): List<TopicView> {
        return topics.stream().map { topic ->
            topicViewMapper.map(topic)
        }.collect(Collectors.toList())
    }

    fun findById(id: Long): TopicView {
        val topic =
            topics.stream().filter { t -> t.id == id }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }
        return topicViewMapper.map(topic)
    }

    fun findTopicById(id: Long): Topic {
        val topic =
            topics.stream().filter { t -> t.id == id }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }
        return topic
    }

    fun add(dto: NewTopicForm): TopicView {
        val topic = topicFormMapper.map(dto)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
        return topicViewMapper.map(topic)
    }

    fun update(dto: UpdateTopicForm): TopicView {
        val topic = topics.stream().filter { topic -> topic.id == dto.id }.findFirst()
            .orElseThrow { NotFoundException(notFoundMessage) }
        val updatedTopic = Topic(
            id = dto.id,
            title = dto.title,
            message = dto.message,
            author = topic.author,
            course = topic.course,
            status = topic.status,
            createDate = topic.createDate,
            responses = topic.responses
        )

        topics = topics
            .minus(topic)
            .plus(updatedTopic)
        return topicViewMapper.map(updatedTopic)
    }

    fun delete(id: Long) {
        val topic = topics.stream().filter { topic -> topic.id == id }.findFirst()
            .orElseThrow { NotFoundException(notFoundMessage) }
        topics = topics.minus(topic)
    }
}

