package com.example

import com.example.entities.Point
import org.junit.Assert
import org.junit.Test

/**
 * This class is for testing the collinear function
 * which count how many collinear lines with at least a
 * certain number of points are present into the space.
 */
class CollinearTest {

    private val collinear = Collinear()

    @Test
    fun withEmptyInput__shouldReturnZero() {
        val output = this.collinear.getCollinear(arrayOf(), 2)
        Assert.assertEquals(0, output.size)
    }

    @Test
    fun with1Point__shouldReturnZero() {
        val p1 = Point(0.0, 0.0)
        val output = this.collinear.getCollinear(arrayOf(p1), 1)
        Assert.assertEquals(0, output.size)
    }

    @Test
    fun withOneLineOfPoints__shouldReturnOne() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(0.0, 1.0)
        val p3 = Point(0.0, 2.0)
        val output = this.collinear.getCollinear(arrayOf(p1, p2, p3), 3)
        Assert.assertEquals(1, output.size)
    }

    @Test
    fun withTwoLineOfPoints__shouldReturnTwo() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(0.0, 1.0)
        val p3 = Point(0.0, 2.0)
        val p4 = Point(-1.0, 1.0)
        val p5 = Point(1.0, 1.0)
        val output = this.collinear.getCollinear(arrayOf(p1, p2, p3, p4, p5), 3)
        Assert.assertEquals(2, output.size)
    }

    @Test
    fun withTwoLinesOf4__whenNIs4__shouldReturnTwo() {
        val p1 = Point(3.0, 0.0)
        val p2 = Point(4.0, 1.0)
        val p3 = Point(5.0, 2.0)
        val p4 = Point(6.0, 3.0)

        val p5 = Point(2.0, 8.0)
        val p6 = Point(3.0, 6.0)
        val p7 = Point(4.0, 4.0)

        val output = this.collinear.getCollinear(arrayOf(p1, p2, p3, p4, p5, p6, p7), 4)
        Assert.assertEquals(2, output.size)
    }

    @Test
    fun withTwoLinesOf4__withNoisePoints__whenNIs4__shouldReturnTwo() {
        val p1 = Point(3.0, 0.0)
        val p2 = Point(4.0, 1.0)
        val p3 = Point(5.0, 2.0)
        val p4 = Point(6.0, 3.0)

        val p5 = Point(2.0, 8.0)
        val p6 = Point(3.0, 6.0)
        val p7 = Point(4.0, 4.0)

        val p9 = Point(-1.0, 1.0)
        val p10 = Point(1.0, 1.0)
        val p11 = Point(8.0, 8.0)
        val p12 = Point(3.0, 8.0)
        val output = this.collinear.getCollinear(arrayOf(p1, p2, p3, p4, p5, p6, p7, p9, p10, p11, p12), 4)
        Assert.assertEquals(2, output.size)
    }

}