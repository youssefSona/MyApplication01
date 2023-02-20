package com.example.myapplication01

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.myapplication01.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //viewBinding
//        b = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        //find NavController
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.myNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        //link NavController to the ActionBar
        NavigationUI.setupActionBarWithNavController(this, navController)

        //adding menu
        addMenuProvider(object : MenuProvider {
            override fun onPrepareMenu(menu: Menu) {
                super.onPrepareMenu(menu)
            }

            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.overflow_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return NavigationUI.onNavDestinationSelected(
                    menuItem, navController
                )
            }
        }) // end of menu

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }
}


//// function to change the current fragment
//private fun changeFragment(move: String) {
//
//    // getting current fragment
//    val currentFragment =
//        supportFragmentManager.findFragmentById(R.id.mainFragmentLayout)
//
//    // view next fragment
//    supportFragmentManager.beginTransaction().apply {
//        for (f in fragments!!.indices) {
//            if (fragments!![f] == currentFragment) {
//
//                //check if there is next or previous fragment
//                try {
//                    if (move == "next") {
//                        replace(R.id.mainFragmentLayout, fragments!![f + 1])
//
//                        // enable going back to the previous fragment
//                        addToBackStack(null) // "null" is name for this back stack
//                    } else if (move == "previous") {
//                        replace(R.id.mainFragmentLayout, fragments!![f - 1])
//                    }//end of nested if
//                    commit()
//                } catch (e: Exception) {  //reporting no next or previous
//                    Toast.makeText(
//                        applicationContext,
//                        "No $move fragment!",
//                        Toast.LENGTH_LONG
//                    ).show()
//                }// end of catch
//            }// end of if statement
//        }// end of for loop
//    }//end of Transaction
//}//end of changeFragment function