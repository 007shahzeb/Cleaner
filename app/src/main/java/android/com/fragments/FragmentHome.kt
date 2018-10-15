package android.com.fragments

import android.app.AlertDialog
import android.app.Fragment
import android.com.activities.ActivityCleanerProfile
import android.com.activities.ActivityPreviousJobs
import android.com.activities.ActivitySchedule
import android.com.loginwithsiginfirebase.R
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast


class FragmentHome : Fragment() {


    var linearBookCleanerbtn: LinearLayout? = null
    var linearRebook: LinearLayout? = null
    var linearCreateAutomaticCleaning: LinearLayout? = null

    var edEnterYourLocation: EditText? = null
    var edTypesServices: EditText? = null
    var edPrice: EditText? = null
    var tvBookCleanerSubmit: TextView? = null

    var alertDialog: AlertDialog? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_fragment1, container, false)


        findingIdsHere(view)


        return view


    }


    private fun findingIdsHere(view: View?) {

        linearBookCleanerbtn = view!!.findViewById(R.id.linearBookCleanerbtn) as LinearLayout
        linearRebook = view.findViewById(R.id.linearRebook) as LinearLayout
        linearCreateAutomaticCleaning = view.findViewById(R.id.linearCreateAutomaticCleaning) as LinearLayout




        linearBookCleanerbtn!!.setOnClickListener {

            bookACleanerDialog(view)

        }


        linearRebook!!.setOnClickListener {

            startActivity(Intent(activity, ActivityPreviousJobs::class.java))


        }


        linearCreateAutomaticCleaning!!.setOnClickListener {

            startActivity(Intent(activity, ActivitySchedule::class.java))


        }


    }

    private fun bookACleanerDialog(view: View) {

        val dialogView = LayoutInflater.from(activity).inflate(R.layout.dialog_book_cleaner, null)

        findingIdsHereForDialog(dialogView)

        val builder = AlertDialog.Builder(activity).setView(dialogView)
        builder.setCancelable(true)
        alertDialog = builder.create()
        alertDialog!!.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        builder.show()
    }

    private fun findingIdsHereForDialog(dialogView: View?) {


        edEnterYourLocation = dialogView!!.findViewById(R.id.edEnterYourLocation) as EditText
        edTypesServices = dialogView.findViewById(R.id.edTypesServices) as EditText
        edPrice = dialogView.findViewById(R.id.edPrice) as EditText

        tvBookCleanerSubmit = dialogView.findViewById(R.id.tvBookCleanerSubmit) as TextView


        tvBookCleanerSubmit!!.setOnClickListener {

            //            if(alertDialog != null && alertDialog!!.isShowing()){
//                alertDialog!!.dismiss();
//            }
            startActivity(Intent(activity, ActivityCleanerProfile::class.java))


        }


    }


}