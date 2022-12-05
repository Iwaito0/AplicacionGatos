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
            bindingDetailNombreGato( binding.nombreRaza,gatos)
            bindingDetail( binding.descripcionGato,gatos)
            bindingDetailDetalles( binding.detallesGato,gatos)

        }
    }


    private fun bindingDetailNombreGato(nombreRaza: TextView, gatos: Gatos) {
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
    private fun bindingDetailDetalles(detallesGato: TextView, gatos: Gatos?) {
        detallesGato.text = buildSpannedString {
            bold { append("Origen: ") }
            appendLine(gatos?.origen)
            append()
            appendLine()
            bold { append("Tipo de raza: ") }
            appendLine(gatos?.tipoRaza)
            append()
            appendLine()
            bold { append("Color del pelaje: ") }
            appendLine(gatos?.colorPelaje)
            append()
            appendLine()
            bold { append("Altura minima: ") }
            appendLine(gatos?.tamanoMin?.toBigDecimal()?.toPlainString()+" inches")
            append()
            bold { append("Altura maxima: ") }
            appendLine(gatos?.tamanoMax?.toBigDecimal()?.toPlainString()+" inches")
            append()
            appendLine()
            bold { append("Peso minimo: ") }
            appendLine(gatos?.pesoMin?.toBigDecimal()?.toPlainString() + " libras")
            append()
            bold { append("Peso maximo: ") }
            appendLine(gatos?.pesoMax?.toBigDecimal()?.toPlainString()+ " libras")
            append()
            appendLine()
            bold { append("Esperanza de vida minima: ") }
            appendLine(gatos?.esperamzaVidaMin?.toBigDecimal()?.toPlainString()+" años")
            append()
            bold { append("Esperanza de vida maxima: ") }
            appendLine(gatos?.esperamzaVidaMax?.toBigDecimal()?.toPlainString()+" años")
            append()
            appendLine()
        }
    }
}