package `class`

import interfaces.DisplayElement
import interfaces.Observer
import interfaces.Subject

class StatisticsDisplay: Observer, DisplayElement {
    var _minTemp: Float = 0.0f
    var _maxTemp: Float = 0.0f
    var _tempSum:Float = 0.0f
    var _numReadings: Int = 0
    lateinit var _weatherData: Subject

    constructor(weatherData: Subject){
        this._weatherData = weatherData
        this._weatherData.registerObserver(this)
    }

    override fun update(temperature: Float, humidity: Float, pressure: Float) {
        this._tempSum+= temperature
        this._numReadings++

        if (temperature>this._maxTemp) this._maxTemp = temperature
        if (temperature < this._minTemp) this._minTemp = temperature
        display()

    }

    override fun display() {
        println("Temperaturas:{ \nMedia: ${this._tempSum/this._numReadings} \nMáxima: ${this._maxTemp} \nMínima: ${this._minTemp}}")
    }

}