package ca.sheridancollege.prog39402.combined.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ca.sheridancollege.prog39402.combined.MainActivity
import ca.sheridancollege.prog39402.combined.R
import ca.sheridancollege.prog39402.combined.SubFragments.Diet.PrestoredDietFragment
import ca.sheridancollege.prog39402.combined.SubFragments.Workout.PrestoredWorkoutFragment
import com.eu.fragmentstatemanager.StateManager
import sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database.DatabaseP

class DietFragment(var w:String,var user:String) : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {val v=inflater.inflate(R.layout.fragment_diet, container, false)
        var recyclerView: RecyclerView
                recyclerView=v.findViewById(R.id.mealRecycler)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager

        //initData();

        var myDB = DatabaseP.getInstance(this.requireActivity())
        var ourList= myDB.LoadedDietDao().getAll()
        //initData();

        recyclerView.adapter = MealRecyclerViewAdapter(ourList,requireContext(),user)
        //
        return v
    }

    fun test()
    {
        StateManager.getInstance().showOnNavigationClick(MainActivity.prediet, PrestoredDietFragment(w,user))
    }


}