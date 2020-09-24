package com.example.appfortest.activities


import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appfortest.R
import com.example.appfortest.adapters.MainContract
import com.example.appfortest.adapters.MainPresenter
import com.example.appfortest.fragments.DrinkDetailFragment
import com.example.appfortest.fragments.DrinkListFragment
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.studio.quatro.cucktaleApp.entities.Drink
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity : AppCompatActivity(), MainContract.View, DrinkListFragment.OnFragmentInteractionListener {

    //initializing presenter
    private var presenter : MainContract.Presenter = MainPresenter(this)

    override fun showLoading() {
        listPbLoading.visibility = ProgressBar.VISIBLE
    }

    override fun hideLoading() {
        listPbLoading.visibility = ProgressBar.INVISIBLE
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        presenter = MainPresenter(this)
        presenter.onLoadList()

    }

    //messege show
    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    //showing list of drinks
    override fun showList(drinks: List<Drink>) {

        val drinkListFragment = DrinkListFragment.newInstance(drinks as ArrayList<Drink>)

        supportFragmentManager.beginTransaction()
                .replace(R.id.fmMaster, drinkListFragment)
                .commit()



    }

    //show details of clicked item
    override fun showDetail(drinks: List<Drink>) {
        val drinkDetailFragment = DrinkDetailFragment.newInstance(drinks.first())

        supportFragmentManager.beginTransaction()
                .replace(R.id.fmMaster, drinkDetailFragment)
                .addToBackStack(null)
                .commit()
    }



    override fun onFragmentInteraction(query: String?, index: Int?) {
        if(query == DrinkListFragment.GET_DETAIL) {
            presenter.onLoadDrink(index.toString())
        } else if (query == DrinkListFragment.GET_RANDOM) {
            presenter.onRandomDrink()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu);
        return true
    }


    //getting multi filters choice inside dialog
    fun withMultiChoiceList() {
        // var mAuth : FirebaseAuth = Firebase.auth

        val builder = AlertDialog.Builder(this)

        builder.setTitle("This is list choice dialog box")
        builder.setMessage("Are you sure to exit?")
        builder.setPositiveButton("Yes") { dialogInterface, i ->
            Toast.makeText(applicationContext, "You are successfully logged out!", Toast.LENGTH_SHORT).show()
            Firebase.auth.signOut()
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
        }
        builder.setNegativeButton("No") {dialogInterface, i ->
            dialogInterface.dismiss()
        }
        //gettting model when refreshing
        builder.show()
    }


    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_filter -> {
            // User chose the "Settings" item, show the app settings UI...
            withMultiChoiceList()
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }

}
