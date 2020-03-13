package org.wit.placemark.console.main
import PlacemarkMemStore
import mu.KotlinLogging
import org.wit.placemark.console.controllers.PlacemarkController
import org.wit.placemark.console.views.PlacemarkView

private val logger = KotlinLogging.logger {}
val controller = PlacemarkController()

val placemarks = PlacemarkMemStore()
val placemarkView = PlacemarkView()

fun main(args: Array<String>) {

    var input: Int

    do {
        input = placemarkView.menu()
        when(input) {
            1 -> addPlacemark()
            2 -> updatePlacemark()
            3 -> placemarkView.listPlacemarks(placemarks)
            4 -> searchPlacemark()
            -99 -> dummyData()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
    logger.info { "Shutting Down Placemark Console App" }
}

fun addPlacemark(){
    controller.add()
}

fun updatePlacemark() {
    controller.update()
}


fun searchPlacemark() {
    controller.search()
}


fun dummyData() {
    controller.dummyData()
}