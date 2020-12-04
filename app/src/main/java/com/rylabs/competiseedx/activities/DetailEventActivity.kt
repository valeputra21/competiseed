package com.rylabs.competiseedx.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.rylabs.competiseedx.R
import com.rylabs.competiseedx.app.RyRouter


class DetailEventActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var collapsingToolbar: CollapsingToolbarLayout
    private lateinit var appBarLayout: AppBarLayout
    private lateinit var btnCheckout: Button
    private lateinit var router: RyRouter
    private var appBarExpanded = true
    private var collapseMenu: Menu? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail_event)
        router = RyRouter(this)

        toolbar = findViewById(R.id.anim_toolbar)
        appBarLayout = findViewById(R.id.main_appbar)
        collapsingToolbar = findViewById(R.id.main_collapsing)
        btnCheckout = findViewById(R.id.btn_checkout)



        setSupportActionBar(toolbar);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        appBarLayout.addOnOffsetChangedListener(OnOffsetChangedListener { _, verticalOffset ->
            if(Math.abs(verticalOffset) > 200){
                appBarExpanded = false
                collapsingToolbar.title = "Blog Competition: Menulis Sosok"
            }else{
                appBarExpanded = true;
                collapsingToolbar.title = ""
            }
            invalidateOptionsMenu()
        })


        btnCheckout.setOnClickListener { router.openActivity(ChartActivity::class.java) }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.detail_event_menu, menu)
        this.collapseMenu = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        onBackPressed()

        return super.onOptionsItemSelected(item)
    }

}