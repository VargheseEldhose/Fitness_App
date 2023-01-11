package ca.sheridancollege.prog39402.combined.Authentication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import ca.sheridancollege.prog39402.combined.MainActivity
import ca.sheridancollege.prog39402.combined.R
import ca.sheridancollege.prog39402.combined.showCustomToast


class LoginScreen : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        //initial toast when page loads
       // Toast(this).showCustomToast ("Select a User or Create new", this)

        var selectBtn = findViewById<Button>(R.id.selectBtn)
        var createBtn = findViewById<Button>(R.id.createBtn)



        //by clicking on the Login button, the selected username from the spinner will
        //be passed to the next activity and all information from db will be loaded
        selectBtn.setOnClickListener {
            val i = Intent(this, SelectUser::class.java)
            startActivity(i)
        }

        //by clicking on the Create new user button, it will save the new username
        //to the db and pass the name to the next activity as intent
        //where it will store in the db
        createBtn.setOnClickListener {
            val i = Intent(this, CreateUser::class.java)
            //starts the new activity which is the LoginScreen
            startActivity(i)
           // finish()
        }

    }



}