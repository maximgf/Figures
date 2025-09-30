class Rect(var x: Int, var y: Int, var width: Int, var height: Int) : Movable, Figure(0), Transforming {
    var color: Int = -1

    lateinit var name: String

    constructor(rect: Rect) : this(rect.x, rect.y, rect.width, rect.height)

    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    override fun area(): Float {
        return (width * height).toFloat()
    }

    override fun resize(zoom: Int) {
        width = (width * zoom / 100.0).toInt()
        height = (height * zoom / 100.0).toInt()
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        val dx = x - centerX
        val dy = y - centerY

        when (direction) {
            RotateDirection.Clockwise -> {
                x = centerX - dy - height / 2
                y = centerY + dx - width / 2
                // Меняем ширину и высоту местами при повороте
                val temp = width
                width = height
                height = temp
            }
            RotateDirection.CounterClockwise -> {
                x = centerX + dy - width / 2
                y = centerY - dx - height / 2
                // Меняем ширину и высоту местами при повороте
                val temp = width
                width = height
                height = temp
            }
        }
    }

    override fun toString(): String {
        return "Rect(x=$x, y=$y, width=$width, height=$height, area=${area()})"
    }
}