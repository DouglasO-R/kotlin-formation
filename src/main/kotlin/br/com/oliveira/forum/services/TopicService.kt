package br.com.oliveira.forum.services

import br.com.oliveira.forum.dto.NewTopicForm
import br.com.oliveira.forum.dto.TopicPerCategoryDTO
import br.com.oliveira.forum.dto.TopicView
import br.com.oliveira.forum.dto.UpdateTopicForm
import br.com.oliveira.forum.exception.NotFoundException
import br.com.oliveira.forum.mapper.TopicFormMapper
import br.com.oliveira.forum.mapper.TopicViewMapper
import br.com.oliveira.forum.repository.TopicRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TopicService(
    private val repository: TopicRepository,
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
    private val notFoundMessage: String = "Topic not found"
) {

    fun list(
        courseName: String?,
        pageable: Pageable
    ): Page<TopicView> {
        val topics =
            if (courseName == null) repository.findAll(pageable) else repository.findByCourseName(courseName, pageable);

        return topics.map { topic ->
            topicViewMapper.map(topic)
        }
    }

    fun findById(id: Long): TopicView {
        val topic = repository.findById(id)
            .orElseThrow { NotFoundException(notFoundMessage) }
        return topicViewMapper.map(topic)
    }

    fun add(dto: NewTopicForm): TopicView {
        val topic = topicFormMapper.map(dto)
        repository.save(topic)
        return topicViewMapper.map(topic)
    }

    fun update(dto: UpdateTopicForm): TopicView {
        val topic = repository.findById(dto.id)
            .orElseThrow { NotFoundException(notFoundMessage) }
        topic.title = dto.title;
        topic.message = dto.message
        return topicViewMapper.map(topic)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }

    fun reports(): List<TopicPerCategoryDTO> {
        return repository.reports()
    }
}

