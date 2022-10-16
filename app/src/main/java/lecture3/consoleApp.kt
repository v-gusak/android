package lecture3

fun main() {
    val figure1 = Figure(4, 5) // 20
    val figure2 = Figure(6, 2) // 12
    val figure3 = Figure(10, 4) // 40
    val figures = listOf(figure1, figure2, figure3)

    var totalArea = 0

    figures.forEach {
        totalArea += it.area
    }

    println("Sum of areas = ${figure1.area} + ${figure2.area} + ${figure3.area} = $totalArea\n")

    val rect1 = Shape.Rectangle(4, 2)
    val rect2 = Shape.Rectangle(5, 1)
    val rect3 = Shape.Rectangle(8, 3)
    val circle1 = Shape.Ellipse.Circle(5)
    val circle2 = Shape.Ellipse.Circle(15)
    val oval = Shape.Ellipse.Oval(3, 7)
    val line1 = Shape.Line(23)
    val line2 = Shape.Line(12)

    val shapes = mutableListOf(rect1, rect2, rect3, circle1, circle2, oval, line1, line2)

    var rectangles = shapes.filterIsInstance<Shape.Rectangle>().count()
    var circles = shapes.filterIsInstance<Shape.Ellipse.Circle>().count()
    var ovals = shapes.filterIsInstance<Shape.Ellipse.Oval>().count()
    var lines = shapes.filterIsInstance<Shape.Line>().count()

    println("Count of rectangles = $rectangles")
    println("Count of circles = $circles")
    println("Count of ovals = $ovals")
    println("Count of lines = $lines")

    rectangles = 0
    circles = 0
    ovals = 0
    lines = 0

    shapes.forEach {
        when(it) {
            is Shape.Rectangle -> rectangles++
            is Shape.Ellipse.Circle -> circles++
            is Shape.Ellipse.Oval -> ovals++
            is Shape.Line -> lines++
        }
    }

    println("\nCount of rectangles = $rectangles")
    println("Count of circles = $circles")
    println("Count of ovals = $ovals")
    println("Count of lines = $lines")
}