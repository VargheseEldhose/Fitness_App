package ca.sheridancollege.prog39402.combined.Authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import ca.sheridancollege.prog39402.combined.Database.SimpleUser
import ca.sheridancollege.prog39402.combined.MainActivity
import ca.sheridancollege.prog39402.combined.R
import sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database.DatabaseP

class CreateUser : AppCompatActivity() {
    private lateinit var myDB:DatabaseP
    private lateinit var createBtn : Button
    private lateinit var newUserEt : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        myDB = DatabaseP.getInstance(applicationContext)

        createBtn = findViewById(R.id.createBtn)
        newUserEt = findViewById(R.id.newUserText)



        createBtn.setOnClickListener {
        //Initialise a new user
        // Initialize a new student with some random data
            val user = newUserEt.text.toString()
            val student = SimpleUser(
                0, name = user
            )
            myDB.SimpleDao().insert(student)

            val i = Intent(this, MainActivity::class.java)
            val key = "type"
            var u = 1
            i.putExtra("type",u)
            intent.putExtra("id",u)
            i.putExtra("name",user)
            startActivity(i)




        }
    }
    // enable the top back button
    override fun onSupportNavigateUp() : Boolean {
        onBackPressed()
        return true
    }

}