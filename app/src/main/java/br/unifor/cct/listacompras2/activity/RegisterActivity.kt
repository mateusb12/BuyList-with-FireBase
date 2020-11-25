package br.unifor.cct.listacompras2.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.unifor.cct.listacompras2.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

    private lateinit var registerEmail: EditText
    private lateinit var registerPassword: EditText
    private lateinit var registerSave: Button
    private lateinit var registerUsername: EditText
    private lateinit var registerFullname: EditText
    private lateinit var registerCellphone: EditText

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth

        registerEmail = findViewById(R.id.register_edittext_email)
        registerPassword = findViewById(R.id.register_edittext_password)
        registerUsername = findViewById(R.id.register_edittext_username)
        registerFullname = findViewById(R.id.register_edittext_fullname)
        registerCellphone = findViewById(R.id.register_edittext_cellphone)

        registerSave = findViewById(R.id.register_button_save)
        registerSave.setOnClickListener {
            var formOk = true

            if(registerEmail.text.isEmpty()){
                registerEmail.error = "Este campo não pode ser nulo."
                formOk = false
            }

            if(registerPassword.text.isEmpty()){
                registerPassword.error = "Este campo não pode ser nulo."
                formOk = false
            }

            if(registerUsername.text.isEmpty()){
                registerUsername.error = "Este campo não pode ser nulo."
                formOk = false
            }

            if(registerFullname.text.isEmpty()){
                registerFullname.error = "Este campo não pode ser nulo."
                formOk = false
            }

            if(registerCellphone.text.isEmpty()){
                registerCellphone.error = "Este campo não pode ser nulo."
                formOk = false
            }

            // Criar dialog intermitente

            if(formOk){
                val email = registerEmail.text.toString()
                val password = registerPassword.text.toString()
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this){ task ->
                        if(task.isSuccessful){
                            Toast.makeText(RegisterActivity@this,
                                "Usuário criado com sucesso!",
                                Toast.LENGTH_SHORT).show()
                            finish()
                        } else {
                            Toast.makeText(RegisterActivity@this,
                                "Erro ao criar usuário!",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }
}