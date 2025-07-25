package com.example.routetask.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.routetask.R
import com.example.routetask.databinding.ActivityMainBinding
import com.example.routetask.domain.model.Photo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var photoAdapter:PhotoAdapter
    val viewModel:ActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        viewModel.getPhotos()
        initRecyclerView()

        observeData()




    }

    private fun observeData() {
        lifecycleScope.launch {
            viewModel.uiState.collect {uiState->
                when(uiState){
                    is UiState.Error -> {}
                    is UiState.Ideal -> {}
                    is UiState.Loading -> {}
                    is UiState.Success -> {
                        Log.e("data","yes")
                        photoAdapter.setData(uiState.response)
                    }
                }
            }
        }
    }

    private fun initRecyclerView() {
        photoAdapter= PhotoAdapter(Photo())
        binding.rvPhotos.apply {
            adapter= photoAdapter
            layoutManager = StaggeredGridLayoutManager(2,RecyclerView.VERTICAL)
        }
    }

//    private fun DummyList() {
//        val dummyPhotos= listOf(
//            Photo(
//                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfcRXsjaUmeLIrOhYPPbsgKOIBMtQo2SQt8A&s"
//            ),
//            Photo(
//                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfcRXsjaUmeLIrOhYPPbsgKOIBMtQo2SQt8A&s"
//            ),
//            Photo(
//                "https://images.pexels.com/photos/33147349/pexels-photo-33147349.jpeg"
//            ),
//            Photo(
//                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfcRXsjaUmeLIrOhYPPbsgKOIBMtQo2SQt8A&s"
//            ),
//            Photo(
//                "https://images.pexels.com/photos/33147349/pexels-photo-33147349.jpeg"
//            ),
//            Photo(
//                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfcRXsjaUmeLIrOhYPPbsgKOIBMtQo2SQt8A&s"
//            ),
//            Photo(
//                "https://images.pexels.com/photos/33147349/pexels-photo-33147349.jpeg"
//            ),
//            Photo(
//                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfcRXsjaUmeLIrOhYPPbsgKOIBMtQo2SQt8A&s"
//            ),
//            Photo(
//                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfcRXsjaUmeLIrOhYPPbsgKOIBMtQo2SQt8A&s"
//            ),
//            Photo(
//                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfcRXsjaUmeLIrOhYPPbsgKOIBMtQo2SQt8A&s"
//            ),
//            Photo(
//                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfcRXsjaUmeLIrOhYPPbsgKOIBMtQo2SQt8A&s"
//            ),
//            Photo(
//                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfcRXsjaUmeLIrOhYPPbsgKOIBMtQo2SQt8A&s"
//            ),
//            Photo(
//                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfcRXsjaUmeLIrOhYPPbsgKOIBMtQo2SQt8A&s"
//            ),
//            Photo(
//                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfcRXsjaUmeLIrOhYPPbsgKOIBMtQo2SQt8A&s"
//            ),
//            Photo(
//                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfcRXsjaUmeLIrOhYPPbsgKOIBMtQo2SQt8A&s"
//            ),
//            Photo(
//                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfcRXsjaUmeLIrOhYPPbsgKOIBMtQo2SQt8A&s"
//            ),
//            Photo(
//                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfcRXsjaUmeLIrOhYPPbsgKOIBMtQo2SQt8A&s"
//            ),
//            Photo(
//                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfcRXsjaUmeLIrOhYPPbsgKOIBMtQo2SQt8A&s"
//            ),
//            Photo(
//                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfcRXsjaUmeLIrOhYPPbsgKOIBMtQo2SQt8A&s"
//            ),
//            Photo(
//                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfcRXsjaUmeLIrOhYPPbsgKOIBMtQo2SQt8A&s"
//            ),
//            Photo(
//                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfcRXsjaUmeLIrOhYPPbsgKOIBMtQo2SQt8A&s"
//            ),
//            Photo(
//                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfcRXsjaUmeLIrOhYPPbsgKOIBMtQo2SQt8A&s"
//            ),
//            Photo(
//                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfcRXsjaUmeLIrOhYPPbsgKOIBMtQo2SQt8A&s"
//            ),
//
//
//
//
//            )
//        photos = dummyPhotos.toMutableList()
//
//    }
}