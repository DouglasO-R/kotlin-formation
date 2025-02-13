package br.com.oliveira.forum.repository

import br.com.oliveira.forum.model.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository : JpaRepository<Topic, Long>{

    fun findByCourseName(courseName:String,pageable:Pageable):Page<Topic>
}