package br.com.mawan.layouts

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_view_pager_tab_toolbar.*

class ViewPagerTabToolbarActivity : AppCompatActivity() {

    private var demoCollection: DemoCollectionPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager_tab_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        demoCollection = DemoCollectionPagerAdapter(supportFragmentManager)
        viewpager.adapter = demoCollection

        // Quando é usado TabLayout
        tabs.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewpager.currentItem = tab?.position ?: 0
            }
        })

        viewpager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                tabs.setScrollPosition(position, positionOffset, false)
            }

            override fun onPageSelected(position: Int) {}

        })

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }

    class DemoCollectionPagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {
        override fun getPageTitle(position: Int): CharSequence = "OBJETO ${position + 1}"
        override fun getCount(): Int = 3

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

