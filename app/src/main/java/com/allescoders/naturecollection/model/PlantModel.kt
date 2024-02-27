package com.allescoders.naturecollection.model

class PlantModel(
    val name: String = "Tulipe",
    val description: String = "Petite description",
    val imgUrl: String,
    var liked: Boolean = false
) {
    
    constructor() : this(
        name = "Tulipe",
        description = "Petite description",
        imgUrl = "default_url",
        liked = false
    )
}
