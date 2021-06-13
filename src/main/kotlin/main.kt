import androidx.compose.desktop.Window
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

fun main() = Window {
    var text by remember { mutableStateOf("Hello, World!") }
    var text2 by remember { mutableStateOf("This is Sparta!!!") }
    var count = 0;
    MaterialTheme {
        Button(onClick = {
            if(count % 2 == 0){
                text = "Hello, Desktop!"
            }else{
                text = text2
            }
            count++;
        }) {
            Text(text)
        }
    }
}