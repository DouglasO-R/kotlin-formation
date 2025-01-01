package br.com.oliveira.forum.services

import br.com.oliveira.forum.model.Course
import org.springframework.stereotype.Service
import java.util.Arrays

@Service
class CourseService(final var courses:List<Course>) {
    init {
        val kotlinCourse = Course(
            id = courses.size.toLong() + 1,
            name = "Kotlin",
            category = "Programacao"
        )
        val javaCourse = Course(
            id = courses.size.toLong() + 1,
            name = "java",
            category = "Programacao"
        )

        val phpCourse = Course(
            id = courses.size.toLong() + 1,
            name = "Php",
            category = "Programacao"
        )

        courses = Arrays.asList(kotlinCourse,javaCourse,phpCourse)
    }

    fun findById(id:Long):Course{
        return courses.stream().filter({
            course -> course.id == id
        }).findFirst().get()
    }
}
