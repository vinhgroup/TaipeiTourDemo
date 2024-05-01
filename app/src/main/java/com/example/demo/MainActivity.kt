package com.example.demo

import android.app.ListFragment
import android.app.ProgressDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.demo.adapter.InforAdapter
import com.example.demo.fragment.ListFragmentX
import com.example.demo.viewmodel.TourViewModel
import com.example.demo.viewmodel.TourViewModelFactory
import com.nguyennk.movieapp.repository.TourRepository
import quicktype.Datum

class MainActivity : AppCompatActivity() {
    private lateinit var tourViewModel: TourViewModel
    private val repository = TourRepository()
    private lateinit var listTour: ArrayList<Datum>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "TaipeiTour"
        var mProgressDialog = ProgressDialog(this)
        mProgressDialog.setTitle("TaipeiTour")
        mProgressDialog.setMessage("Loading")
        mProgressDialog.show()
        tourViewModel =
            ViewModelProvider(this, TourViewModelFactory(repository))[TourViewModel::class.java]
        tourViewModel.loadTour("en")
        tourViewModel.listTour.observe(this, Observer { data ->
            listTour = data.data as ArrayList<Datum>
            Log.d("AAA", "" + listTour)
            var adapter = InforAdapter(listTour, this@MainActivity)
            showList(adapter)

//
            this.runOnUiThread {
                mProgressDialog.dismiss()
            }
        })

    }


    lateinit var parentMenu: MenuItem
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        if (menu != null) {
            parentMenu = menu.findItem(R.id.overflowMenu)
        }
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.zh_cn -> {
                parentMenu.title = "zh_cn"
                tourViewModel.loadTour("zh-cn")
            }

            R.id.zh_tw -> {
                parentMenu.title = "zh_tw"
                tourViewModel.loadTour("zh-tw")
            }

            R.id.en -> {
                parentMenu.title = "en"
                tourViewModel.loadTour("en")
            }

            R.id.ja -> {
                parentMenu.title = "ja"
                tourViewModel.loadTour("ja")
            }

            R.id.ko -> {
                parentMenu.title = "ko"
                tourViewModel.loadTour("ko")
            }

            R.id.es -> {
                parentMenu.title = "es"
                tourViewModel.loadTour("es")
            }

            R.id.id -> {
                parentMenu.title = "id"
                tourViewModel.loadTour("id")
            }

            R.id.th -> {
                parentMenu.title = "th"
                tourViewModel.loadTour("th")
            }

            R.id.vi -> {
                parentMenu.title = "vi"
                tourViewModel.loadTour("vi")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    //    private fun loadFragment(fragment: Fragment){
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.body, fragment)
//        transaction.disallowAddToBackStack()
//        transaction.commit()
//    }
//
    fun showList(adapter: InforAdapter) {
        val bottomFragment = supportFragmentManager.findFragmentById(R.id.body) as ListFragmentX
        bottomFragment.showRecycleView(adapter)
    }
}