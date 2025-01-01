package br.com.oliveira.forum

import br.com.oliveira.forum.dto.NewTopicForm
import br.com.oliveira.forum.dto.TopicView
import br.com.oliveira.forum.model.Topic
import br.com.oliveira.forum.services.TopicService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun List(): List<TopicView> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id:Long):TopicView{
        return service.findById(id)
    }

    @PostMapping
    fun add(@RequestBody @Valid dto:NewTopicForm){
        service.add(dto)
    }
}

