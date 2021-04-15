package co.com.sura.regresoseguroapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.com.sura.regresoseguroapp.ui.viewholder.ArticulosViewHolder
import com.uq.centro_salud.R
import com.uq.centro_salud.infraestructura.db.Entities.ArticulosEntity
import com.uq.centro_salud.presentacion.adapter.OnItemClick

class ArticulosAdapter(var items: ArrayList<ArticulosEntity>, val context: Context,val onItemClick: OnItemClick ) :
        RecyclerView.Adapter<ArticulosViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ArticulosViewHolder(
            LayoutInflater.from(context)
                    .inflate(R.layout.articulo_list_item, parent, false)
    )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ArticulosViewHolder, position: Int) {

        var producto = items.get(position)

        holder.tv_tipo_producto.text = producto.tipo
        holder.tv_fecha_registro.text = producto.fecha_registro
        holder.tv_material.text = producto.material
        holder.tv_presentacion.text = producto.presentacion
        holder.tv_registro_invima.text = producto.registro_invima
        holder.tv_proveedor.text = producto.proveedor
        holder.textView_nombre.text = producto.nombre

        holder.view.setOnClickListener {
            onItemClick.onItemClick(producto)
        }


    }



}