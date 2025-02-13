package br.com.oliveira.forum.mapper

import br.com.oliveira.forum.dto.NewTopicForm
import br.com.oliveira.forum.model.Topic
import br.com.oliveira.forum.services.CourseService
import br.com.oliveira.forum.services.UserService
import org.springframework.stereotype.Component


@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService,
) : Mapper<NewTopicForm, Topic> {

    override fun map(type: NewTopicForm): Topic {
        return Topic(
            title = type.title,
            message = type.message,
            course = courseService.findById(type.idCourse),
            author = userService.findById(type.idAuthor),
        )
    }

}
