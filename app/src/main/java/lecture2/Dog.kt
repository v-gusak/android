package lecture2

class Dog(age: Int, isAlive: Boolean, private val tailLength: Int) : Animal(age, isAlive), MakeNoise {
    override fun makeLoudNoise() {
        println("FАВ!")
    }

    override fun makeQuietNoise() {
        println("гав")
    }

    override fun whatIsEating() {
        println("eat meat")
    }

    fun getTailLength(): Int {
        return this.tailLength
    }
}