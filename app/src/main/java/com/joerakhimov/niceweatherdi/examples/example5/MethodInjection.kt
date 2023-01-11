package com.joerakhimov.niceweatherdi.examples.example5

// Method injection:

class Engine(){
    fun start(){
        println("Engine is starting")
    }
}

class Car(){
    lateinit private var engine: Engine
    fun inject(engine: Engine){
        this.engine = engine
    }
    fun start(){
        println("Car is starting")
        engine.start()
    }
}

fun main() {
    val car = Car()
    val engine = Engine()
    car.inject(engine)
    car.start()
}