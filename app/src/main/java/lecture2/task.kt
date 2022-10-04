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

interface MakeNoise {
    fun makeLoudNoise()
    fun makeQuietNoise()
}

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

class Fish(age: Int, isAlive: Boolean, private val color: String) : Animal(age, isAlive) {
    override fun whatIsEating() {
        println("eat worm")
    }

    fun getColor(): String {
        return this.color
    }
}

fun arrayExample() {
    //forEach
    val array = IntArray(5) { it * 1 }
    array.forEach { println(it) }

    print("\n")

    //for
    for (i in 0..4) {
        println(array[i])
    }
}

fun main() {
    val dog = Dog(5, true, 15)
    dog.run()
    dog.aliveOrNot()
    dog.showAge()
    dog.makeQuietNoise()
    dog.makeLoudNoise()
    dog.whatIsEating()
    print("Tail length: ${dog.getTailLength()}\n\n")

    val duck = Duck(1, true, 4)
    duck.aliveOrNot()
    duck.showAge()
    duck.makeQuietNoise()
    duck.makeLoudNoise()
    duck.whatIsEating()
    print("Beak length: ${duck.getBeakLength()}\n\n")

    val fish = Fish(2, true, "silver")
    fish.aliveOrNot()
    fish.showAge()
    fish.whatIsEating()
    println("Fish color: ${fish.getColor()}\n")

    arrayExample()
}