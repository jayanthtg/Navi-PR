package com.github.core.mappers


interface Mapper<in T, out O> {
    fun map(item: T): O

    fun map(items: List<T>): List<O>
}