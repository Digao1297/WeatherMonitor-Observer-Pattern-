package interfaces

interface Subject {
    fun registerObserver(obj: Observer)
    fun removeObserver(obj: Observer)
    fun notifyObservers()
}