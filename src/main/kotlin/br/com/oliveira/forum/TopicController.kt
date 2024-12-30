package br.com.oliveira.forum

import br.com.oliveira.forum.model.Topic
import br.com.oliveira.forum.services.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/v1/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun List(): List<Topic> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id:Long):Topic{
        return service.findById(id)
    }
}