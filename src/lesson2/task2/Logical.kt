@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr
import ru.spbstu.kotlin.generate.assume.retry
import java.lang.Math.pow
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    val first = (number / 1000) % 10
    val second = (number / 100) % 10
    val thirt = (number / 10) % 10
    val four = number % 10

    return when {
        first + second == thirt + four -> true
        else -> false
    }
}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    return when {
        x1 == x2 -> true
        y1 == y2 -> true
        x1 == y2 && y1 == x2 -> true
        else -> false
    }
}


/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
    if (month == 2) {
        if (year % 400 == 0) return 29
        if (year % 100 == 0) return 28
        if (year % 4 == 0) return 29
    } else if (month != 2) {
        if (month in 1..7 && month % 2 == 0) return 30
        if (month in 1..7 && month % 2 != 0) return 31
        return if (month in 8..12 && month % 2 == 0) 31 else 30
    }
    return 28
}

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean {
    return when {
        sqrt((x2 - x1).pow(2.0) + (y2 - y1).pow(2.0)) + r1 <= r2 -> true
        else -> false
    }
}

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
    return when {
        (a <= r && b <= s) || (a <= s && b <= r) -> true
        (b <= r && c <= s) || (b <= s && c <= r) -> true
        (a <= r && c <= s) || (a <= s && c <= r) -> true
        else -> false
    }
}
