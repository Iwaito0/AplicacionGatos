package com.ivanvegagonzalez.myapplication2frag.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ivanvegagonzalez.myapplication2frag.R
import com.ivanvegagonzalez.myapplication2frag.databinding.FragmentDetailBinding
import com.ivanvegagonzalez.myapplication2frag.loadUrl
import com.ivanvegagonzalez.myapplication2frag.model.Conctato

class DetailFragment : Fragment(R.layout.fragment_detail) {
    private  val viewModel: DetailViewModel by viewModels {
        DetailViewModelFactory(arguments?.getParcelable<Conctato>(EXTRA_Conctato)!!)
    }
    companion object{
        const val EXTRA_Conctato = "DetailActivity:Conctato"
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailBinding.bind(view)


        viewModel.movie.observe(viewLifecycleOwner){ conctato ->
            (requireActivity() as AppCompatActivity).supportActionBar?.title = conctato.title
            binding.imagen.loadUrl(conctato.urlImagen)
        }
    }
}