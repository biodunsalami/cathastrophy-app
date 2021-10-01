package com.biodun.cathastrophy.api

import android.util.Log
import com.biodun.cathastrophy.Cat
import com.biodun.cathastrophy.api.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository (private val apiService: ApiService) {

    val catList = ArrayList<Cat>()

    suspend fun getCats(): ArrayList<Cat> {
        val breedList = apiService.getBreeds("2369e404-2c44-4417-aefe-af4404c20f60")
        val catList = ArrayList<Cat>()

        for (breed in breedList) {
//            val image = apiService.getBreedImage(breed.reference_image_id);
            val cat = Cat(
                breed.id,
                breed.name,
                breed.weight.metric,
                breed.life_span,
                breed.temperament,
                "")

            catList.add(cat)

        }
        return catList
    }

//    fun getCats2(): ArrayList<Cat> {
//        apiService.getBreeds2("2369e404-2c44-4417-aefe-af4404c20f60")
//            .enqueue(object: Callback<List<Breed>> {
//                override fun onResponse(call: Call<List<Breed>>, breedList: Response<List<Breed>>) {
//                    if(catList.isNotEmpty())
//                        catList.clear()
//
////                    Log.e("BREED TAG", breedList.body().toString())
//                    for (breed in breedList.body()!!) {
////            val image = apiService.getBreedImage(breed.reference_image_id);
//                        val cat = Cat(
//                            breed.id,
//                            breed.name,
//                            breed.weight.metric,
//                            breed.life_span,
//                            breed.temperament,
//                            "")
//
//                        catList.add(cat)
//
//                    }
//                }
//
//                override fun onFailure(call: Call<List<Breed>>, t: Throwable) {
//
//                }
//
//            })
//        Log.e("CATLIST TAG", catList.toString())
//
//        return catList
//    }
//    fun getCats3(): Call<List<Breed>> {
//        return apiService.getBreeds2("2369e404-2c44-4417-aefe-af4404c20f60")
////        Log.e("CATLIST TAG", catList.toString())
//
////        return catList
//    }
}


//breed.reference_image_id
