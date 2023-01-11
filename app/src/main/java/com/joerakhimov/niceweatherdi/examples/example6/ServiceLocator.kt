package com.joerakhimov.niceweatherdi.examples.example6

// Service Locator:

class Engine(){
    fun start(){
        println("Engine is starting")
    }
}

object ServiceLocator {
    val engine = Engine()
    fun <A: Any> lookup(name: String): A = when(name){
        "engine"->engine
        else->throw IllegalArgumentException(
            "Dependency with the following key has not been found: "+name)
    } as A
}

class Car(){
    val engine = ServiceLocator.lookup<Engine>("engine")
    fun start(){
        println("Car is starting")
        engine.start()
    }
}

fun main() {
    val car = Car()
    car.start()
}