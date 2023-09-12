package com.rival.belajarrecycleview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rival.belajarrecycleview.adapter.heroAdapter
import com.rival.belajarrecycleview.databinding.ActivityMainBinding
import com.rival.belajarrecycleview.model.dataHeroes

class MainActivity : AppCompatActivity() {

    private var list = ArrayList<dataHeroes>()
    private lateinit var rvHeroes: RecyclerView

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvHeroes = binding.rvMain
        rvHeroes.setHasFixedSize(true)

        list.addAll(getListHeroes())

        showRecyclerView()

    }

    private fun showRecyclerView() {
        rvHeroes.layoutManager = LinearLayoutManager(this)

        val listHeroAdapter = heroAdapter(list)
        rvHeroes.adapter = listHeroAdapter
    }

    private fun getListHeroes(): ArrayList<dataHeroes> {
        val name = resources.getStringArray(R.array.data_name)
        val description = resources.getStringArray(R.array.data_description)
        val image = resources.obtainTypedArray(R.array.data_photo)

        for (i in name.indices) {
            val hero = dataHeroes(
                name[i],
                description[i],
                image.getResourceId(i, -1)
            )
            list.add(hero)
        }

        return list
    }
}