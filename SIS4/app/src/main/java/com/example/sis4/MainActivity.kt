package com.example.sis4

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sis4.databinding.ActivityMainBinding
import com.example.sis4.network.RetrofitModule
import com.example.sis4.ui.PostAdapter
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val job = SupervisorJob()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    private val adapter = PostAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter

        loadData()
    }

    private fun setLoading(show: Boolean) {
        binding.progress.visibility = if (show) View.VISIBLE else View.GONE
        binding.errorText.visibility = View.GONE
        binding.recycler.visibility = if (show) View.GONE else View.VISIBLE
    }

    private fun showError(msg: String) {
        binding.progress.visibility = View.GONE
        binding.recycler.visibility = View.GONE
        binding.errorText.visibility = View.VISIBLE
        binding.errorText.text = msg
    }

    private fun loadData() {
        setLoading(true)
        uiScope.launch {
            try {
                val posts = withContext(Dispatchers.IO) {
                    RetrofitModule.api.getPosts()
                }
                setLoading(false)
                adapter.submit(posts)
            } catch (e: Exception) {
                showError("Network error: ${e.localizedMessage ?: e.javaClass.simpleName}")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}
