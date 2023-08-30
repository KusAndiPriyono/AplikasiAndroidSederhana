package com.example.aplikasiandroidsederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.aplikasiandroidsederhana.databinding.ActivityHeroDetailBinding

class HeroDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_HERO = "extra_hero"
    }

    private lateinit var binding: ActivityHeroDetailBinding

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Detail Hero"

        val hero = intent.getParcelableExtra<Hero>(EXTRA_HERO) as Hero

        Glide.with(this)
            .load(hero.image)
            .into(binding.ivDetailImage)

        binding.tvDetailName.text = hero.name
        binding.tvDetailElement.text = hero.element
        binding.tvDetailBuild.text = hero.build
        binding.tvDetailSkill.text = hero.skill
        binding.tvDetailDescription.text = hero.description

    }
}