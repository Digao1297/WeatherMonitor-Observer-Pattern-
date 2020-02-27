import `class`.CurrentConditionsDisplay
import `class`.StatisticsDisplay
import `class`.WeatherData
import interfaces.Observer

fun main() {
    var weatherData: WeatherData = WeatherData()
    var currentConditionsDisplay:Observer = CurrentConditionsDisplay(weatherData)
    var statisticsDisplay: Observer = StatisticsDisplay(weatherData)
    weatherData.setMeasurements(10f,70f,1f)
    weatherData.setMeasurements(5f,50f,0f)

}