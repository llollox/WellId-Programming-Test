package com.example.entities

import java.util.HashSet


class Line(private val point1: Point, p2: Point) {
    private val gradient: Double?
    private val shift: Double
    val points: HashSet<Point> = HashSet()


    // Constructor *************************************************************************************
    init {
        this.points.add(this.point1)
        this.points.add(p2)
        this.gradient = this.getGradient(this.point1, p2)
        this.shift = this.getShift(this.point1, this.gradient)
    }


    // Class functions *********************************************************************************
    fun isCollinear(p: Point): Boolean {
        return this == Line(this.point1, p)
    }

    fun contains(p: Point): Boolean {
        return this.points.contains(p)
    }


    // Private class functions ************************************************************************
    private fun getGradient(p1: Point, p2: Point): Double? {
        val gradient = if (p1.x == p2.x) { null } else ((p1.y - p2.y) / (p1.x - p2.x))
        return if (gradient == -0.0) 0.0 else gradient // Fix to avoid -0.0 number
    }

    private fun getShift(point: Point, gradient: Double?): Double {
        val shift = if (gradient == null) { point.x } else { point.y - gradient * point.x }
        return if (shift == -0.0) 0.0 else shift // Fix to avoid -0.0 number
    }

    // Equals and Hash Code ***************************************************************************
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Line

        if (gradient != other.gradient) return false
        if (shift != other.shift) return false

        return true
    }

    override fun hashCode(): Int {
        var result = gradient.hashCode()
        result = 31 * result + shift.hashCode()
        return result
    }


}