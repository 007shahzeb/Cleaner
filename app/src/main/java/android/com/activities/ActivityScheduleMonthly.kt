package android.com.activities

import android.com.adapters.MonthlyAdapter
import android.com.loginwithsiginfirebase.R
import android.com.models.Time
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class ActivityScheduleMonthly : AppCompatActivity() {


    var backArrowImage: ImageView? = null
    var tvContinueBtn: TextView? = null
    var recylerViewMonthly: RecyclerView? = null

    var myList: List<Time>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_monthly)


        findingIdsHere()

        callMonthlyAdapterHere()


    }

    private fun callMonthlyAdapterHere() {


        myList = ArrayList<Time>()

        (myList!! as ArrayList).add(Time("1", "Monday"))
        (myList!! as ArrayList).add(Time("2", "Tuesday"))
        (myList!! as ArrayList).add(Time("3", "Wednesday"))
        (myList!! as ArrayList).add(Time("4", "Thursday"))
        (myList!! as ArrayList).add(Time("5", "Friday"))
        (myList!! as ArrayList).add(Time("6", "Satarday"))
        (myList!! as ArrayList).add(Time("7", "Sunday"))
        (myList!! as ArrayList).add(Time("8", "Sunday"))
        (myList!! as ArrayList).add(Time("9", "Sunday"))
        (myList!! as ArrayList).add(Time("10", "Sunday"))
        (myList!! as ArrayList).add(Time("11", "Sunday"))
        (myList!! as ArrayList).add(Time("12", "Sunday"))
        (myList!! as ArrayList).add(Time("13", "Sunday"))
        (myList!! as ArrayList).add(Time("14", "Sunday"))
        (myList!! as ArrayList).add(Time("15", "Sunday"))
        (myList!! as ArrayList).add(Time("16", "Sunday"))
        (myList!! as ArrayList).add(Time("17", "Sunday"))
        (myList!! as ArrayList).add(Time("18", "Sunday"))
        (myList!! as ArrayList).add(Time("19", "Sunday"))
        (myList!! as ArrayList).add(Time("20", "Sunday"))
        (myList!! as ArrayList).add(Time("21", "Sunday"))
        (myList!! as ArrayList).add(Time("22", "Sunday"))
        (myList!! as ArrayList).add(Time("23", "Sunday"))
        (myList!! as ArrayList).add(Time("24", "Sunday"))
        (myList!! as ArrayList).add(Time("25", "Sunday"))
        (myList!! as ArrayList).add(Time("26", "Sunday"))
        (myList!! as ArrayList).add(Time("27", "Sunday"))
        (myList!! as ArrayList).add(Time("28", "Sunday"))
        (myList!! as ArrayList).add(Time("29", "Sunday"))
        (myList!! as ArrayList).add(Time("30", "Sunday"))


        recylerViewMonthly!!.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager?
        val adapter = MonthlyAdapter(myList as ArrayList<Time>, this)
        recylerViewMonthly!!.adapter = adapter


    }

    private fun findingIdsHere() {

        backArrowImage = findViewById(R.id.backArrowImage) as ImageView
        tvContinueBtn = findViewById(R.id.tvContinueBtn) as TextView

        recylerViewMonthly = findViewById(R.id.recylerViewMonthly) as RecyclerView


    }


}