package com.mares.testkotlin.mvp.view

import com.mares.testkotlin.mvp.model.SuperHeroe

interface IView {
    fun desplegarHeroes(heroes : List<SuperHeroe>)
    fun mensajeError(msg : String)
}