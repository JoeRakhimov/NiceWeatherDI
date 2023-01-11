package com.joerakhimov.niceweatherdi.examples.example3

// Constructor injection:

class Engine(){
    fun start(){
        println("Engine is starting")
    }
}

class Car(private val engine: Engine){
    fun start(){
        println("Car is starting")
        engine.start()
    }
}

fun main() {
    val engine = Engine()
    val car = Car(engine)
    car.start()
}