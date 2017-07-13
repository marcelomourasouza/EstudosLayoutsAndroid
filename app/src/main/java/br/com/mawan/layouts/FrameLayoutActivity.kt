package br.com.mawan.layouts

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_frame_layout.*

class FrameLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_layout)
    }

    fun enviarFormulario(view: View) {
        frmLayout.visibility = View.VISIBLE
    }
}
