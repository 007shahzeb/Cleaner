package android.com.activities

import android.com.adapters.DailyAdapter
import android.com.adapters.PreviousJobsAdapter
import android.com.adapters.WeeklyAdapter
import android.com.loginwithsiginfirebase.R
import android.com.models.Time
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.*

class ActivitySchedule : AppCompatActivity() {


    var backArrowImage: ImageView? = null

    var checkDaily: CheckBox? = null
    var recyclerViewDaily: RecyclerView? = null

    var checkWeekly: CheckBox? = null
    var recyclerViewWeekly: RecyclerView? = null

    var checkMonthly: CheckBox? = null
    var recyclerViewMonthly: RecyclerView? = null

    var tvContinueBtn: TextView? = null


    var myList: List<Time>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)


        findingIdsHere()


    }


    override fun onResume() {
        super.onResume()



        performOperationsHere()


    }

    private fun performOperationsHere() {


        checkDaily!!.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {

                checkDaily!!.setTextColor(Color.parseColor("#FF182391"))
                checkMonthly!!.setTextColor(Color.parseColor("#FFFFFF"))
                checkWeekly!!.setTextColor(Color.parseColor("#FFFFFF"))
                recyclerViewDaily!!.visibility = View.VISIBLE
                checkWeekly!!.isChecked = false
                checkMonthly!!.isChecked = false



                callDailyAdapterHere()


            } else {

                recyclerViewDaily!!.visibility = View.GONE
                checkDaily!!.setTextColor(Color.parseColor("#FFFFFF"))
            }


        }



        checkWeekly!!.setOnCheckedChangeListener { buttonView, isChecked ->

            if (isChecked) {

                checkWeekly!!.setTextColor(Color.parseColor("#FF182391"))
                checkDaily!!.setTextColor(Color.parseColor("#FFFFFF"))

                recyclerViewWeekly!!.visibility = View.VISIBLE

                recyclerViewDaily!!.visibility = View.GONE

                checkDaily!!.isChecked = false
                checkMonthly!!.isChecked = false

                callWeeklyAdapterHere()

            } else {

                recyclerViewWeekly!!.visibility = View.GONE
                recyclerViewDaily!!.visibility = View.GONE
                checkDaily!!.setTextColor(Color.parseColor("#FFFFFF"))

            }

        }



        checkMonthly!!.setOnCheckedChangeListener { buttonView, isChecked ->

            if (isChecked) {

                checkMonthly!!.setTextColor(Color.parseColor("#FF182391"))
                checkWeekly!!.setTextColor(Color.parseColor("#FFFFFF"))
                checkDaily!!.setTextColor(Color.parseColor("#FFFFFF"))

                recyclerViewMonthly!!.visibility = View.VISIBLE
                recyclerViewDaily!!.visibility = View.GONE
                recyclerViewWeekly!!.visibility = View.GONE

                checkDaily!!.isChecked = false
                checkWeekly!!.isChecked = false


            } else {

                recyclerViewMonthly!!.visibility = View.GONE
                recyclerViewDaily!!.visibility = View.GONE
                recyclerViewWeekly!!.visibility = View.GONE
                checkMonthly!!.setTextColor(Color.parseColor("#FFFFFF"));

            }


        }


    }


    private fun callWeeklyAdapterHere() {


        myList = ArrayList<Time>()

        (myList!! as ArrayList).add(Time("12:00AM", "Monday"))
        (myList!! as ArrayList).add(Time("1:00PM", "Tuesday"))
        (myList!! as ArrayList).add(Time("2:00PM", "Wednesday"))
        (myList!! as ArrayList).add(Time("3:00PM", "Thursday"))
        (myList!! as ArrayList).add(Time("4:00PM", "Friday"))
        (myList!! as ArrayList).add(Time("5:00PM", "Satarday"))
        (myList!! as ArrayList).add(Time("6:00PM", "Sunday"))


        recyclerViewWeekly!!.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager?
        val adapter = WeeklyAdapter(myList as ArrayList<Time>, this)
        recyclerViewWeekly!!.adapter = adapter


    }

    private fun callDailyAdapterHere() {

        myList = ArrayList<Time>()

        (myList!! as ArrayList).add(Time("10:00AM", ""))
        (myList!! as ArrayList).add(Time("12:00AM", ""))
        (myList!! as ArrayList).add(Time("1:00PM", ""))
        (myList!! as ArrayList).add(Time("2:00PM", ""))
        (myList!! as ArrayList).add(Time("3:00PM", ""))
        (myList!! as ArrayList).add(Time("4:00PM", ""))
        (myList!! as ArrayList).add(Time("5:00PM", ""))


        recyclerViewDaily!!.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager?
        val adapter = DailyAdapter(myList as ArrayList<Time>, this)
        recyclerViewDaily!!.adapter = adapter


    }

    private fun findingIdsHere() {


        checkDaily = findViewById(R.id.checkDaily) as CheckBox
        checkWeekly = findViewById(R.id.checkWeekly) as CheckBox
        checkMonthly = findViewById(R.id.checkMonthly) as CheckBox



        recyclerViewDaily = findViewById(R.id.recyclerViewDaily) as RecyclerView
        recyclerViewWeekly = findViewById(R.id.recyclerViewWeekly) as RecyclerView
        recyclerViewMonthly = findViewById(R.id.recyclerViewMonthly) as RecyclerView


        tvContinueBtn = findViewById(R.id.tvContinueBtn) as TextView



        tvContinueBtn!!.setOnClickListener {

            if (checkMonthly!!.isChecked && !checkDaily!!.isChecked && !checkWeekly!!.isChecked) {

                startActivity(Intent(this, ActivityScheduleMonthly::class.java))

            } else {

                Toast.makeText(this, "Test", Toast.LENGTH_LONG).show()

            }


        }


    }


}