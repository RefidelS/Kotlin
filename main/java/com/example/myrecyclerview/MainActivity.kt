package com.example.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.xmlpull.v1.sax2.Driver
import androidx.recyclerview.widget.GridLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<commander>
    lateinit var imgId: Array<Int>
    lateinit var namaId: Array<String>
    lateinit var descId: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgId = arrayOf(
            R.drawable.napoleon0,
            R.drawable.alex1,
            R.drawable.julius2,
            R.drawable.hannibal3,
            R.drawable.marechal4,
            R.drawable.frederick5,
            R.drawable.gustavus6,
            R.drawable.prince7
        )

        namaId = arrayOf(
            "Napoleon Bonaparte",
            "Alexander the Great",
            "Julius Caesar",
            "Hannibal Barca",
            "Henri de La Tour d’Auvergne, vicomte de Turenne",
            "Frederick the Great",
            "Gustavus Adolphus",
            "Prince Eugene of Savoy"
        )

        descId = arrayOf(
            "1804–1815",
            "356 bc-323 bc",
            "100 bc-44 bc",
            "247 bc-183 bc",
            "1611-1675",
            "1712-1786",
            "1594-1632",
            "1663-1736"
        )

        newRecyclerView = findViewById(R.id.RecycleList)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<commander>()
        getUserData()

    }

    private fun getUserData() {
        newArrayList.clear() // Clear the existing data
        for (i in imgId.indices) {

            val Driver = commander(imgId[i], namaId[i], descId[i])
            newArrayList.add(Driver)
        }
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.adapter = MyListAdapter(newArrayList)
    }


    private fun getGridUserData() {
        newArrayList.clear()

        val layoutManager = GridLayoutManager(this, 2)
        newRecyclerView.layoutManager = layoutManager

        for (i in imgId.indices) {

            val Driver = commander(imgId[i], namaId[i], descId[i])
            newArrayList.add(Driver)
        }

        newRecyclerView.adapter = MyGridAdapter(newArrayList)
    }

    private fun getCardUserData(){
        newArrayList.clear()
        for (i in imgId.indices){

            val Driver = commander(imgId[i],namaId[i], descId[i])
            newArrayList.add(Driver)
        }
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.adapter = MyCardAdapter(newArrayList)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int){
        when(selectedMode){
            R.id.action_list ->{
                getUserData()
            }
            R.id.action_card-> {
                getCardUserData()
            }
            R.id.action_grid-> {
                getGridUserData()
            }
        }
    }
}