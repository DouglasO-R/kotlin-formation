package br.com.oliveira.forum.controller

import br.com.oliveira.forum.dto.NewTopicForm
import br.com.oliveira.forum.dto.TopicView
import br.com.oliveira.forum.dto.UpdateTopicForm
import br.com.oliveira.forum.services.TopicService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/v1/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun List(): List<TopicView> {
        return service.list()
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id:Long):TopicView{
        return service.findById(id)
    }

    @PostMapping
    @Transactional
    fun add(
        @RequestBody @Valid dto:NewTopicForm,
        uriBuilder: UriComponentsBuilder
        ): ResponseEntity<TopicView> {
        val topicView = service.add(dto)
        val uri = uriBuilder.path("/topics/${topicView.id}").build().toUri()

        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    @Transactional
    fun update(@RequestBody @Valid dto: UpdateTopicForm): ResponseEntity<TopicView> {
        val topicView = service.update(dto)
        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun delete(@PathVariable id:Long){
        service.delete(id)
    }
}

