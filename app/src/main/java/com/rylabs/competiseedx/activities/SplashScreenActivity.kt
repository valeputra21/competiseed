package com.rylabs.competiseedx.activities

import android.os.Bundle
import android.os.Handler
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.rylabs.competiseedx.R
import com.rylabs.competiseedx.app.RyRouter

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var router: RyRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        router = RyRouter(this)

        Handler().postDelayed({ router.openActivityAndClearAllPrevious(LoginActivity::class.java) }, 1000)
    }
}