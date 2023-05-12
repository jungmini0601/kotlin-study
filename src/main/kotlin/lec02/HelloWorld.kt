package lec02

open class Shape(
    val x: Double,
    val y: Double) {

    fun paint() {
        println("Shape ${x}, ${y}")
    }
}

class Circle(
    x:Double,
    y: Double,
    val radius: Double
): Shape(x, y)

fun main() {

}

