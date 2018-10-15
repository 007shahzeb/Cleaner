package android.com.adapters

import android.com.loginwithsiginfirebase.R
import android.com.models.Time
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView

class MonthlyAdapter(val items: ArrayList<Time>, val context: Context) : RecyclerView.Adapter<MonthlyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthlyAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.monthly_adapter_row, parent, false)
        return MonthlyAdapter.ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.bindItemsHere(items[position])


    }


    override fun getItemCount(): Int {

        return items.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItemsHere(time: Time) {


            var tvMonthly: TextView? = null
            var checkMonthly: CheckBox? = null

            tvMonthly = itemView.findViewById(R.id.tvMonthly) as TextView
            checkMonthly = itemView.findViewById(R.id.checkMonthly) as CheckBox

            tvMonthly.text = time.name
            checkMonthly.text = time.time


        }

    }


}