package br.com.oliveira.forum.repository

import br.com.oliveira.forum.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository:JpaRepository<User,Long>