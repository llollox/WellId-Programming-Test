package com.example

import com.example.entities.Line
import com.example.entities.Point
import org.junit.Test
import kotlin.test.assertEquals

/**
 * This class is for the equals and hashcode methods
 * of the Line class.
 */
class LineTest {

    @Test
    fun withBothNullGradientAndSameShift__shouldBeSame() {
        val p1 = Point(0.0,0.0)
        val p2 = Point(0.0, 1.0)
        val l1 = Line(p1, p2)

        val p3 = Point(0.0,2.0)
        val p4 = Point(0.0, 3.0)
        val l2 = Line(p3, p4)

        assertEquals(l1, l2)
    }

    @Test
    fun withTwoVerticalLines__shouldBeSame() {
        val p1 = Point(0.0,1.0)
        val p2 = Point(-1.0, 1.0)
        val l1 = Line(p1, p2)

        val p3 = Point(0.0,1.0)
        val p4 = Point(1.0, 1.0)
        val l2 = Line(p3, p4)

        assertEquals(l1, l2)
    }

    @Test
    fun whenUsingHashSet__withTwoVerticalLines__shouldBeSame() {
        val set = HashSet<Line>()
        val p1 = Point(0.0,1.0)
        val p2 = Point(-1.0, 1.0)
        val l1 = Line(p1, p2)
        set.add(l1)

        val p3 = Point(0.0,1.0)
        val p4 = Point(1.0, 1.0)
        val l2 = Line(p3, p4)

        assertEquals(true, set.contains(l2))
    }
}