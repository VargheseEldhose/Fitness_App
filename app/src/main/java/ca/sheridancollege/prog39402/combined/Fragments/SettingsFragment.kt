package ca.sheridancollege.prog39402.combined.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import ca.sheridancollege.prog39402.combined.MainActivity
import ca.sheridancollege.prog39402.combined.R
import com.eu.fragmentstatemanager.StateManager
import sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database.DatabaseP
import sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database.UserEntity

class SettingsFragment(user:String) : Fragment() {

    private lateinit var v:View
    private lateinit var calorie: TextView
    private lateinit var height: TextView
    private lateinit var weight: TextView
    private lateinit var age: TextView
    private lateinit var gender: TextView
    private lateinit var username: TextView
    val usernameI=user
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_settings, container, false)
        calorie = v.findViewById(R.id.calorie)
        weight = v.findViewById(R.id.weight)
        height = v.findViewById(R.id.height)
        gender = v.findViewById(R.id.gender)
        age = v.findViewById(R.id.age)
        username = v.findViewById(R.id.username)
        username.text=usernameI.toString()
        val b = v.findViewById<Button>(R.id.saveD)
        b.setOnClickListener {
            InsertToDatabase()}
        //Initialise a new user
        // Initialize a new student with some random data

        return v
    }

    fun InsertToDatabase()
    {
        //code for null input but not working
        Log.d("hah",calorie.text.toString())
        if(calorie.text.toString()==null)
              calorie.text="100"

        if(age.text.toString()=="")
            age.text="18"
        if(height.text.toString()=="")
            height.text="183"
        if(weight.text.toString()=="")
            weight.text="48"
// you did not pass parameters check the userentity class
        val student = UserEntity(
            0, Dailycalorie = calorie.text.toString().toInt(), age = age.text.toString().toInt(), weight = weight.text.toString().toDouble(),
            WorkoutJournal = "na", DietJournal = "na", height = height.text.toString().toInt(), username = username.text.toString()
        )
        val myDB = DatabaseP.getInstance(this.requireActivity())
        myDB.UserDao().insert(student)

        StateManager.getInstance().showOnNavigationClick(MainActivity.D_ID, DashboardFragment(usernameI))
    }


}