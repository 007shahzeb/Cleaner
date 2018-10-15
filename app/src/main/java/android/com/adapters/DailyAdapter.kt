package android.com.adapters

import android.com.loginwithsiginfirebase.R
import android.com.models.Time
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DailyAdapter(val items: ArrayList<Time>, val context: Context) : RecyclerView.Adapter<DailyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.daily_adapter_row, parent, false)
        return DailyAdapter.ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.bindItemsHere(items[position])


    }


    override fun getItemCount(): Int {

        return items.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItemsHere(time: Time) {


            var tvDaily: TextView? = null

            tvDaily = itemView.findViewById(R.id.tvDaily) as TextView

            tvDaily.text = time.time


        }

    }


}