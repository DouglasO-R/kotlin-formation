package br.com.oliveira.forum.repository

import br.com.oliveira.forum.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository : JpaRepository<Course, Long>