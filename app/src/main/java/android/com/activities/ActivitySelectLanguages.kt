package android.com.activities

import android.com.loginwithsiginfirebase.R
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button

class ActivitySelectLanguages : AppCompatActivity(), View.OnClickListener {


    var btnEnglish: Button? = null
    var btnSpanish: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_languages)


        findingIdsHere()
        eventListener()


    }

    private fun eventListener() {

        btnEnglish?.setOnClickListener(this)
        btnSpanish?.setOnClickListener(this)

    }

    private fun findingIdsHere() {

        btnEnglish = findViewById(R.id.btnEnglish) as Button
        btnSpanish = findViewById(R.id.btnSpanish) as Button

    }

    override fun onClick(v: View?) {

        when (v?.id) {

            R.id.btnEnglish -> {

                startActivity(Intent(this, ActivityMain::class.java))


            }

            R.id.btnSpanish -> {

                startActivity(Intent(this, ActivityMain::class.java))


            }


        }


    }


}