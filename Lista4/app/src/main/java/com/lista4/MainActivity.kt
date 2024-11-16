package com.lista4

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializando componentes
        val profileImage = findViewById<ImageView>(R.id.profileImage)
        val nameText = findViewById<TextView>(R.id.nameText)
        val descriptionText = findViewById<TextView>(R.id.descriptionText)
        val currentJobText = findViewById<TextView>(R.id.currentJobText)
        val experienceLayout = findViewById<LinearLayout>(R.id.experienceLayout)
// Definindo informações de perfil
        nameText.text = "Kairo Sales"
        descriptionText.text = "Desenvolvedora de software com 3 anos de experiência."
        currentJobText.text = "Emprego Atual: Desenvolvedor Full Stack na ConnecDeaf"

        // Lista de experiências
        val experiencias = listOf(
            "Desenvolvedor Full Stack - Instituto Atlântico"
        )

        // Adicionando experiências dinamicamente
        for (experiencia in experiencias) {
            val textView = TextView(this)
            textView.text = experiencia
            textView.textSize = 16f
            experienceLayout.addView(textView)
        }

        profileImage.setOnClickListener {
            Toast.makeText(this, "Foto de perfil de Kairo Sales", Toast.LENGTH_SHORT).show()
        }
    }

}
