package com.uq.centro_salud.presentacion.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import co.com.sura.regresoseguroapp.ui.adapter.EntradaAdapter
import com.uq.centro_salud.R
import com.uq.centro_salud.infraestructura.db.ApplicationDB
import com.uq.centro_salud.infraestructura.db.Entities.EntradaLoteEntity
import kotlinx.android.synthetic.main.fragment_pendiente.view.*

class PendienteFragment : Fragment() {

    lateinit var content: View
    lateinit var adapter: EntradaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        content = inflater.inflate(R.layout.fragment_pendiente, container, false)


        adapter = EntradaAdapter(ArrayList(), activity!!)
        content.recycler_entrada.adapter = adapter

        getPendientes()

        return content
    }

    private fun getPendientes() {
        ApplicationDB.getDatabase(activity!!).entradaDao()
            .getEntradas().observe(viewLifecycleOwner, object : Observer<List<EntradaLoteEntity>> {
                override fun onChanged(t: List<EntradaLoteEntity>?) {
                    adapter.items.clear()
                    adapter.items = t as ArrayList<EntradaLoteEntity>
                    adapter.notifyDataSetChanged()
                }
            })
    }


}