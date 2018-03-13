package com.example.anaworld.echo.Activities

import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.example.anaworld.echo.Activities.MainActivity.statified.drlay
import com.example.anaworld.echo.Adapters.NavigationDrawerAdapter
import com.example.anaworld.echo.Fragments.MainScreenFragment
import com.example.anaworld.echo.R
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    var navigationDrawerIconList:ArrayList<String> = arrayListOf()

    var images_for_navdrawer = intArrayOf(R.drawable.navigation_allsongs,
            R.drawable.navigation_favorites,
            R.drawable.navigation_settings,
            R.drawable.navigation_aboutus)

    object statified{
        var drlay:DrawerLayout?=null
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolba=findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolba)
        drlay=findViewById(R.id.drawer_layout)

        navigationDrawerIconList.add("All Songs")
        navigationDrawerIconList.add("Favourites")
        navigationDrawerIconList.add("Settings")
        navigationDrawerIconList.add("About Us")

        val toggle = ActionBarDrawerToggle(this@MainActivity, drlay, toolba,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drlay?.setDrawerListener(toggle)
        toggle.syncState()

        val mainscreenfrag= MainScreenFragment()
        this.supportFragmentManager
                .beginTransaction()
                .add(R.id.details_fragment,mainscreenfrag,"MainScreenFragment")
                .commit()

        var _navadapter = NavigationDrawerAdapter(navigationDrawerIconList,images_for_navdrawer,this)
        _navadapter.notifyDataSetChanged()

        var navrecview=findViewById<RecyclerView>(R.id.nav_re_view)
        navrecview.layoutManager=LinearLayoutManager(this)
        navrecview.itemAnimator=DefaultItemAnimator()

        navrecview.adapter = _navadapter
        navrecview.setHasFixedSize(true)
    }

    override fun onStart() {
        super.onStart()
    }

}
