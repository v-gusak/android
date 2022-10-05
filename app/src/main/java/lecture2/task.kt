package lecture2

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