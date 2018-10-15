package android.com.activities

import android.com.loginwithsiginfirebase.R
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class ActivitySplash : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splashTiming()
    }

    private fun splashTiming() {

        Handler().postDelayed(


                {
                    val mainIntent = Intent(this, ActivitySelectLanguages::class.java)
                    startActivity(mainIntent)
                    finish()

                }, 3000)

    }
}