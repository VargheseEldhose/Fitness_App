package ca.sheridancollege.prog39402.combined.Fragments

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


import ca.sheridancollege.prog39402.combined.MainActivity
import ca.sheridancollege.prog39402.combined.R
import sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database.ExerciseEntity
import sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database.LoadedExeEntity

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class WorkoutHistoryRecyclerViewAdapter(val list:List<ExerciseEntity>, private val context: Context, var usr:String) : RecyclerView.Adapter<WorkoutHistoryRecyclerViewAdapter.ViewHolder>()  {
    lateinit var rvHeader:RecyclerView
    lateinit var view2: View
    var testname:String=""
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_item, parent, false)



        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var i=holder.itemView.findViewById<TextView>(R.id.whistory)
        i.text=list[position].Wname

        holder.itemView.setOnClickListener(object : View.OnClickListener{

            override fun onClick(v: View?){
               // val intent = Intent(v!!.context, MainActivity::class.java)
                testname = i.text.toString()
                // intent.putExtra("workout",u)

               // WorkoutFragment(testname,usr).test()
                //  v.context.startActivity(intent)
            }
        })
    }



    // View Holder
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {



    }}
