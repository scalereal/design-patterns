class Shape constructor(
    var xCoordinate: Int = 0,
    var yCoordinate: Int = 0,
    var color: String = ""
) : Cloneable {

    fun cloneTo(): Shape? {
        try {
            val copy: Shape = super.clone() as Shape
            copy.xCoordinate = this.xCoordinate
            copy.yCoordinate = this.yCoordinate
            copy.color = this.color
            return copy
        } catch (e: CloneNotSupportedException) {
            e.printStackTrace()
        }
        return null
    }
}

fun main() {
    val original: Shape = Shape().apply {
        xCoordinate = 10
        yCoordinate = 3
        color = "red"
    }

    val copy = original.cloneTo()?.apply {
        xCoordinate = 14
        yCoordinate = 80
        color = "blue"
    }

    println(copy!!.xCoordinate)

    // Output: 14
}