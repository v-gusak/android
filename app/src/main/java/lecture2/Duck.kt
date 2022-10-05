package lecture2

class Duck(age: Int, isAlive: Boolean, private val beakLength:Int) : Animal(age, isAlive), MakeNoise {
    override fun makeLoudNoise() {
        println("КРЯ!")
    }

    override fun makeQuietNoise() {
        println("кря")
    }

    override fun whatIsEating() {
        println("eat bread")
    }

    fun getBeakLength(): Int {
        return this.beakLength
    }
}