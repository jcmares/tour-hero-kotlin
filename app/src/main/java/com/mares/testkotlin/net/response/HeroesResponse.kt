package com.mares.testkotlin.net.response

import com.mares.testkotlin.mvp.model.SuperHeroe


data class HeroesResponse( var superheroes : List<SuperHeroe> ) {
    override fun toString(): String {
        return "HeroesResponse(superheroes=$superheroes)"
    }
}

