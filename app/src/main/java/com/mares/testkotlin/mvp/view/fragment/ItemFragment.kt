package com.mares.testkotlin.mvp.view.fragment

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.mares.testkotlin.R
import com.mares.testkotlin.mvp.model.SuperHeroe
import com.mares.testkotlin.mvp.presenter.PresenterApi
import com.mares.testkotlin.mvp.view.HeroAdapter
import com.mares.testkotlin.mvp.view.IView
import com.mares.testkotlin.mvp.view.activity.DetailActivity
import io.reactivex.disposables.CompositeDisposable

class ItemFragment : Fragment(), IView, HeroAdapter.HeroListener,  SwipeRefreshLayout.OnRefreshListener {

    private var subscription : CompositeDisposable = CompositeDisposable()

    lateinit var swipeRefreshLayout : SwipeRefreshLayout

    val ID_SERIALIZACION_HERO : String = "IdSerializacionHero"

    private lateinit var presenter : PresenterApi

    lateinit var recyclerView : RecyclerView

    fun getInstance() : ItemFragment {
        return ItemFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = PresenterApi(this, subscription)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout) as SwipeRefreshLayout
        recyclerView = view.findViewById(R.id.list) as RecyclerView
        setContent()
        return view
    }

    fun setContent() {
        swipeRefreshLayout.setOnRefreshListener(this)
        swipeRefreshLayout.post {
            swipeRefreshLayout.isRefreshing = true
            onRefresh()
        }
    }

    override fun desplegarHeroes(heroes: List<SuperHeroe>) {
        swipeRefreshLayout.isRefreshing = false
        val adapter = HeroAdapter()
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager( activity )
        activity?.let { adapter.HeroAdapter( this, heroes, it) }
        recyclerView.adapter = adapter
    }

    override fun mensajeError(msg: String) {
        swipeRefreshLayout.isRefreshing = false
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }


    override fun onClick(hero: SuperHeroe) {
        activity.apply {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(ID_SERIALIZACION_HERO, hero)
            startActivity(intent)
        }
    }

    override fun onRefresh() {
        presenter.getHeroes()
    }

}
