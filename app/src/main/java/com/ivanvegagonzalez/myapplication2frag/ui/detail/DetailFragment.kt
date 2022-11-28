package com.ivanvegagonzalez.myapplication2frag.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ivanvegagonzalez.myapplication2frag.R
import com.ivanvegagonzalez.myapplication2frag.databinding.FragmentDetailBinding
import com.ivanvegagonzalez.myapplication2frag.loadUrl
import com.ivanvegagonzalez.myapplication2frag.model.Gatos

class DetailFragment : Fragment(R.layout.fragment_detail) {
    private  val viewModel: DetailViewModel by viewModels {
        DetailViewModelFactory(arguments?.getParcelable<Gatos>(EXTRA_GATO)!!)
    }
    companion object{
        const val EXTRA_GATO = "DetailActivity:Gatos"
    }


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailBinding.bind(view)


        viewModel.gato.observe(viewLifecycleOwner){ gatos ->
            (requireActivity() as AppCompatActivity).supportActionBar?.title = gatos.title
            binding.imagen.loadUrl(gatos.urlImagen)
            bindingDetailN( binding.nombreRaza,gatos)
            bindingDetail( binding.descripcionGato,gatos)
        }
    }
    private fun bindingDetailN(nombreRaza: TextView, gatos: Gatos) {
        nombreRaza.text = buildSpannedString {
            bold { append("Nombre de la raza: ") }
            appendLine(gatos.title)
            append()
        }
    }
    private fun bindingDetail(descripcionGato: TextView, gatos: Gatos) {
        descripcionGato.text = buildSpannedString {
            bold { append("Descripcion: ") }
            appendLine(gatos.descripcion)
            append()
        }
    }
}