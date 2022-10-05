package lecture2

class Fish(age: Int, isAlive: Boolean, private val color: String) : Animal(age, isAlive) {
    override fun whatIsEating() {
        println("eat worm")
    }

    fun getColor(): String {
        return this.color
    }
}