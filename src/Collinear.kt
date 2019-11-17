package com.example

import com.example.entities.Line
import com.example.entities.Point
import java.util.HashSet


/**
 * This class aims to find the lines in a two dimensional space,
 * which are composed by at least N collinear points.
 * It executes in O(N^3) time and O(N) space.
 */
class Collinear {

    fun getCollinear(points: Array<Point>, n: Int): List<List<Point>> {
        // Return immediately with an empty list if:
        // - there are less then 2 points into the space or
        // - there aren't enough points in the space
        if (points.size < 2 || n > points.size) {
            return listOf()
        }

        // Since we are using a Set data structure because it performs
        // the lookup operation in constant O(1) time.
        val lines = HashSet<Line>()

        // Loop through all couples of points. O(n^2) time.
        for (i in points.indices) {
            for (j in i + 1 until points.size) {

                val line = Line(points[i], points[j])

                if (lines.contains(line)) {
                    continue // Line already considered
                }

                // Loop through all the points. O(n) time.
                for (p3 in points) {

                    // The check for understand if p3 is collinear with the line
                    // is performed in constant O(1) time.
                    if (line.isCollinear(p3)) {

                        // Since points is a Set too,
                        // If p3 is already present it isn't inserted.
                        line.points.add(p3)
                    }
                }

                lines.add(line)
            }
        }

        // Return only the lines which has at least n points.
        return lines
            .asSequence()
            .filter { it.points.size >= n }
            .map { it.points.toList() }
            .toList()
    }
}