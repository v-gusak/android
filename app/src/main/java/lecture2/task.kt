package lecture2

fun main() {
    val dog = Dog(5, true, 15)
    dog.run()
    dog.makeQuietNoise()
    dog.makeLoudNoise()
    dog.whatIsEating()
    print("Tail length: ${dog.getTailLength()}\n\n")

    val duck = Duck(1, true, 4)
    duck.makeQuietNoise()
    duck.makeLoudNoise()
    duck.whatIsEating()
    print("Beak length: ${duck.getBeakLength()}\n\n")

    val fish = Fish(2, false, "silver")
    fish.whatIsEating()
    println("Color: ${fish.getColor()}\n")

    val animals = listOf(dog, duck, fish)

    animals.forEach { it.showAge() }

    print("\n")

    for (i in animals.indices) {
        animals[i].aliveOrNot()
    }
}