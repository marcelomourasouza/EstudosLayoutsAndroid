package br.com.mawan.layouts

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : ListActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val itens = arrayListOf<String>("FrameLayout", "TableLayout", "Temas", "ViewPager", "RecycleView(LinearLayout)", "RecycleView(GridLayout)", "RecycleView(StaggeredGridLayoutManager)")

        listAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itens)
    }

    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        when (position) {
            0 -> startActivity(Intent(this@MainActivity, FrameLayoutActivity::class.java))
            1 -> startActivity(Intent(this@MainActivity, TableLayoutActivity::class.java))
            2 -> startActivity(Intent(this@MainActivity, TemasActivity::class.java))
            3 -> startActivity(Intent(this@MainActivity, ViewPagerIndexActivity::class.java))
            4 -> startActivity(Intent(this@MainActivity, RecycleViewLinearLayoutActivity::class.java).putExtra("layout", 1))
            5 -> startActivity(Intent(this@MainActivity, RecycleViewLinearLayoutActivity::class.java).putExtra("layout", 2))
            6 -> startActivity(Intent(this@MainActivity, RecycleViewLinearLayoutActivity::class.java).putExtra("layout", 3))
        }
    }

}
