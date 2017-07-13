package br.com.mawan.layouts

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_view_pager_tab_viewpager.*

class ViewPagerTabViewPagerActivity : AppCompatActivity() {

    private var demoCollection: DemoCollectionPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager_tab_viewpager)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        demoCollection = DemoCollectionPagerAdapter(supportFragmentManager)
        viewpager.adapter = demoCollection
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }

    class DemoCollectionPagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {
        override fun getPageTitle(position: Int): CharSequence = "OBJETO ${position + 1}"
        override fun getCount(): Int = 100

        override fun getItem(position: Int): Fragment {
            val frag = DemoObjectFragment()
            val args = Bundle()
            args.putInt(frag.ARG_OBJECT, position)
            frag.arguments = args
            return frag
        }

    }

    class DemoObjectFragment : Fragment() {
        val ARG_OBJECT = "object"

        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val rootView = inflater?.inflate(R.layout.fragment_viewpage_collection, container, false)
            rootView?.findViewById<TextView>(android.R.id.text1)?.setText(arguments?.getInt(ARG_OBJECT).toString())
            return rootView
        }
    }
}

