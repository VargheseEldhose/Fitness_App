package ca.sheridancollege.prog39402.combined

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import ca.sheridancollege.prog39402.combined.Fragments.*
import com.eu.fragmentstatemanager.StateManager
import com.eu.fragmentstatemanager.StateManagerBuilder
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch
import sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database.DatabaseP
import sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database.LoadedDietEntity
import sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database.LoadedExeEntity

class MainActivity : AppCompatActivity() {
     // var intent= Intent(v!!.context, MainActivity::class.java)
    //  val ver= intent.getStringExtra("user")

    private lateinit var fragments: FrameLayout
    companion object {
        const val D_ID = 123123
        const val W_ID = 213213
        const val S_ID = 321321
        const val M_ID=12000
        const val prework=99909
        const val prediet=1000
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val intent = getIntent()
        var user=intent.getStringExtra("name")

        if(user==null)
            user="k"

        startService(Intent(applicationContext, Background::class.java))

        fragments = findViewById(R.id.fl_wrapper)

        StateManager.buildInstance(
            StateManagerBuilder(D_ID, W_ID, S_ID,M_ID, prediet, prework)
                .withSupportFragmentManager(supportFragmentManager)
                .withViewGroup(fragments)
        ).showOnNavigationClick(S_ID, SettingsFragment(user))


        var myDB = DatabaseP.getInstance(applicationContext)
        //Adding pre loaded exercises
        val pWorkout =
            LoadedExeEntity(0, name = "Push Up", image = R.drawable.sport_1685977__340, minute = 5, caloriesburnt = 200, distance = 0.0,
                description = "Push Ups are great for building health withut use of any equipment")
        val pWorkout2 = LoadedExeEntity(
            1,
            name = "Bench Press",
            image = R.drawable._07_4075849_bench_press_bench_press_png,
            minute = 8,
            caloriesburnt = 400,
            distance = 0.0,
            description = "Bench press are grest for your chest and possibly the highest weight you will lift with equipment"
        )
        val pWorkout3 = LoadedExeEntity(
            2,
            name = "Skull crush",
            image = R.drawable._018_mh_form_check_ep4_skullcrushers_tx_v5_prores_1543939157,
            minute = 3,
            caloriesburnt = 100,
            distance = 0.0,
            description = "Skull crushers strengthen your triceps with the use of Dumbbells"
        )
        val pWorkout4 = LoadedExeEntity(
            3,
            name = "Treadmill run",
            image = R.drawable._87_2875230_man_on_treadmill_man_on_treadmill_png,
            minute = 10,
            caloriesburnt = 800,
            distance = 5.0,
            description = "Treadmills are great to reduce fat and increase stamina"
        )
        lifecycleScope.launch {  myDB.LoadedExeDao().insert(pWorkout)
            myDB.LoadedExeDao().insert(pWorkout2)
            myDB.LoadedExeDao().insert(pWorkout3)
            myDB.LoadedExeDao().insert(pWorkout4)
        }
        //Adding pre loaded diet
        val PDiet = LoadedDietEntity(0, name = "Eggs", calorieIntake = 100, type = "Veg")
        val PDiet1 = LoadedDietEntity(1, name = "Milk", calorieIntake = 60, type = "Veg")
        val PDiet2 =
            LoadedDietEntity(2, name = "Chicken Breast", calorieIntake = 100, type = "NON-Veg")
        val PDiet3 = LoadedDietEntity(3, name = "Avocados", calorieIntake = 100, type = "Veg")

        //insert of dao is executed
        lifecycleScope.launch{
            myDB.LoadedDietDao().insert(PDiet)
            myDB.LoadedDietDao().insert(PDiet2)
            myDB.LoadedDietDao().insert(PDiet3)
            myDB.LoadedDietDao().insert(PDiet1)}





        //we can use this method to change default loading fragment
        //if the user is a new user we can set it to settings fragment
        //we can set a variable in this activity and the value will be passed from
        //the intent


        Log.d("sjsjs",user)
        val v= intent.getIntExtra("type",0)
        //creating fragments
        val dashboardFrag = DashboardFragment(user)
        val workoutFrag = WorkoutFragment("",user)
        val dietFrag = DietFragment("",user)
        val webFrag = WebFragment()
        val settingsFrag = SettingsFragment(user)
        if(v == 1){
            makeCurrentFragment(settingsFrag)
        }
        else{
            makeCurrentFragment(dashboardFrag)
        }

        //bottom navigation listener
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.ic_dashboard ->StateManager.getInstance().showOnNavigationClick(D_ID,
                   DashboardFragment(user) )
                R.id.ic_run ->  StateManager.getInstance().showOnNavigationClick(W_ID, WorkoutFragment("",user))
                R.id.ic_food -> StateManager.getInstance().showOnNavigationClick(M_ID, DietFragment("",user))
                R.id.ic_browser ->makeCurrentFragment(WebFragment())
                R.id.ic_settings ->StateManager.getInstance().showOnNavigationClick(S_ID, SettingsFragment(user))
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.fl_wrapper,fragment)
            commit()
        }
    }

    // enable the top back button
    override fun onSupportNavigateUp() : Boolean {
        onBackPressed()
        return true
    }
}