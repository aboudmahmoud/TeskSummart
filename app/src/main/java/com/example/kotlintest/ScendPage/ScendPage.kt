package com.example.kotlintest.ScendPage

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlintest.MainActivity
import com.example.kotlintest.R
import kotlinx.android.synthetic.main.activity_scend_page.*

class ScendPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scend_page)
        var count=intent.getIntExtra("statis",40)
        var mod=intent.getBooleanExtra("mod",true);
        if (mod==true)
        {
            mod=false
            btn.setOnClickListener( View.OnClickListener {
                count++

                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("Count",count)
                    putExtra("mod",mod)
                }

                startActivity(intent)
                finish()
            })

        }
        else{
            btn.isClickable=false;
            btn.setText("Display")
            btn.setOnClickListener( View.OnClickListener {
                finish()
            })

        }

    }


}