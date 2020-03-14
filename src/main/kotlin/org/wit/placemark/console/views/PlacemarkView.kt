package org.wit.placemark.console.views
import PlacemarkMemStore
import org.wit.placemark.console.models.PlacemarkModel

class PlacemarkView {

    fun menu() : Int {

        var option : Int
        var input: String?

        println("MAIN MENU")
        println(" 1. Add Placemark")
        println(" 2. Update Placemark")
        println(" 3. List All Placemarks")
        println(" 4. Search Placemarks")
        println("-1. Exit")
        println()
        print("Enter Option : ")
        input = readLine()!!
        option = if (input.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            -9
        return option
    }

    fun listPlacemarks(placemarks : PlacemarkMemStore) {
        println("List All Placemarks")

        placemarks.logAll()
        println()
    }

    fun showPlacemark(placemark : PlacemarkModel) {
        if(placemark != null)
            println("Placemark Details [ $placemark ]")
        else
            println("Placemark Not Found...")
    }

    fun addPlacemarkData(placemark : PlacemarkModel) : Boolean {

        println()
        print("Enter a Title : ")
        placemark.title = readLine()!!
        print("Enter a Description : ")
        placemark.description = readLine()!!

        return placemark.title.isNotEmpty() && placemark.description.isNotEmpty()
    }

    fun updatePlacemarkData(placemark : PlacemarkModel) : Boolean {

        var tempTitle: String?
        var tempDescription: String?

        if (placemark != null) {
            print("Enter a new Title for [ " + placemark.title + " ] : ")
            tempTitle = readLine()!!
            print("Enter a new Description for [ " + placemark.description + " ] : ")
            tempDescription = readLine()!!

            if (!tempTitle.isNullOrEmpty() && !tempDescription.isNullOrEmpty()) {
                placemark.title = tempTitle
                placemark.description = tempDescription
                return true
            }
        }
        return false
    }

    fun getId() : Long {
        var strId : String? // String to hold user input
        var searchId : Long // Long to hold converted id
        print("Enter id to Search/Update : ")
        strId = readLine()!!
        searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }
}