package com.joerakhimov.niceweatherdi.examples.example4

// Field injection:

class Engine(){
    fun start(){
        println("Engine is starting")
    }
}

class Car(){
    lateinit var engine: Engine
    fun start(){
        println("Car is starting")
        engine.start()
    }
}

fun main() {
    val car = Car()
    val engine = Engine()
    car.engine = engine
    car.start()
}