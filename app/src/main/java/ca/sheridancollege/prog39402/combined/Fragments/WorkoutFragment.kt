package ca.sheridancollege.prog39402.combined.Fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ca.sheridancollege.prog39402.combined.MainActivity
import ca.sheridancollege.prog39402.combined.R
import ca.sheridancollege.prog39402.combined.SubFragments.Diet.PrestoredDietFragment
import ca.sheridancollege.prog39402.combined.SubFragments.Workout.PrestoredWorkoutFragment
import com.eu.fragmentstatemanager.StateManager
import kotlinx.android.synthetic.main.activity_select_user.*
import sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database.DatabaseP


class WorkoutFragment (var w:String,var nameUser:String): Fragment() {
var result:String=nameUser
    var w2:String=w

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResult("requestKey", bundleOf("data" to result))

    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_workout, container, false)
        var recyclerView: RecyclerView
        recyclerView=v.findViewById(R.id.recycler)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager

        var recyclerView2H:RecyclerView
        recyclerView2H=v.findViewById(R.id.bottomR)
        val layoutManager2 = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView2H.setHasFixedSize(false)
        recyclerView2H.layoutManager = layoutManager2


        //initData();

        var myDB = DatabaseP.getInstance(this.requireActivity())
        var ourList= myDB.LoadedExeDao().getAll()
        var ourList2= myDB.ExerciseDao().getName(nameUser)
        //initData();

        recyclerView.adapter = HeaderAdapter(ourList,requireContext(),result)
        recyclerView2H.adapter=WorkoutHistoryRecyclerViewAdapter(ourList2,requireContext(),result)


        return v
    }


    fun test()
    {
        StateManager.getInstance().showOnNavigationClick(MainActivity.prework, PrestoredWorkoutFragment(w,nameUser))
    }


}