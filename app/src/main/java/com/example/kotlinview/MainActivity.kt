package com.example.kotlinview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.adapter_layout.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemName = arrayListOf<ItemName>(ItemName(R.drawable.apple, "Apple"), ItemName(R.drawable.pineapple, "Pineapple"),
            ItemName(R.drawable.avocado, "Avocado"), ItemName(R.drawable.banana, "Banana"), ItemName(R.drawable.cherries, "Cherries"),
            ItemName(R.drawable.coconut, "Coconut"), ItemName(R.drawable.grapes, "Grapes"), ItemName(R.drawable.lemon, "Lemon"),
            ItemName(R.drawable.orange, "Orange"), ItemName(R.drawable.peach, "Peach"), ItemName(R.drawable.strawberry, "strawberry"),
            ItemName(R.drawable.tomato, "Tomato")
        )
        spinner.adapter = MyAdapter(R.layout.adapter_layout, itemName)
        gridView.numColumns = 3
        gridView.adapter = MyAdapter(R.layout.adapter_layout, itemName)
        listView.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayListOf(itemName[0].name, itemName[1].name, itemName[2].name,
            itemName[3].name, itemName[4].name, itemName[5].name, itemName[6].name, itemName[7].name, itemName[8].name, itemName[9].name, itemName[10].name, itemName[11].name))
    }
}

class ItemName(val photo: Int, var name: String)

class MyAdapter(private val layout: Int, private val data: ArrayList<ItemName>) : BaseAdapter() {
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = View.inflate(parent?.context, layout, null)
        view.imgPhoto.setImageResource(data[position].photo)
        view.txvName.text = data[position].name
        return view
    }
}