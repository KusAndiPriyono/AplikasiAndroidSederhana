package com.example.aplikasiandroidsederhana

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplikasiandroidsederhana.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var list = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "List Hero"

        list.addAll(getListHero())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_aboutme, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("Recycle")
    private fun getListHero(): ArrayList<Hero> {
        val dataName = resources.getStringArray(R.array.data_names)
        val dataElement = resources.getStringArray(R.array.data_elements)
        val dataBuild = resources.getStringArray(R.array.data_builds)
        val dataSkill = resources.getStringArray(R.array.data_skills)
        val dataDescription = resources.getStringArray(R.array.data_descriptions)
        val dataImage = resources.obtainTypedArray(R.array.data_images)
        val listHero = ArrayList<Hero>()
        for (position in dataName.indices) {
            val hero = Hero(
                dataName[position],
                dataElement[position],
                dataBuild[position],
                dataSkill[position],
                dataDescription[position],
                dataImage.getResourceId(position, -1)
            )
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        binding.rvListHero.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        binding.rvListHero.adapter = listHeroAdapter
    }


}