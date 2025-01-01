package br.com.oliveira.forum.services

import br.com.oliveira.forum.dto.NewTopicForm
import br.com.oliveira.forum.dto.TopicView
import br.com.oliveira.forum.mapper.TopicFormMapper
import br.com.oliveira.forum.mapper.TopicViewMapper
import br.com.oliveira.forum.model.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),

    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper
) {


    fun list(): List<TopicView> {
        return topics.stream().map {
            topic -> topicViewMapper.map(topic)
        }.collect(Collectors.toList())
    }

    fun findById(id: Long): TopicView {
        val topic = topics.stream().filter { t -> t.id == id }.findFirst().get()
        return topicViewMapper.map(topic)
    }

    fun add(dto: NewTopicForm) {
        val topic = topicFormMapper.map(dto)
        topic.id = topics.size.toLong()
        topics = topics.plus(topic)
    }
}

