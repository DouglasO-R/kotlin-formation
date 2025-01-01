package br.com.oliveira.forum.mapper

interface Mapper<T, U> {
    fun map(type: T): U
}
