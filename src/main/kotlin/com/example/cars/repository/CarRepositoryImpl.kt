package com.example.cars.repository

import com.example.cars.model.*
import com.example.cars.tables.references.CARS
import org.jooq.DSLContext
import org.springframework.stereotype.Repository
import org.jooq.impl.DSL.row

@Repository
class CarRepositoryImpl(
    private val dslContext: DSLContext
) : CarRepository {

    override fun findByID(id: Long): Car? {
        return dslContext
            .select(
                CARS.ID,
                CARS.COLOR,
                CARS.RELEASE_DATE,
                row(
                    CARS.models.ID,
                    CARS.models.NAME,
                    row(
                        CARS.models.marks.ID,
                        CARS.models.marks.NAME,
                    ).mapping(::Mark).`as`("marks"),
                ).mapping(::Model).`as`("models"),
            )
            .from(CARS)
            .where(CARS.ID.eq(id))
            .fetchOneInto(Car::class.java)
    }
}