package com.example

import com.example.dto.ErrorDTO
import com.example.entities.Point
import com.google.gson.Gson
import io.ktor.http.*
import kotlin.test.*
import io.ktor.server.testing.*

class ApplicationTest {

    private val gson = Gson()

    @Test
    fun testHandlingErrorLinesApi() {
        withTestApplication({ module() }) {
            handleRequest(HttpMethod.Get, "/lines/prova").apply {
                assertEquals(HttpStatusCode.BadRequest, response.status())
                assertEquals(gson.toJson(ErrorDTO("Unparsable num of lines")), response.content)
            }
        }
    }

    @Test
    fun testHandlingErrorCreatePointApi() {
        withTestApplication({ module() }) {
            handleRequest(HttpMethod.Post, "/point") {
                addHeader("Content-Type", "application/json")
                setBody("{\"prova\": 1}")
            }.apply {
                assertEquals(HttpStatusCode.BadRequest, response.status())
                assertEquals(gson.toJson(ErrorDTO("Unparsable point")), response.content)
            }
        }
    }

    @Test
    fun testCreatePointApi() {
        val point = Point(1.0,2.0)
        val pointJson = gson.toJson(point)
        withTestApplication({ module() }) {
            handleRequest(HttpMethod.Post, "/point") {
                addHeader("Content-Type", "application/json")
                setBody(pointJson)
            }.apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(pointJson, response.content)
            }
        }
    }
}
