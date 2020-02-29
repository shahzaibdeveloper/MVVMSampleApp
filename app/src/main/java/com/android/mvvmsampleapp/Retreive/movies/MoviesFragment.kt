package com.android.mvvmsampleapp.Retreive.movies

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.mvvmsampleapp.R
import com.android.mvvmsampleapp.data1.model1.Movie
import com.android.mvvmsampleapp.data1.network1.MoviesApi
import com.android.mvvmsampleapp.data1.repositories.MoviesRepository

import kotlinx.android.synthetic.main.movies_fragment.*

class MoviesFragment : Fragment() ,RecyclerViewClickListner{

  private lateinit var factory: MoviesViewModelFactory

    private lateinit var viewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = MoviesApi()

        val repository =
            MoviesRepository(api)
        factory =
            MoviesViewModelFactory(
                repository
            )

        viewModel = ViewModelProviders.of(this,factory).get(MoviesViewModel::class.java)

    viewModel.getMovies()
        viewModel.movies.observe(viewLifecycleOwner, Observer{ movies ->

            recycler.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = MoviesAdapter(movies,this)

            }



        })

    }

    override fun onRecyclerViewItemClick(view: View, movie: Movie) {

        when (view.id)
        {
            R.id.t1 ->
            {

                Toast.makeText(requireContext(),"T1 ",Toast.LENGTH_LONG).show()
            }
            R.id.t2 ->{

                Toast.makeText(requireContext(),"T2",Toast.LENGTH_LONG).show()

            }
        }

    }

}
