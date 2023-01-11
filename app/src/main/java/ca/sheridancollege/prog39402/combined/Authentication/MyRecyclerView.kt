package ca.sheridancollege.prog39402.combined.Authentication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import ca.sheridancollege.prog39402.combined.Database.SimpleUser
import ca.sheridancollege.prog39402.combined.Fragments.DashboardFragment
import ca.sheridancollege.prog39402.combined.MainActivity
import ca.sheridancollege.prog39402.combined.R
import ca.sheridancollege.prog39402.combined.showCustomToast

class MyRecyclerView(private val sampleList: List<SimpleUser>): RecyclerView.Adapter <MyRecyclerView.MyViewHolder>(){
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.imageView)
        var textView1 : TextView = itemView.findViewById(R.id.usernameTv)
        var textView2 : TextView = itemView.findViewById(R.id.detailTv)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_user, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = sampleList[position]
        // holder.imageView.setImageResource(currentItem.imageResource)

        holder.textView1.text = currentItem.name
        holder.textView2.text = currentItem.id.toString()
        holder.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?){
                /*val activity = v!!.context as AppCompatActivity
                val dashboardFragment = DashboardFragment()
                activity.supportFragmentManager.beginTransaction().replace(R.id.rec,dashboardFragment).addToBackStack(null).commit()
           */
                val intent = Intent(v!!.context, MainActivity::class.java)

                var u = holder.textView2.text.toString().toInt()
                var user = holder.textView1.text.toString()
                intent.putExtra("id",u)
                intent.putExtra("name",user)
                v.context.startActivity(intent)
            }
        })
        /*
        holder.textView1.setOnClickListener {

        }*/


    }

    override fun getItemCount() = sampleList.size
}