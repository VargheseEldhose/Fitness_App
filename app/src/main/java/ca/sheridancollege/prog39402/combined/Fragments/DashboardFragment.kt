package ca.sheridancollege.prog39402.combined.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ca.sheridancollege.prog39402.combined.Database.SimpleUser
import ca.sheridancollege.prog39402.combined.MainActivity
import ca.sheridancollege.prog39402.combined.R
import org.w3c.dom.Text
import sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database.DatabaseP
import sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database.DietEntity
import sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database.ExerciseEntity
import sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database.UserEntity

class DashboardFragment(user: String) : Fragment() {

    private lateinit var v:View
    val userName=user
var sumCal:Int=0
    private lateinit var ourList:List<UserEntity>
    private lateinit var ourList2:List<DietEntity>
    private lateinit var ourList3:List<ExerciseEntity>
    private lateinit var myDB: DatabaseP
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         myDB = DatabaseP.getInstance(this.requireActivity())
        ourList= myDB.UserDao().getAll(userName)
        ourList2=myDB.DietDao().getName(userName)
        ourList3=myDB.ExerciseDao().getName(userName)
     //  var intent= Intent(v!!.context, MainActivity::class.java)
      //  val ver= intent.getStringExtra("user")


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        v=inflater.inflate(R.layout.fragment_dashboard, container, false)
        val i= v.findViewById<TextView>(R.id.targetCalories)
        val u=v.findViewById<TextView>(R.id.usernameDis)
        i.text=ourList[0].Dailycalorie.toString()
        u.text="Hello  "+ userName
        for(i in ourList2)
        {
            sumCal += i.caloriesConsumed
        }
        for(i in ourList3)
        {
            sumCal-=i.calorie
        }
        val con=v.findViewById<TextView>(R.id.Consumed)
        con.text=sumCal.toString()

        val rem=v.findViewById<TextView>(R.id.CalorieLeft)
        rem.text=(ourList[0].Dailycalorie-sumCal).toString()



        // Inflate the layout for this fragment
        return v
    }

}