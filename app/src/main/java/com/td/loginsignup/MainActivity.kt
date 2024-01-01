package com.td.loginsignup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.mvvmtutorial.ui.home.HomeActivity
import com.td.loginsignup.data.UserPreferences
import com.td.loginsignup.ui.auth.AuthActivity
import com.td.loginsignup.ui.startNewActivity
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userPreferences = UserPreferences(this)
        Log.d("Sample", "Loading Auth Token")

        lifecycleScope.launch {
            val authToken = userPreferences.getAuthToken();
            val activity = if(authToken == null) AuthActivity::class.java else HomeActivity::class.java
            startNewActivity(activity)
        }
    }

}