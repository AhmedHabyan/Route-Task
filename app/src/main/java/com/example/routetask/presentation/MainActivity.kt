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
import com.example.routetask.presentation.utils.clear
import com.example.routetask.presentation.utils.setVisiblity
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



        initRecyclerView()
        viewModel.getPhotos()
        observeData()




    }

    private fun observeData() {
        lifecycleScope.launch {
            viewModel.uiState.collect {uiState->
                when(uiState){
                    is UiState.Error -> {
                        binding.progressBar.clear()
                        showError(uiState.exception.message)
                    }
                    is UiState.Ideal -> {}
                    is UiState.Loading -> {
                        binding.tvError.clear()
                        binding.progressBar.setVisiblity()
                    }
                    is UiState.Success -> {
                        Log.e("data","yes")
                        binding.progressBar.clear()
                        binding.tvError.clear()
                        photoAdapter.setData(uiState.response)
                    }
                }
            }
        }
    }

    private fun showError(message: String?) {
        binding.tvError.apply {
            text = message
            setVisiblity()
        }
    }

    private fun initRecyclerView() {
        photoAdapter= PhotoAdapter(Photo())
        binding.rvPhotos.apply {
            adapter= photoAdapter
            layoutManager = StaggeredGridLayoutManager(2,RecyclerView.VERTICAL)
        }
    }

}