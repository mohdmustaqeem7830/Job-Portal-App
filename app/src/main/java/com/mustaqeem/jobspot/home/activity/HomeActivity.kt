package com.mustaqeem.jobspot.home.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import androidx.navigation.fragment.NavHostFragment
import com.mustaqeem.jobspot.R
import com.mustaqeem.jobspot.databinding.ActivityHomeBinding

private const val TAG = "HomeActivityTAG"
class HomeActivity : AppCompatActivity() {
    private var _binding: ActivityHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.homeNavHostContainer) as NavHostFragment
        val navController = navHostFragment.navController
        val popMenu = PopupMenu(this, null)
        popMenu.inflate(R.menu.home_menu)
        val menu = popMenu.menu
        binding.bottomHomeNav.setupWithNavController(navController = navController, menu = menu)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}