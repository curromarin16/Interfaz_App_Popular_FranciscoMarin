package com.example.interfaz_app_popular

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.interfaz_app_popular.ui.theme.Interfaz_App_PopularTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Interfaz_App_PopularTheme {
                MainScreen()
            }
        }
    }
}



@Composable
fun MainScreen() {
    var pantalla by remember { mutableStateOf("inicio") }

    Scaffold(
        bottomBar = {
            NavigationBar(
                tonalElevation = 2.dp,
                containerColor = Color.Black
            ) {
                NavigationBarItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_casa),
                            contentDescription = "Inicio",
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    label = {
                        Text(
                            "Inicio",
                            fontSize = 10.sp,
                            color = if (pantalla == "inicio") Color.White else Color.Gray
                        )
                    },
                    selected = pantalla == "inicio",
                    onClick = { pantalla = "inicio" }
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_usuario),
                            contentDescription = "Perfil",
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    label = {
                        Text(
                            "Perfil",
                            fontSize = 10.sp,
                            color = if (pantalla == "perfil") Color.White else Color.Gray
                        )
                    },
                    selected = pantalla == "perfil",
                    onClick = { pantalla = "perfil" }
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_mensaje),
                            contentDescription = "Mensajes",
                            modifier = Modifier.size(20.dp)

                        )
                    },
                    label = {
                        Text(
                            "Mensajes",
                            fontSize = 10.sp,
                            color = if (pantalla == "Mensajes") Color.White else Color.Gray
                        )
                    },
                    selected = pantalla == "Mensajes",
                    onClick = { pantalla = "Mensajes" }
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            when (pantalla) {
                "inicio" -> Inicio()
                "perfil" -> Perfil()
                "Mensajes" -> Mensajes()
            }
        }
    }
}


@Composable
fun Inicio() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("INSTAGRAM 2", fontSize = 24.sp, color = Color.White)
                Image(
                    painter = painterResource(id = R.drawable.ic_instgram2),
                    contentDescription = "Icono de la app",
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val historiasImagenes = listOf(
                R.drawable.avatar1,
                R.drawable.avatar2,
                R.drawable.avatar3,
                R.drawable.avatar4,
                R.drawable.avatar5,
            )

            for (imagenResId in historiasImagenes) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .border(2.dp, Color.Blue, CircleShape)
                        .padding(4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = imagenResId),
                        contentDescription = "Historia",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar1),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .border(1.dp, Color.Blue, CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("efren_rosales777", fontSize = 16.sp, color = Color.White)
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ayala),
                    contentDescription = "Imagen de publicación",
                    modifier = Modifier.fillMaxSize()
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text("❤", fontSize = 24.sp, color = Color.White)
                Text("💬", fontSize = 24.sp, color = Color.White)
            }

            Row(modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)) {
                Text("juanito_89: ", color = Color.Blue, fontSize = 14.sp)
                Text("Vaya sitio raro, no se me ocurriria ir", color = Color.White, fontSize = 14.sp)
            }
            Row(modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)) {
                Text("el_antonio69: ", color = Color.Blue, fontSize = 14.sp)
                Text("@juanito_89", color = Color.Green, fontSize = 14.sp)
                Text(" el sitio da miedo", color = Color.White, fontSize = 14.sp)
            }
            Row(modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)) {
                Text("maria_perez_26262: ", color = Color.Blue, fontSize = 14.sp)
                Text("llevo encerrada 3 dias ayuda", color = Color.White, fontSize = 14.sp)
            }
            Row(modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)) {
                Text("jimbo_jimbo: ", color = Color.Blue, fontSize = 14.sp)
                Text("vendo opel corsa", color = Color.White, fontSize = 14.sp)
            }
        }
    }
}


@Composable
fun Perfil() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.avatarusuario),
                contentDescription = "Avatar del usuario",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            )

            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("8", fontSize = 16.sp, color = Color.White)
                    Text("Publicaciones", fontSize = 12.sp, color = Color.Gray)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("2", fontSize = 16.sp, color = Color.White)
                    Text("Seguidores", fontSize = 12.sp, color = Color.Gray)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("300", fontSize = 16.sp, color = Color.White)
                    Text("Seguidos", fontSize = 12.sp, color = Color.Gray)
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text("Jimbo_moreno_69", fontSize = 18.sp, color = Color.White)
            Text(
                "Amante del fornite.",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Gray, shape = CircleShape)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text("Editar perfil", fontSize = 14.sp, color = Color.White)
            }
        }

        val publicaciones = listOf(
            R.drawable.post1,
            R.drawable.post2,
            R.drawable.post3,
            R.drawable.post4,
            R.drawable.post5,
            R.drawable.post6,
            R.drawable.post7,
            R.drawable.post8
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(publicaciones.size) { index ->
                Image(
                    painter = painterResource(id = publicaciones[index]),
                    contentDescription = "Publicación",
                    modifier = Modifier
                        .size(120.dp)
                        .background(Color.Gray)
                )
            }
        }
    }
}


@Composable
fun Mensajes() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Mensajes", fontSize = 24.sp, color = Color.White)
            Image(
                painter = painterResource(id = R.drawable.ic_mensaje),
                contentDescription = "Nuevo mensaje",
                modifier = Modifier.size(24.dp)
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatarmensaje1),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text("Raccoon_Boloñesa", fontSize = 16.sp, color = Color.White)
                    Text("Voy a por un kebab y vuelvo", fontSize = 14.sp, color = Color.Gray)
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatarmensaje2),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text("pery_6969", fontSize = 16.sp, color = Color.White)
                    Text("Te espero en el refugio", fontSize = 14.sp, color = Color.Gray)
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatarmensaje3jpg),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text("marmo_anillo", fontSize = 16.sp, color = Color.White)
                    Text("estoy detrás tuya", fontSize = 14.sp, color = Color.Gray)
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatarmensaje4),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text("elmoreno347", fontSize = 16.sp, color = Color.White)
                    Text("Soy masón lo admito", fontSize = 14.sp, color = Color.Gray)
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatarmensaje5),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text("labestia_victor", fontSize = 16.sp, color = Color.White)
                    Text("Te recomiendo un juego...", fontSize = 14.sp, color = Color.Gray)
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatarmensaje6),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text("f.puga19", fontSize = 16.sp, color = Color.White)
                    Text("Tengo que ir a por carbones", fontSize = 14.sp, color = Color.Gray)
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatarmensaje7),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text("gustavogg1", fontSize = 16.sp, color = Color.White)
                    Text("Llevo la mochila que va a explotar", fontSize = 14.sp, color = Color.Gray)
                }
            }


        }
    }
}
