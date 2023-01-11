package ca.sheridancollege.prog39402.combined.ToastSplash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import ca.sheridancollege.prog39402.combined.Authentication.LoginScreen
import ca.sheridancollege.prog39402.combined.R

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

       Handler().postDelayed({
            val i = Intent(this@SplashScreen, LoginScreen::class.java)
            //starts the new activity which is the LoginScreen
            startActivity(i)
            //ends this splash screen activity removes from the backstack as well
            finish()
        },3000)

    }
}