package com.uq.centro_salud.presentacion.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cn.pedant.SweetAlert.SweetAlertDialog
import com.uq.centro_salud.R
import com.uq.centro_salud.dominio.dto.login.LoginRequest
import com.uq.centro_salud.dominio.dto.login.LoginResponse
import com.uq.centro_salud.infraestructura.api.RetrofitInstance
import com.uq.centro_salud.infraestructura.preferences.Preferences
import com.uq.centro_salud.presentacion.others.SwwtAlert
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val service = RetrofitInstance().getApiService()
        var alert = SwwtAlert(this@LoginActivity)

        if (!Preferences.getToken(applicationContext).isEmpty()) {
            nextActivity()
        }

        button_iniciar_sesion.setOnClickListener {
            alert.progressDialog()
            var username = editTextTextEmailAddress.text.toString()
            var pass = editextPass.text.toString()
            val loginRequest = getLoginRequest(pass, username)
            if (loginRequest != null) {
                var login = service.login(loginRequest)
                login.enqueue(object : Callback<LoginResponse> {

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        alert.dismissDialog()
                        alert.showMessage("Lo sentimos", t.message!!, SweetAlertDialog.ERROR_TYPE)
                    }

                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        alert.dismissDialog()
                        if (response.code() == 200) {
                            Preferences.putToken(this@LoginActivity, response.body()!!.key)
                            Toasty.success(
                                this@LoginActivity,
                                "Bienvenido!!",
                                Toast.LENGTH_SHORT,
                                true
                            ).show()
                            nextActivity()
                        } else {

                            alert.showMessage(
                                "Lo sentimos",
                                "Usuario/Contraseña incorrecta.",
                                SweetAlertDialog.ERROR_TYPE
                            )
                        }
                    }

                })


            } else {
                Toast.makeText(this, "Debe ingresar todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }


    fun getLoginRequest(username: String, password: String): LoginRequest? {
        if (username.isEmpty() or password.isEmpty())
            return null
        return LoginRequest(username, password)
    }

    fun nextActivity() {
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        finish()
    }
}