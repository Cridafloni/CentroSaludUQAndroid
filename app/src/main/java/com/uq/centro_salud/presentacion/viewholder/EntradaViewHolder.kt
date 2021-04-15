package co.com.sura.regresoseguroapp.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.entrada_list_item.view.*

class EntradaViewHolder(val view:View): RecyclerView.ViewHolder(view),View.OnClickListener {

        val producto  =   view.textView_idProducto
        val cantidad_entrante  =   view.textView_cantidad
        val descripcion =   view.textView_descripcion

        override fun onClick(v: View?) {
               v!!.setOnClickListener(this)
        }


}
