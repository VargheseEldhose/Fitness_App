package ca.sheridancollege.prog39402.combined.Fragments

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ca.sheridancollege.prog39402.combined.MainActivity
import ca.sheridancollege.prog39402.combined.R
import sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database.LoadedExeEntity

class HeaderAdapter(val list:List<LoadedExeEntity>,private val context: Context,var usr:String) : RecyclerView.Adapter<HeaderAdapter.ViewHolder>()  {
lateinit var rvHeader:RecyclerView
lateinit var view2:View
var testname:String=""
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_header_item, parent, false)



        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var i=holder.itemView.findViewById<TextView>(R.id.w)
        i.text=list[position].name
        var im=holder.itemView.findViewById<ImageView>(R.id.testIm)
        im.setImageResource(list[position].image)
        holder.itemView.setOnClickListener(object : View.OnClickListener{

            override fun onClick(v: View?){
                val intent = Intent(v!!.context, MainActivity::class.java)
                testname = i.text.toString()
               // intent.putExtra("workout",u)

               WorkoutFragment(testname,usr).test()
              //  v.context.startActivity(intent)
            }
        })
    }



    // View Holder
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {



}}
