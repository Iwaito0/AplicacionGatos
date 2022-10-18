package com.ivanvegagonzalez.myapplication2frag.ui.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ivanvegagonzalez.myapplication2frag.R
import com.ivanvegagonzalez.myapplication2frag.databinding.ViewConctatoBinding
import com.ivanvegagonzalez.myapplication2frag.inflate
import com.ivanvegagonzalez.myapplication2frag.loadUrl
import com.ivanvegagonzalez.myapplication2frag.model.Conctato


class ConctatosAdapter(val listener: (Conctato) -> Unit):
    RecyclerView.Adapter<ConctatosAdapter.ViewHolder>() {

    var conctato = emptyList<Conctato>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.view_conctato, false)
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.view_conctato, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val conctato = conctato[position]
        holder.bind(conctato)

        holder.itemView.setOnClickListener {
            listener(conctato)
        }
    }

    override fun getItemCount(): Int = conctato.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = ViewConctatoBinding.bind(view)
        fun bind(conctato: Conctato){
            binding.tNombre.text=conctato.title
            binding.tTelefono.text=conctato.telefono;
            binding.tEmail.text=conctato.correo
            binding.imagen.loadUrl(conctato.urlImagen)
        }
    }
}

