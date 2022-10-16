package lecture3

sealed interface Shape {
    class Rectangle(side1: Int, side2: Int): Shape
    class Line(length: Int): Shape

    sealed class Ellipse: Shape {
        class Circle(radius: Int) : Ellipse()
        class Oval(smallerRadius: Int, largerRadius: Int) : Ellipse()
    }
}