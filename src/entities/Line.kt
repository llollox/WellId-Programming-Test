package com.example.entities

import java.util.HashSet


class Line(private val point1: Point, p2: Point) {
    private val gradient: Double
    private val shift: Double
    val points: HashSet<Point> = HashSet()


    // Constructor *************************************************************************************
    init {
        this.points.add(this.point1)
        this.points.add(p2)
        this.gradient = this.getGradient(this.point1, p2)
        this.shift = this.getShift(this.point1, p2)
    }


    // Class functions *********************************************************************************
    fun isCollinear(p: Point): Boolean {
        return this == Line(this.point1, p)
    }

    fun contains(p: Point): Boolean {
        return this.points.contains(p)
    }


    // Private class functions ************************************************************************
    private fun getGradient(p1: Point, p2: Point): Double {
        return if (p1.x - p2.x == 0.0) {
            0.0
        } else ((p1.y - p2.y) / (p1.x - p2.x))

    }

    private fun getShift(p1: Point, p2: Point): Double {
        return if (p2.x - p1.x == 0.0) {
            0.0
        } else ((p2.x * p1.y - p1.x * p2.y) / (p2.x - p1.x))

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