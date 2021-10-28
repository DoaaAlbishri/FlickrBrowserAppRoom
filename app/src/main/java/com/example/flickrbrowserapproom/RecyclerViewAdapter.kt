package com.example.flickrbrowserapproom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_row.view.*

class RecyclerViewAdapter(
        val mainActivity: MainActivity, private val images: ArrayList<Image>, private val Favimages: List<Image>
) : RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>(){
    class ItemViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)

    var ctx: Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        ctx= parent.context
        return ItemViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.item_row, parent, false
                )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val image=images[position]
        holder.itemView.apply{
            tvImage.text= image.title
            Glide.with(this)
                .load(image.link)
                .into(ivImage)
            //open Image in full screen
            llItem.setOnClickListener {
                mainActivity.openImage(image.link)
            }
            if(Favimages.contains(image))
                imageButton.setImageResource(R.drawable.ic_baseline_favorite_24)
            //add image to fav
            imageButton.setOnClickListener {
                if(!Favimages.contains(image))
                    imageButton.setImageResource(R.drawable.ic_baseline_favorite_24)
                mainActivity.addFav(image.ID,image.title,image.link)
            }
        }

    }

    override fun getItemCount(): Int =images.size

}

class RecyclerViewAdapter2(
    val mainActivity: MainActivity, private val images: List<Image>
) : RecyclerView.Adapter<RecyclerViewAdapter2.ItemViewHolder>(){
    class ItemViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)

    var ctx: Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        ctx= parent.context
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val image=images[position]
        holder.itemView.apply{
            imageButton.setImageResource(R.drawable.ic_baseline_favorite_24)
            tvImage.text= image.title
            Glide.with(this)
                .load(image.link)
                .into(ivImage)
            //open Image in full screen
            llItem.setOnClickListener {
                mainActivity.openImage(image.link)
            }
            //remove image from fav
            imageButton.setOnClickListener {
                mainActivity.removeFav(image.ID,image.title,image.link)
            }
        }

    }

    override fun getItemCount(): Int =images.size

}