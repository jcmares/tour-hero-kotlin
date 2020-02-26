package com.mares.testkotlin.mvp.view.fragment

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment

import com.mares.testkotlin.R
import com.mares.testkotlin.mvp.model.SuperHeroe
import com.mares.testkotlin.databinding.FragmentDetalleHeroeBinding

class DetailHeroFragment : Fragment() {

    var heroe : SuperHeroe? = null

    private val ID_SERIALIZACION_MODEL : String =  "SerializacionModel"

    companion object{
        fun newInstance(hero : SuperHeroe) : Fragment{
            val fragment =
                DetailHeroFragment()
            fragment.heroe = hero
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detalle_heroe, container, false)
        restaurarInstanceState(savedInstanceState)
        dataBindingFunction()
        return view
    }

    fun dataBindingFunction(){
        val binding : FragmentDetalleHeroeBinding = DataBindingUtil.setContentView(requireActivity(), R.layout.fragment_detalle_heroe )
        binding.model = heroe
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(ID_SERIALIZACION_MODEL, heroe)
    }

    fun restaurarInstanceState(savedInstanceState: Bundle?){
        if (savedInstanceState == null) return
        else {
            heroe = savedInstanceState.getParcelable(ID_SERIALIZACION_MODEL) as SuperHeroe
        }
    }

}
