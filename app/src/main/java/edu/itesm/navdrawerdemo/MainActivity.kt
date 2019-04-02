package edu.itesm.navdrawerdemo

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    America.OnFragmentInteractionListener, BlackWidow.OnFragmentInteractionListener,
    Hawkeye.OnFragmentInteractionListener, Hulk.OnFragmentInteractionListener,
    IronMan.OnFragmentInteractionListener, Thor.OnFragmentInteractionListener{

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        var fragment: Fragment? = null
        var selectedFragment: Boolean? = false
        when (item.itemId) {
            R.id.america -> {
                // Handle the camera action
                fragment = America()
                selectedFragment = true
            }
            R.id.black_widow -> {
                fragment = BlackWidow()
                selectedFragment = true
            }
            R.id.hawkeye -> {
                fragment = Hawkeye()
                selectedFragment = true
            }
            R.id.hulk -> {
                fragment = Hulk()
                selectedFragment = true
            }
            R.id.iron_man -> {
                fragment = IronMan()
                selectedFragment = true
            }
            R.id.thor -> {
                fragment = Thor()
                selectedFragment = true
            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        if (selectedFragment!!) {
            supportFragmentManager.beginTransaction().replace(R.id.Container, fragment!!).commit()
        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
