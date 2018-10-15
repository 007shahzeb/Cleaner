package android.com.activities

import android.app.AlertDialog
import android.com.loginwithsiginfirebase.R
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.text.method.ScrollingMovementMethod


class ActivityCleanerProfile : AppCompatActivity() {


    var tvProfileContinue: TextView? = null
    var alertDialog: AlertDialog? = null
    var tvBioScrollable: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cleaners_details)


        findingIdsHere()


    }

    private fun findingIdsHere() {

        tvProfileContinue = findViewById(R.id.tvProfileContinue) as TextView
        tvBioScrollable = findViewById(R.id.tvBioScrollable) as TextView
        tvBioScrollable!!.setMovementMethod(ScrollingMovementMethod())

        tvProfileContinue!!.setOnClickListener {

            personalInfoDialog()

        }

    }


    private fun personalInfoDialog() {


        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_personal_info_cleaner, null)

        findingIdsHereForDialog(dialogView)

        val builder = AlertDialog.Builder(this).setView(dialogView)
        builder.setCancelable(true)
        alertDialog = builder.create()
        alertDialog!!.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        builder.show()


    }

    private fun findingIdsHereForDialog(dialogView: View?) {


    }


}