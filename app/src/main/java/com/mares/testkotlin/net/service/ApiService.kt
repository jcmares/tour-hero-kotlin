package com.mares.testkotlin.net.service

import com.mares.testkotlin.net.response.HeroesResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("bins/bvyob")
    fun getHeroes(): Observable<HeroesResponse>
}