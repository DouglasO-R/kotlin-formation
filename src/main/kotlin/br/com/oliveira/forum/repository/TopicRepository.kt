package br.com.oliveira.forum.repository

import br.com.oliveira.forum.dto.TopicPerCategoryDTO
import br.com.oliveira.forum.model.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicRepository : JpaRepository<Topic, Long>{

    fun findByCourseName(courseName:String,pageable:Pageable):Page<Topic>

    @Query("SELECT new br.com.oliveira.forum.dto.TopicPerCategoryDTO(course.category, count(t)) FROM Topic t JOIN t.course course GROUP By course.category")
    fun reports():List<TopicPerCategoryDTO>
}