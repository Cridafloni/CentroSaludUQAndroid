package com.uq.centro_salud.presentacion.others

import android.content.Context
import android.graphics.Color
import cn.pedant.SweetAlert.SweetAlertDialog

class SwwtAlert(val context: Context) {


    var pDialog: SweetAlertDialog? = null


    fun progressDialog(){
        pDialog = SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
        pDialog!!.progressHelper.barColor = Color.parseColor("#A5DC86")
        pDialog!!.titleText = "Consultando"
        pDialog!!.setCancelable(false)
        pDialog!!.show()
    }

    fun dismissDialog(){
        if (pDialog!=null){
            pDialog!!.dismiss()
        }
    }


    fun showMessage(header:String, message:String, type:Int){
        SweetAlertDialog(context, type)
            .setTitleText(header)
            .setContentText(message)
            .show()
    }



}