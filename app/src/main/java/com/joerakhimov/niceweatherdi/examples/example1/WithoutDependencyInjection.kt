package com.joerakhimov.niceweatherdi.examples.example1

// Without Dependency Injection:

class Engine(){
    fun start(){
        println("Engine is starting")
    }
}

class Car(){
    val engine = Engine()
    fun start(){
        println("Car is starting")
        engine.start()
    }
}

fun main() {
    val car = Car()
    car.start()
}