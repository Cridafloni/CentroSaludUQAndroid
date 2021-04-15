package com.uq.centro_salud.presentacion.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import co.com.sura.regresoseguroapp.ui.adapter.LotesAdapter
import com.uq.centro_salud.R
import com.uq.centro_salud.infraestructura.db.ApplicationDB
import com.uq.centro_salud.infraestructura.db.Entities.LoteEntity
import kotlinx.android.synthetic.main.lote_layout.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoteListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoteListFragment : Fragment() {

    lateinit var content: View
    lateinit var loteAdapter: LotesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        content = inflater.inflate(R.layout.lote_layout, container, false)

        loteAdapter = LotesAdapter(ArrayList(), activity!!)
        content.recycler_lote.adapter = loteAdapter

        getArticulos()


        return content
    }

    private fun getArticulos() {
        ApplicationDB.getDatabase(activity!!).loteDao()
            .getArticulos().observe(viewLifecycleOwner, object : Observer<List<LoteEntity>> {
                override fun onChanged(t: List<LoteEntity>?) {
                    loteAdapter.items.clear()
                    loteAdapter.items = t as ArrayList<LoteEntity>
                    loteAdapter.notifyDataSetChanged()
                }
            })
    }

}