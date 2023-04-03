package com.example.cars.repository

import com.example.cars.model.Car


interface CarRepository {

    fun findByID(id: Long): Car?

}