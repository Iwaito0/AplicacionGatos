package com.ivanvegagonzalez.myapplication2frag.ui.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ivanvegagonzalez.myapplication2frag.R
import com.ivanvegagonzalez.myapplication2frag.databinding.ViewGatoBinding
import com.ivanvegagonzalez.myapplication2frag.inflate
import com.ivanvegagonzalez.myapplication2frag.loadUrl
import com.ivanvegagonzalez.myapplication2frag.model.Gatos


class GatosAdapter(val listener: (Gatos) -> Unit):
    RecyclerView.Adapter<GatosAdapter.ViewHolder>() {

    var gato = emptyList<Gatos>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.view_gato, false)
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.view_gato, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gato = gato[position]
        holder.bind(gato)

        holder.itemView.setOnClickListener {
            listener(gato)
        }
    }

    override fun getItemCount(): Int = gato.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = ViewGatoBinding.bind(view)
        fun bind(gato: Gatos){
            binding.tNombre.text=gato.title
            binding.imagen.loadUrl(gato.urlImagen)
        }
    }
}

