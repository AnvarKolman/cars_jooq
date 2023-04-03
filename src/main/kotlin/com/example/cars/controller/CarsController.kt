package com.example.cars.controller

import com.example.cars.model.Car
import com.example.cars.repository.CarRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cars")
class CarsController(
    private val carRepository: CarRepository
) {

    @GetMapping("/{id}")
    fun getByID(@PathVariable id: Long): ResponseEntity<Car> {
        val result = carRepository.findByID(id)
        return if (result != null) {
            ResponseEntity.ok(result)
        } else {
            ResponseEntity.notFound().build()
        }
    }

}