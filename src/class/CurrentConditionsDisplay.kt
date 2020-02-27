package `class`

import interfaces.DisplayElement
import interfaces.Observer
import interfaces.Subject

class CurrentConditionsDisplay : DisplayElement, Observer {
    var _temperature: Float = 0.0f
    var _humidity: Float = 0.0f
    var _pressure: Float = 0.0f
    lateinit var _weatherData: Subject



    constructor(weatherData: Subject)  {
        this._weatherData = weatherData
        weatherData.registerObserver(this)
    }

    override fun display() {
        println("Condições atuais: ${this._temperature}ºC e ${this._humidity}% de umidade e ${this._pressure} de pressão.")
    }

    override fun update(temperature: Float, humidity: Float, pressure: Float) {
        this._temperature = temperature
        this._humidity = humidity
        this._pressure = pressure
        display()
    }

}