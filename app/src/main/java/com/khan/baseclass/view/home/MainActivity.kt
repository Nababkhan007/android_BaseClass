package com.khan.baseclass.view.home

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.khan.baseclass.R
import com.khan.baseclass.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private var doubleBackToExitPressedOnce: Boolean = false
    private val delayTime: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingInit()

        bottomNavInit()
    }

    private fun bottomNavInit() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_profile,
                R.id.navigation_settings
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNavigation.setupWithNavController(navController)
    }

    private fun bindingInit() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun onBackPressed() {
        if (binding.bottomNavigation.selectedItemId == R.id.navigation_home) {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed()
                return

            } else {
                this.doubleBackToExitPressedOnce = true
                Toast.makeText(this, getString(R.string.exit_app), Toast.LENGTH_SHORT).show()
                Handler().postDelayed({ doubleBackToExitPressedOnce = false }, delayTime)
            }

        } else {
            navController.navigateUp()
        }
    }
}