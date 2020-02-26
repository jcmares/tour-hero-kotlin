package com.mares.testkotlin.mvp.view.activity


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mares.testkotlin.R

abstract class BaseActivity :  AppCompatActivity(){

    protected fun getLayoutActivity(): Int {
        return R.layout.base_activity_layout
    }

    protected abstract fun crearFragmento() : Fragment


    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutActivity())

        this.cargarFragmento()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = this.menuInflater
        inflater.inflate(this.getMenuId(), menu)
        return true
    }


    protected fun getMenuId() : Int {
        return R.menu.menu_main
    }

    fun cargarFragmento(){
        val fragmentManager = supportFragmentManager
        var fragment =  supportFragmentManager.findFragmentById(R.id.singleFragmentContainer)

        if (fragment == null) {
            fragment = this.crearFragmento()

            fragmentManager.beginTransaction()
                .add(R.id.singleFragmentContainer,fragment).commit()
        }

    }


}