package ca.sheridancollege.prog39402.combined.SubFragments.Workout

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import ca.sheridancollege.prog39402.combined.Fragments.WorkoutFragment
import ca.sheridancollege.prog39402.combined.MainActivity
import ca.sheridancollege.prog39402.combined.R
import com.eu.fragmentstatemanager.StateManager
import sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database.DatabaseP
import sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database.ExerciseEntity

class PrestoredWorkoutFragment(var wname:String,var username:String) : Fragment() {
    var workoutname:String = wname
    var username2:String=username
var i:Long=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v=inflater.inflate(R.layout.fragment_prestored_workout, container, false)

        var myDB = DatabaseP.getInstance(this.requireActivity())
        var ourList= myDB.LoadedExeDao().getName(workoutname)
        val descr=v.findViewById<TextView>(R.id.description)
        descr.text=ourList[0].description
        val wName=v.findViewById<TextView>(R.id.WorkoutName)
        wName.text=ourList[0].name
        val im=v.findViewById<ImageView>(R.id.IM)
       im.setImageResource(ourList[0].image)
        val minures=v.findViewById<TextView>(R.id.time)
        minures.text=ourList[0].minute.toString()
//myDB
        v.findViewById<Button>(R.id.markdone).setOnClickListener{
            val journal=ExerciseEntity(i,ourList[0].name,username2,ourList[0].minute,ourList[0].caloriesburnt)
            myDB.ExerciseDao().insert(journal)
            StateManager.getInstance().showOnNavigationClick(MainActivity.W_ID, WorkoutFragment(wname,username2))
            i++
        }

        // Inflate the layout for this fragment
        return v
    }


}