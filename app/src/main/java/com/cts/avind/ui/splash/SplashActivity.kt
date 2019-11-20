package com.cts.avind.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.cts.avind.R
import com.cts.avind.ui.main.PostListActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar!!.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.splash_activity)
        showHomeScreen()
    }

    /*
     * Showing splash screen with a timer. On completion of time will show List Screen.
     */
    private fun showHomeScreen() {
        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, PostListActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT.toLong())
    }

    companion object {
        private val SPLASH_TIME_OUT = 2000
    }
}