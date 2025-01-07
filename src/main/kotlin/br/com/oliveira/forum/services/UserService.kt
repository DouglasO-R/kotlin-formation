package br.com.oliveira.forum.services

import br.com.oliveira.forum.model.User
import br.com.oliveira.forum.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.Arrays

@Service
class UserService(private val repository: UserRepository) {

    fun findById(id:Long): User {
        return repository.getOne(id)
    }
}
