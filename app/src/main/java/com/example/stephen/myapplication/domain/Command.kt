package com.example.stephen.myapplication.domain

/**
 * Created by stephen on 03/11/2017.
 */
public interface Command<T> {
    fun execute(): T
}
