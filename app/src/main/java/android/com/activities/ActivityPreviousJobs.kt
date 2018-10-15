package android.com.activities

import android.com.adapters.PreviousJobsAdapter
import android.com.loginwithsiginfirebase.R
import android.com.models.User
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_previous_jobs.*

class ActivityPreviousJobs : AppCompatActivity() {

    //https://www.simplifiedcoding.net/kotlin-recyclerview-example/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_previous_jobs)


        val recyclerView = findViewById(R.id.recyclerViewPreviousJobs) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager?

        val users = ArrayList<User>()

        //adding some dummy data to the list
        users.add(User("10/12/2019", "Ranchi Jharkhand"))
        users.add(User("21/21/2121", "Ranchi Jharkhand"))
        users.add(User("32/12/1212", "Ranchi Jharkhand"))
        users.add(User("12/12/1212", "Ranchi Jharkhand"))

        val adapter = PreviousJobsAdapter(users, this)
        recyclerView.adapter = adapter

    }


}