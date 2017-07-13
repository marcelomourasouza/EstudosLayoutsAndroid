package br.com.mawan.layouts.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import br.com.mawan.layouts.Car
import br.com.mawan.layouts.R
import br.com.mawan.layouts.adapter.CarAdapter.CarViewHolder
import android.widget.Toast



/**
 * Created by marcelo on 12/07/2017.
 */

class CarAdapter(context: Context, listaCars: ArrayList<Car>, layout: Int): RecyclerView.Adapter<CarViewHolder>() {

    private val mListaCars = listaCars
    private val mLayouInflater = LayoutInflater.from(context)//context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private val mLayout = layout

    override fun getItemCount(): Int = mListaCars.size

    fun add(car: Car ) {
        mListaCars.add(car)
    }

    fun remove(position: Int) {
        mListaCars.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onBindViewHolder(holder: CarViewHolder?, position: Int) {
        holder?.imagem?.setImageResource(mListaCars.get(position).imagem)
        holder?.marca?.text = mListaCars.get(position).marca
        holder?.modelo?.text = mListaCars.get(position).modelo
        Log.d("Debug", "----------------------------------> onBindViewHolder")
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CarViewHolder {
        val view = mLayouInflater.inflate(mLayout, parent, false)
        val holder = CarViewHolder(view)
        Log.d("Debug", "----------------------------------> onCreateViewHolder")
        return holder
    }

    inner class CarViewHolder(view: View) : RecyclerView.ViewHolder(view),  View.OnClickListener, View.OnLongClickListener {
        val imagem = view.findViewById<ImageView>(R.id.imageView1) as ImageView
        val modelo = view.findViewById<TextView>(R.id.textViewModelo) as TextView
        var marca = view.findViewById<TextView>(R.id.textViewMarca) as TextView

        init {
            view.setOnClickListener(this)
            view.setOnLongClickListener(this)
        }

        override fun onClick(view: View?) {
            val position = adapterPosition // gets item position
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                Toast.makeText(view?.context, "Marcar: ${marca.text}, Modelo: ${modelo.text}", Toast.LENGTH_SHORT).show()
            }
        }

        override fun onLongClick(view: View?): Boolean {
            val position = adapterPosition // gets item position
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                remove(position)
            }
            return true
        }
    }
}