package com.mares.testkotlin.mvp.view.activity



import android.os.Bundle
import androidx.fragment.app.Fragment
import com.mares.testkotlin.mvp.model.SuperHeroe
import com.mares.testkotlin.mvp.view.fragment.DetailHeroFragment


class DetailActivity : BaseActivity() {

    val ID_SERIALIZACION_HERO : String = "IdSerializacionHero"

    val TAG : String = DetailActivity::class.java.simpleName

    lateinit var hero : SuperHeroe

    override fun crearFragmento(): Fragment {
        return DetailHeroFragment.newInstance(
            hero
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        hero = this.intent.getParcelableExtra( ID_SERIALIZACION_HERO ) as SuperHeroe
        super.onCreate(savedInstanceState)
    }


}
