fun main() {

    // Создаем коллекции фигур
    val figures = listOf(
        Rect(10, 10, 20, 30),
        Square(5, 5, 15),
        Circle(0, 0, 10)
    )

    // Тестируем перемещение для всех фигур
    println("=== ТЕСТИРОВАНИЕ ПЕРЕМЕЩЕНИЯ ===")
    figures.forEach { figure ->
        when (figure) {
            is Movable -> {
                println("До перемещения: $figure")
                figure.move(5, 5)
                println("После move(5, 5): $figure")
            }
        }
        println()
    }

    // Тестируем масштабирование для всех фигур
    println("=== ТЕСТИРОВАНИЕ МАСШТАБИРОВАНИЯ ===")
    figures.forEach { figure ->
        when (figure) {
            is Transforming -> {
                println("До масштабирования: $figure")
                figure.resize(150)
                println("После resize(150%): $figure")
            }
        }
        println()
    }

    // Тестируем повороты для всех фигур
    println("=== ТЕСТИРОВАНИЕ ПОВОРОТОВ ===")
    figures.forEach { figure ->
        when (figure) {
            is Transforming -> {
                println("До поворота: $figure")
                figure.rotate(RotateDirection.Clockwise, 0, 0)
                println("После rotate(Clockwise, 0, 0): $figure")
                figure.rotate(RotateDirection.CounterClockwise, 0, 0)
                println("После обратного поворота: $figure")
            }
        }
        println()
    }

    // Вывод площадей всех фигур
    println("=== ПЛОЩАДИ ВСЕХ ФИГУР ===")
    figures.forEachIndexed { index, figure ->
        println("Фигура ${index + 1} (${figure::class.simpleName}): ${"%.2f".format(figure.area())}")
    }

    // Комплексное тестирование всех функций последовательно
    println("\n=== КОМПЛЕКСНОЕ ТЕСТИРОВАНИЕ ===")
    val testFigures = listOf(
        Rect(0, 0, 10, 20),
        Square(0, 0, 10),
        Circle(0, 0, 10)
    )
}