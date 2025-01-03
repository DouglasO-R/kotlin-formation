package br.com.oliveira.forum.services

import br.com.oliveira.forum.model.User
import org.springframework.stereotype.Service
import java.util.Arrays

@Service
class UserService(final var users:List<User>) {
    init {
        val user = User(
            id = 1,
            name = "douglas",
            email = "douglas@oliveira.com"
        )

        val user2 = User(
            id = 2,
            name = "lucas",
            email = "lucas@oliveira.com"
        )
        val user3 = User(
            id = 3,
            name = "victor",
            email = "vic@oliveira.com"
        )

        users = Arrays.asList(user,user2,user3)

    }

    fun findById(id:Long): User {
        return users.stream().filter({
            user -> user.id == id
        }).findFirst().get()
    }
}
