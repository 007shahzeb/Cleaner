package android.com.activities

import android.com.loginwithsiginfirebase.R
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomSheetDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView

class ActivityMain : AppCompatActivity(), View.OnClickListener {


    var btnLogin: Button? = null
    var btnRegister: Button? = null
    var tvAboutUs: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findingIdsHere()
        eventListener()


    }

    private fun eventListener() {

        btnLogin?.setOnClickListener(this)
        btnRegister?.setOnClickListener(this)
        tvAboutUs?.setOnClickListener(this)
    }

    private fun findingIdsHere() {

        btnLogin = findViewById(R.id.btnLogin) as Button
        btnRegister = findViewById(R.id.btnRegister) as Button

        tvAboutUs = findViewById(R.id.tvAboutUs) as TextView

    }


    override fun onClick(v: View?) {


        when (v?.id) {

            R.id.btnLogin -> {


                startActivity(Intent(this, ActivitySiginIn::class.java))

            }

            R.id.btnRegister -> {
                startActivity(Intent(this, ActivitySignUp::class.java))

            }

            R.id.tvAboutUs -> {


                bottomSheetDialog()


            }


        }


    }

    private fun bottomSheetDialog() {

        val dialog = BottomSheetDialog(this)
        val bottomSheet = layoutInflater.inflate(R.layout.bottom_sheet, null)

//        bottomSheet.buttonSubmit.setOnClickListener { dialog.dismiss() }

        dialog.setContentView(bottomSheet)
        dialog.show()


    }

}