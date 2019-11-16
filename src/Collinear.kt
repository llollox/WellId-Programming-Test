package com.example

import com.example.entities.Line
import com.example.entities.Point
import java.util.HashSet


class Collinear {

    fun getCollinear(points: Array<Point>, n: Int): List<List<Point>> {
        if (points.size < 2 || n > points.size) {
            return listOf()
        }

        val lines = HashSet<Line>()
        for (i in points.indices) {
            for (j in i + 1 until points.size) {

                val line = Line(points[i], points[j])

                if (lines.contains(line)) {
                    continue // Line already considered
                }

                for (p3 in points) {
                    if (line.isCollinear(p3)) {
                        line.points.add(p3)
                    }
                }

                lines.add(line)
            }
        }

        return lines
            .asSequence()
            .filter { it.points.size >= n }
            .map { it.points.toList() }
            .toList()
    }
}