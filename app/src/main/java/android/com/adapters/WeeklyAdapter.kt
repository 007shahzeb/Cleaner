package android.com.adapters

import android.com.loginwithsiginfirebase.R
import android.com.models.Time
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class WeeklyAdapter(val item: ArrayList<Time>, val context: Context) : RecyclerView.Adapter<WeeklyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeeklyAdapter.ViewHolder {

        val v = LayoutInflater.from(context).inflate(R.layout.weekly_adapter_row, parent, false)
        return WeeklyAdapter.ViewHolder(v)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindItemHere(item[position])


    }


    override fun getItemCount(): Int {

        return item.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bindItemHere(time: Time) {


            var checkWeekly: TextView? = null
            var tvWeekly: TextView? = null

            checkWeekly = itemView.findViewById(R.id.checkWeekly) as TextView
            tvWeekly = itemView.findViewById(R.id.tvWeekly) as TextView

            checkWeekly!!.text = time.name
            tvWeekly!!.text = time.time


        }

    }


}