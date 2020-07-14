package com.kun.androidtestdemo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife

class HomeActivity : AppCompatActivity() {

    @BindView(R.id.btn_logout)
    lateinit var btnLogout: Button

    @BindView(R.id.txt_login_notify)
    lateinit var txtLoginNotify: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        ButterKnife.bind(this)

        btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setMessage("Are you sure to logout?")
                .setPositiveButton("OK") { dialog, which ->
                    finish()
                }
                .setNegativeButton("CANCEL") { dialog, which ->
                    dialog.dismiss()
                }
                .show()
        }
    }
}