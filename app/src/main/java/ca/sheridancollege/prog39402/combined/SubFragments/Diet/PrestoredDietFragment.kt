package ca.sheridancollege.prog39402.combined.SubFragments.Diet

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import ca.sheridancollege.prog39402.combined.Fragments.DietFragment
import ca.sheridancollege.prog39402.combined.Fragments.WorkoutFragment
import ca.sheridancollege.prog39402.combined.MainActivity
import ca.sheridancollege.prog39402.combined.R
import com.eu.fragmentstatemanager.StateManager
import sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database.DatabaseP
import sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database.DietEntity
import sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database.ExerciseEntity


class PrestoredDietFragment(var wname:String,var username:String) : Fragment() {
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
    ): View? { val v=inflater.inflate(R.layout.fragment_prestored_diet, container, false)

        var myDB = DatabaseP.getInstance(this.requireActivity())
        var ourList= myDB.LoadedDietDao().getName(workoutname)

        val wName=v.findViewById<TextView>(R.id.titlemeal)
        wName.text=ourList[0].name
        val minures=v.findViewById<TextView>(R.id.cals)
        minures.text=ourList[0].calorieIntake.toString()

        val typeD=v.findViewById<TextView>(R.id.typeOf)
        typeD.text=ourList[0].type
//myDB
        v.findViewById<Button>(R.id.LogMeal).setOnClickListener{
            val journal= DietEntity(i,ourList[0].name,username2,ourList[0].calorieIntake,ourList[0].type)
            myDB.DietDao().insert(journal)
            StateManager.getInstance().showOnNavigationClick(MainActivity.M_ID, DietFragment(wname,username2))
            i++
        }

        // Inflate the layout for this fragment
        return v
    }


}