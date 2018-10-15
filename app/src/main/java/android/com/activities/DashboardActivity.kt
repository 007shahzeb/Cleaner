package android.com.activities

import android.com.fragments.FragmentHome
import android.com.fragments.Fragment2
import android.com.loginwithsiginfirebase.R
import android.com.utils.replaceFragmenty
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem


class DashboardActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    var drawerLayout: DrawerLayout? = null
    val content: View? = null
    var nav_view: NavigationView? = null
    var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        homeFragmentWillLoadhere()
        findingIdsHere()
        eventListener()

        setSupportActionBar(toolbar)

        toggleSync()


    }

    private fun toggleSync() {

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout?.addDrawerListener(toggle)
        toggle.syncState()

    }

    private fun eventListener() {

        nav_view?.setNavigationItemSelectedListener(this)

    }

    private fun homeFragmentWillLoadhere() {

        replaceFragmenty(fragment = FragmentHome(), allowStateLoss = true, containerViewId = R.id.mainContent)
        setTitle("Import")

    }


    private fun findingIdsHere() {

        drawerLayout = findViewById(R.id.drawer_layout) as DrawerLayout
        toolbar = findViewById(R.id.toolbar) as Toolbar
        nav_view = findViewById(R.id.nav_view) as NavigationView

    }

    override fun onBackPressed() {

        if (drawerLayout!!.isDrawerOpen(GravityCompat.START)) {
            drawerLayout!!.closeDrawer(GravityCompat.START)
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

        when (item.itemId) {

            R.id.nav_camera -> {

                replaceFragmenty(fragment = FragmentHome(), allowStateLoss = true, containerViewId = R.id.mainContent)
                setTitle("Import")
            }


            R.id.nav_gallery -> {

                replaceFragmenty(fragment = Fragment2(), allowStateLoss = true, containerViewId = R.id.mainContent)
                setTitle("Gallery")
            }


        }

        drawerLayout!!.closeDrawer(GravityCompat.START)
        return true


    }


}