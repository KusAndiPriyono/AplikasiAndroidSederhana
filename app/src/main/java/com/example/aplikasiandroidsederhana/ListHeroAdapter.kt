package com.example.aplikasiandroidsederhana

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasiandroidsederhana.databinding.ItemRowHeroBinding

class ListHeroAdapter(private val listHero: ArrayList<Hero>) :
    RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            ItemRowHeroBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val hero = listHero[position]
        holder.binding.tvHeroName.text = hero.name
        holder.binding.tvItemElement.text = hero.element
        holder.binding.ivItemImage.setImageResource(hero.image)

        holder.binding.btnDetail.setOnClickListener {
            val intent = Intent(it.context, HeroDetailActivity::class.java)
            intent.putExtra(HeroDetailActivity.EXTRA_HERO, hero)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listHero.size

    class ListViewHolder(var binding: ItemRowHeroBinding) : RecyclerView.ViewHolder(binding.root)

}