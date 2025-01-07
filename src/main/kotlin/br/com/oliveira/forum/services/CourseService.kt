package br.com.oliveira.forum.services

import br.com.oliveira.forum.model.Course
import br.com.oliveira.forum.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(private val repository: CourseRepository) {

    fun findById(id: Long): Course {
        return repository.getOne(id)
    }
}
