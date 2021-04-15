package co.com.sura.regresoseguroapp.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.uq.centro_salud.presentacion.adapter.OnClick
import kotlinx.android.synthetic.main.articulo_list_item.view.*

class ArticulosViewHolder(val view:View): RecyclerView.ViewHolder(view),View.OnClickListener {



        val tv_tipo_producto  =   view.textView_tipo_producto
        val textView_nombre  =   view.textView_nombre
        val tv_registro_invima =   view.textView_registro_invima
        val tv_proveedor =   view.textView_proveedor
        val tv_fecha_registro  =   view.textView_fecha_registro
        val tv_material  =   view.textView_materia
        val tv_presentacion  =   view.textView_presentacion

        override fun onClick(v: View?) {
               v!!.setOnClickListener(this)
        }


}
