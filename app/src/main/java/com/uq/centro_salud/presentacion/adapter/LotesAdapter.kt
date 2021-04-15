package co.com.sura.regresoseguroapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.com.sura.regresoseguroapp.ui.viewholder.LotesViewHolder
import com.uq.centro_salud.R
import com.uq.centro_salud.infraestructura.db.Entities.LoteEntity

class LotesAdapter(var items: ArrayList<LoteEntity>, val context: Context) :
    RecyclerView.Adapter<LotesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LotesViewHolder(
        LayoutInflater.from(context)
            .inflate(R.layout.fragment_lote_list_item, parent, false)
    )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: LotesViewHolder, position: Int) {
        var lote = items.get(position)
        holder.tv_registro_invima.text = lote.producto
        holder.textView_cantidad_entrada_lote.text = lote.cantidad_entrada.toString()
        holder.textView_fecha_ingreso_lote.text = lote.fecha_ingreso
        holder.textView_fecha_vencimiento_lote.text = lote.fecha_vencimiento
        holder.textView_loteProducto.text = lote.lote_del_producto

    }


}