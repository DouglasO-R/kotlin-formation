package br.com.oliveira.forum.controller

import br.com.oliveira.forum.dto.NewTopicForm
import br.com.oliveira.forum.dto.TopicView
import br.com.oliveira.forum.dto.UpdateTopicForm
import br.com.oliveira.forum.services.TopicService
import jakarta.validation.Valid
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
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
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/v1/topics")
class TopicController(
    private val service: TopicService
) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Cacheable("topics")
    fun List(
        @RequestParam(required = false) courseName:String?,
        @PageableDefault(size = 5, sort = ["createDate"], direction = Sort.Direction.DESC) pageable: Pageable
    ): Page<TopicView> {
        return service.list(courseName,pageable)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id:Long):TopicView{
        return service.findById(id)
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
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
    @CacheEvict(value = ["topics"], allEntries = true)
    fun update(@RequestBody @Valid dto: UpdateTopicForm): ResponseEntity<TopicView> {
        val topicView = service.update(dto)
        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    fun delete(@PathVariable id:Long){
        service.delete(id)
    }
}

