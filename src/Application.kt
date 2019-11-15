package com.example

import com.example.dto.ErrorDTO
import com.example.entities.Point
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {

    install(ContentNegotiation) {
        gson {}
    }

    val points = HashSet<Point>()
    val collinear = Collinear()

    routing {
        get("/space") {
            call.respond(points.toArray())
        }

        get("/lines/{n}") {
            call.parameters["n"]?.toIntOrNull()?.let { n ->
                val lines = collinear.getCollinear(points.toTypedArray(), n)
                call.respond(lines)

            } ?: call.respond(HttpStatusCode.BadRequest, ErrorDTO("Unparsable num of lines"))
        }

        delete("/space") {
            points.clear()
            call.respond(points.toArray())
        }

        post("/point") {
            call.receiveOrNull<Point>()?.let { point ->
                points.add(point)
                call.respond(point)

            } ?: call.respond(HttpStatusCode.BadRequest, ErrorDTO("Unparsable point"))

        }
    }
}
