package br.com.oliveira.forum.mapper

import br.com.oliveira.forum.dto.TopicView
import br.com.oliveira.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper : Mapper<Topic, TopicView> {
    override fun map(type: Topic): TopicView {
        return TopicView(
            id = type.id,
            title = type.title,
            message = type.message,
            status = type.status,
            createDate = type.createDate
        )
    }
}