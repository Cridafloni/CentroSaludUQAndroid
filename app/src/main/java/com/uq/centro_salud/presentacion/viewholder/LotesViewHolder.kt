package co.com.sura.regresoseguroapp.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_lote_list_item.view.*

class LotesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tv_registro_invima = view.textView_registroInvima_lote
    val textView_cantidad_entrada_lote = view.textView_cantidad_entrada_lote
    val textView_fecha_ingreso_lote = view.textView_fecha_ingreso_lote
    val textView_fecha_vencimiento_lote = view.textView_fecha_vencimiento_lote
    val textView_loteProducto = view.textView_loteDelProducto_lote

}
