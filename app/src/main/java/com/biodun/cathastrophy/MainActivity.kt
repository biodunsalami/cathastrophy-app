package com.biodun.cathastrophy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.biodun.cathastrophy.api.Api
import com.biodun.cathastrophy.api.ApiService
import com.biodun.cathastrophy.api.Repository
import com.biodun.cathastrophy.api.models.Breed
import com.biodun.cathastrophy.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var catsAdapter: CatsAdapter

    private val repository = Repository(Api.apiService)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        showDetails()

        MainScope().launch {
            setupRecyclerView(repository.getCats())
        }

    }

    private fun setupRecyclerView(cats: List<Cat>) = binding.catsRv.apply {
        catsAdapter = CatsAdapter(cats)
        adapter = catsAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
    }

    private fun moreButton(){

    }

}









//    private fun showDetails() {
//        repository.getCats3()
//            .enqueue(object: Callback<List<Breed>> {
//                override fun onResponse(call: Call<List<Breed>>, breedList: Response<List<Breed>>) {
//                    val catList = ArrayList<Cat>()
//                    for (breed in breedList.body()!!) {
//                        val cat = Cat(
//                            breed.id,
//                            breed.name,
//                            breed.weight.metric,
//                            breed.life_span,
//                            breed.temperament,
//                            "")
//
//                        catList.add(cat)
//                    }
//
//                    setupRecyclerView(catList)
//                }
//
//                override fun onFailure(call: Call<List<Breed>>, t: Throwable) {
//
//                }
//
//            })
//    }

    /*private fun getCats(): List<Cat> {
        val repository = Repository(Api.apiService)
        GlobalScope.launch {
            return repository.getCats2()
        }
    }*/

