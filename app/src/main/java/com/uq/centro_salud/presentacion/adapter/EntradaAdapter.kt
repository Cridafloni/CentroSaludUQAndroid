package co.com.sura.regresoseguroapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.com.sura.regresoseguroapp.ui.viewholder.EntradaViewHolder
import com.uq.centro_salud.R
import com.uq.centro_salud.infraestructura.db.Entities.EntradaLoteEntity

class EntradaAdapter(
    var items: ArrayList<EntradaLoteEntity>,
    val context: Context
) :
    RecyclerView.Adapter<EntradaViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = EntradaViewHolder(
        LayoutInflater.from(context)
            .inflate(R.layout.entrada_list_item, parent, false)
    )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: EntradaViewHolder, position: Int) {

        var entrada = items.get(position)

        holder.producto.text = entrada.producto.toString()
        holder.cantidad_entrante.text = entrada.cantidad_entrante.toString()
        holder.descripcion.text = entrada.descripcion.toString()

    }


}