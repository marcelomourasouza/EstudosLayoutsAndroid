package br.com.mawan.layouts

import android.R
import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView

class ViewPagerIndexActivity : ListActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val itens = arrayListOf<String>("TabLayout > Toolbar", "TabLayout > ViewPager", "PagerTitleStrip")
        listAdapter = ArrayAdapter<String>(this, R.layout.simple_list_item_1, itens)
    }

    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        when (position) {
            0 -> startActivity(Intent(this@ViewPagerIndexActivity, ViewPagerTabToolbarActivity::class.java))
            1 -> startActivity(Intent(this@ViewPagerIndexActivity, ViewPagerTabViewPagerActivity::class.java))
            2 -> startActivity(Intent(this@ViewPagerIndexActivity, ViewPagerPagerTitleStripActivity::class.java))
        }
    }
}
