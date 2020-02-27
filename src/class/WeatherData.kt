package `class`

import interfaces.Observer
import interfaces.Subject


class WeatherData: Subject {

    val _observers = mutableListOf<Any>()
    var _temperature: Float = 0.0f
    var _humidity: Float = 0.0f
    var _pressure: Float = 0.0f



    override fun registerObserver(obj: Observer) {
        this._observers.add(obj)
    }

    override fun removeObserver(obj: Observer) {
        var i = this._observers.indexOf(obj)
        if(i>= 0 ) this._observers.removeAt(i)
    }

    override fun notifyObservers() {
        for (i in 0..this._observers.size-1){
            var observer: Observer = this._observers.get(i) as Observer
            observer.update(this._temperature, this._humidity, this._pressure)
        }
    }
    fun mesurementsChanged(){
        notifyObservers()
    }
    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float){
        this._temperature = temperature
        this._humidity = humidity
        this._pressure = pressure
        mesurementsChanged()
    }
}