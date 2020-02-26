package com.mares.testkotlin.mvp.view.activity



import android.os.Bundle
import androidx.fragment.app.Fragment
import com.mares.testkotlin.mvp.view.fragment.ItemFragment

class MainActivity : BaseActivity() {

    override fun crearFragmento(): Fragment {
        return ItemFragment().getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
