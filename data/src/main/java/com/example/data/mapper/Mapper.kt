package com.example.data.mapper

interface Mapper<in T, out Y> {

    fun map(from: T) : Y

}