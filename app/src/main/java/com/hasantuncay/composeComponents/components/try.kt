package com.hasantuncay.composeComponents.components

import javax.annotation.Nullable


enum class Sport { HIKE, RUN, TOURING_BICYCLE, E_TOURING_BICYCLE }

data class Summary(val sport: Sport, val distance: Int)

fun main() {
    val sportStats = listOf(Summary(Sport.HIKE, 92),
        Summary(Sport.RUN, 77),
        Summary(Sport.TOURING_BICYCLE, 322),
        Summary(Sport.E_TOURING_BICYCLE, 656))
    var maxVal = Summary(Sport.E_TOURING_BICYCLE,0)
sportStats.forEach {summary->

    if ( summary.sport != Sport.E_TOURING_BICYCLE){
        if(summary.distance> maxVal.distance){
          maxVal= summary
        }

    }
    println("${maxVal.sport} ${maxVal.distance}")
println("Selected sport: ${maxVal.sport} with ${maxVal.sport} km")
}

    }


