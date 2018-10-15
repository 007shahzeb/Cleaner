package android.com.adapters

import android.com.loginwithsiginfirebase.R
import android.com.models.User
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView


class PreviousJobsAdapter(val items: ArrayList<User>, val context: Context) : RecyclerView.Adapter<PreviousJobsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreviousJobsAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_previous_jobs, parent, false)
        return ViewHolder(v)
    }


    override fun onBindViewHolder(holder: PreviousJobsAdapter.ViewHolder, position: Int) {

        holder.bindItems(items[position])
        holder.ratingBar.rating = 3.67f


    }


    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val ratingBar = itemView.findViewById(R.id.ratingBar) as RatingBar

        fun bindItems(user: User) {

            val in_date = itemView.findViewById(R.id.in_date) as TextView
//            val textViewAddress  = itemView.findViewById(R.id.textViewAddress) as TextView
            in_date.text = user.name
//            textViewAddress.text = user.address


        }


    }


}