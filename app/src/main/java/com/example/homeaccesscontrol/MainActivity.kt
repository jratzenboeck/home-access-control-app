package com.example.homeaccesscontrol

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fab: View = findViewById(R.id.floatingActionButton)
        fab.setOnClickListener { view ->
            addPerson(view)
        }
        val response = intent.getStringExtra("response")

        if (response == "successCreateUser") {
            setSnackBar(fab, "User was created successfully");
        } else if (response == "failureCreateUser") {
            setSnackBar(fab, "User could not be created");
        }
    }

    fun addPerson(view: View) {
        val intent = Intent(this, TakePictureActivity::class.java)
        startActivity(intent)
    }

    fun setSnackBar(root: View, snackTitle: String) {
        val snackbar = Snackbar.make(root, snackTitle, Snackbar.LENGTH_SHORT)
        snackbar.show()
        val view = snackbar.view
        snackbar.view.setBackgroundColor(Color.parseColor("#2bff00"))
        val txtv = view.findViewById(R.id.snackbar_text) as TextView
        txtv.setTextColor(Color.parseColor("#000000"))
        txtv.gravity = Gravity.CENTER_HORIZONTAL
    }


}
