package lecture2

abstract class Animal constructor(private val age: Int, private val isAlive: Boolean) {
    abstract fun whatIsEating()
    fun run() {
        println("Тварина бігає")
    }

    fun aliveOrNot() {
        if (this.isAlive) println("Alive") else println("Dead")
    }

    fun showAge() {
        println("Age: ${this.age}")
    }
}