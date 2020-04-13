package io.github.orbitalno11.epoxy_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.orbitalno11.epoxy_example.epoxy.Controller
import io.github.orbitalno11.epoxy_example.models.Banner
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
    }

    private fun setupRecyclerView(){
        val controller = Controller().apply {
            megaBanner = getMegaBanner()
            horizontalBanners = getHorizontalBanners()
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(false)
        recyclerView.setController(controller)
    }

    private fun getMegaBanner() = Banner("banner1", "https://images.pexels.com/photos/1560424/pexels-photo-1560424.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&w=800")

    private fun getHorizontalBanners() = listOf(
        Banner("banner2", "https://images.pexels.com/photos/1404819/pexels-photo-1404819.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"),
        Banner("banner3", "https://images.pexels.com/photos/1492219/pexels-photo-1492219.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"),
        Banner("banner4", "https://images.pexels.com/photos/1460124/pexels-photo-1460124.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"),
        Banner("banner5", "https://images.pexels.com/photos/1440406/pexels-photo-1440406.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"),
        Banner("banner6", "https://images.pexels.com/photos/1560424/pexels-photo-1560424.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280")
    )
}
