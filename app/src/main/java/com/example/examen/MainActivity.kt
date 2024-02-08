package com.example.examen

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.examen.ui.theme.ExamenTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Restaurant()
                }
            }
        }
    }
}

@Composable
fun Restaurant() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val image = painterResource(R.drawable.cacahuazintle)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.size(400.dp)
        )
        Spacer(modifier = Modifier.height(3.dp))
        ContactItem(icon = Icons.Default.LocationOn, text = "Suc.1: Zaragoza #213 zona Centro, Calvillo Ags\n" +
                "Suc.2: Bldv. Rodolfo Landeros #150, Calvillo, Ags\n" +
                "Suc.3: Av. Aguascalientes Sur #436 Local 9-A, Col. España, Ags.")

        ContactItem(icon = Icons.Default.Phone, text = "495 956 16 35, 495 956 72 28 y 449 320 65 01")

    Column (Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
                CustomButton("Llamar") {

                }
                Spacer(modifier = Modifier.width(16.dp)) // Espaciado entre los botones
                CustomButton("WhatsApp") {

                }

            }
        }
    }


}

@Composable
fun CustomButton(text: String, ClickAction: () -> Unit) {

    Button(
        //  onClick = { onClickAction() },
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth(),

        colors = ButtonDefaults.buttonColors( Color.Green)

    ) {
        Text(
            text = text,
            color = Color.White
        )
    }
}

@Composable
fun ContactItem(icon: ImageVector, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(4.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(30.dp))
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            color = Color.Gray,
            style = MaterialTheme.typography.bodySmall)

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExamenTheme {
        Restaurant()
    }
}