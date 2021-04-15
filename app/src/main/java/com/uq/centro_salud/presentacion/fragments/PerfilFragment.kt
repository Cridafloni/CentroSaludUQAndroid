package com.uq.centro_salud.presentacion.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.uq.centro_salud.R

class PerfilFragment : Fragment() {

    lateinit var content: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        content = inflater.inflate(R.layout.fragment_perfil, container, false)





        return content
    }

}