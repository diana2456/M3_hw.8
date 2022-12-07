package space.lobanovi.m3_hw8

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import space.lobanovi.m3_hw8.databinding.FlowersChatBinding
import kotlin.reflect.KFunction0

class FlowersAdapter(val data: ArrayList<Flowers>, val onClick: ( pos:Int)->Unit):
    RecyclerView.Adapter<FlowersAdapter.FlowerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
        return FlowerViewHolder(
            FlowersChatBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
        val data_model: Flowers = data.get(position)
        holder.my_img?.setImageResource(data_model.getImage())
        holder.txt_title?.setText(data_model.getTitle())
        holder.txt_description?.setText(data_model.getMessage())

        holder.bind()
    }

    override fun getItemCount(): Int = data.size


    inner class FlowerViewHolder(private val binding: FlowersChatBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var my_img: ImageView? = null
        var txt_title: TextView? = null
        var txt_description: TextView? = null
        fun bind() {
            itemView.setOnClickListener() {
                onClick(adapterPosition)
            }
            val item = data[adapterPosition]
            binding.titleTv.text = item.title
            binding.messageTv.text = item.message
            Glide.with(binding.chatIv).load(item.image).into(binding.chatIv)
        }
    }

}