package br.com.mawan.layouts

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.*
import android.util.Log
import br.com.mawan.layouts.adapter.CarAdapter
import kotlinx.android.synthetic.main.activity_recycle_view_linear_layout.*
import kotlin.concurrent.thread

class RecycleViewLinearLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view_linear_layout)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var layout: Int = 0
        when (intent.getIntExtra("layout", R.layout.item_recycler_linear)) {
            1 -> {
                myRecycleLinearLayout.layoutManager = LinearLayoutManager(this)
                layout = R.layout.item_recycler_linear
                myRecycleLinearLayout.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
            }
            2 -> {
                myRecycleLinearLayout.layoutManager = GridLayoutManager(this, 3)
                layout = R.layout.item_recycler_grid
                myRecycleLinearLayout.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
                myRecycleLinearLayout.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))
            }
            3 -> {
                myRecycleLinearLayout.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
                (myRecycleLinearLayout.layoutManager as StaggeredGridLayoutManager).gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
                layout = R.layout.item_recycler_stagg
            }
        }

        myRecycleLinearLayout.setHasFixedSize(true)
        myRecycleLinearLayout.adapter = CarAdapter(this, getListaCar(20) as ArrayList<Car>, layout)

        // Carregamento por scroll
        myRecycleLinearLayout.addOnScrollListener(object: RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if (myRecycleLinearLayout.layoutManager is LinearLayoutManager || myRecycleLinearLayout.layoutManager is GridLayoutManager) {
                    val llm = myRecycleLinearLayout.layoutManager as LinearLayoutManager

                    if (llm.findLastCompletelyVisibleItemPosition() >= myRecycleLinearLayout.adapter.itemCount - 5) {
                        val adapter = myRecycleLinearLayout.adapter as CarAdapter
                        getListaCar(10).forEach { it -> adapter.add(it) }
                        myRecycleLinearLayout.post { myRecycleLinearLayout.adapter.notifyItemInserted(adapter.itemCount - 1) }
                    }
                } else {
                    val sgm = myRecycleLinearLayout.layoutManager as StaggeredGridLayoutManager
                    val last = sgm.findLastCompletelyVisibleItemPositions(null).max() ?: 0
                    if (last >= myRecycleLinearLayout.adapter.itemCount - 5) {
                        val adapter = myRecycleLinearLayout.adapter as CarAdapter
                        getListaCar(10).forEach { it -> adapter.add(it) }
                        myRecycleLinearLayout.post { myRecycleLinearLayout.adapter.notifyItemInserted(adapter.itemCount - 1) }
                    }

                }


            }
        })

        swipeRefresh.setOnRefreshListener { thread { Thread.sleep(3000); runOnUiThread { swipeRefresh.isRefreshing = false; } } }

    }
}
