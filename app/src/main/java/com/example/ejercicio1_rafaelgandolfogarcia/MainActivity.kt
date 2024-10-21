package com.example.ejercicio1_rafaelgandolfogarcia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.ui.Alignment


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FormularioScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormularioScreen() {
    var nombre by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var pais by remember { mutableStateOf("") }

    var nombreMostrado by remember { mutableStateOf("") }
    var emailMostrado by remember { mutableStateOf("") }
    var direccionMostrado by remember { mutableStateOf("") }
    var paisMostrado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Rafael Gandolfo Garcia",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 16.dp).background(Color.Black).fillMaxWidth() ,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(10) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Gray, shape = CircleShape)
                )
            }
        }
        Row( horizontalArrangement = Arrangement.SpaceBetween){


        // Cuadro
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Cyan)

        )

        Spacer(modifier = Modifier.width(16.dp))

        // Texto
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Nullam finibus ac ante non fringilla. Curabitur ornare malesuada hendrerit. " +
                        "Etiam ullamcorper enim vel justo varius tellus aliquet nec.",
                style = TextStyle(fontSize = 14.sp)
            )
        }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Formulario",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)) {


            // Formulario a la izquierda
            Column(
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Nombre") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = direccion,
                    onValueChange = { direccion = it },
                    label = { Text("Dirección") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = pais,
                    onValueChange = { pais = it },
                    label = { Text("País") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))


            }

            Spacer(modifier = Modifier.height(32.dp)) // Espacio entre formulario y resultados

            // datos a la derecha
            Column(
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Spacer(modifier = Modifier.height(28.dp))
                Text(" $nombreMostrado", modifier = Modifier.padding(bottom = 38.dp))
                Spacer(modifier = Modifier.height(8.dp))
                Text(" $emailMostrado", modifier = Modifier.padding(bottom = 38.dp))
                Spacer(modifier = Modifier.height(8.dp))
                Text(" $direccionMostrado", modifier = Modifier.padding(bottom = 38.dp))
                Spacer(modifier = Modifier.height(8.dp))
                Text(" $paisMostrado", modifier = Modifier.padding(bottom = 38.dp))
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
        // actualizar
        Button(
            onClick = {
                nombreMostrado = nombre
                emailMostrado = email
                direccionMostrado = direccion
                paisMostrado = pais
            },

            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Actualizar")
        }
    }
}


@Composable
fun CampoTexto(
    label: String,
    valor: String,
    onValueChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(text = label, style = TextStyle(fontSize = 14.sp))
        BasicTextField(
            value = valor,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray, shape = MaterialTheme.shapes.small)
                .padding(8.dp)
        )
    }
}

