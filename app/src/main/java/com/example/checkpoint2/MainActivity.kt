package com.example.checkpoint2

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.checkpoint2.ui.theme.CheckPoint2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createDropDown()
        findViewById<Button>(R.id.botao).setOnClickListener{
            val nome = findViewById<EditText>(R.id.CampoNome).text.toString()
            val email = findViewById<EditText>(R.id.CampoEmail).text.toString()
            val formaContato = checkActivity().text.toString()
            showAlert("Informações Digitadas", "Nome: $nome \n Email: $email \n \n $formaContato")
        }
    }

    private fun createDropDown() {
        val spinner = findViewById<Spinner>(R.id.Spinner)
        val tipoContato = arrayOf("Residencial", "Comercial")
        val aAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, tipoContato)
        aAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = aAdapter
    }


    private fun checkActivity(): CheckBox {
        val contatoTelefone = findViewById<CheckBox>(R.id.ContatoTelefone)
        val contatoEmail = findViewById<CheckBox>(R.id.ContatoEmail)

        if(contatoTelefone.isChecked) return contatoTelefone

        return contatoEmail
    }

    private fun showAlert(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
        val dialog = builder.create()
        dialog.show()
    }
}

