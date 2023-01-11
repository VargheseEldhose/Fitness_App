package ca.sheridancollege.prog39402.combined.Authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ca.sheridancollege.prog39402.combined.R
import ca.sheridancollege.prog39402.combined.showCustomToast
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import kotlinx.android.synthetic.main.list_user.view.*
import sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database.DatabaseP

class SelectUser : AppCompatActivity() {
    //private lateinit var myDB: DatabaseP
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_user)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
       var myDB = DatabaseP.getInstance(applicationContext)
        val ourList= myDB.SimpleDao().getAll()

        var recycleView = findViewById<RecyclerView>(R.id.recycleView)
        recycleView.adapter = MyRecyclerView(ourList)
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.setHasFixedSize(true)


        }



    // enable the top back button
    override fun onSupportNavigateUp() : Boolean {
        onBackPressed()
        return true
    }


}