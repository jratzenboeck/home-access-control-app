package com.example.homeaccesscontrol

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab: View = findViewById(R.id.floatingActionButton)
        fab.setOnClickListener { view ->
            addPerson(view)
        }
    }

    fun addPerson(view: View) {
        val intent = Intent(this, TakePictureActivity::class.java)
        startActivity(intent)
    }


}
