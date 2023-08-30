package com.example.note_app_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.note_app_jetpack_compose.Screens.QouteListScreen
import com.example.note_app_jetpack_compose.Screens.QuoteDetailScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            delay(5000)
            DataManger.loadassertfromfile(applicationContext)

        }
        setContent {

            App()
        }
    }
}


@Composable
fun App() {
    if (DataManger.isdataloaded.value) {

        if (DataManger.currentpage.value == Pages.LISTING) {
            QouteListScreen(data = DataManger.data) {

                DataManger.switchPages(it)
            }
        }else{
            DataManger.currentQuote?.let { QuoteDetailScreen(quote = it) }
        }
    } else {
        Box(modifier = Modifier.fillMaxSize(1f))
        {
            Text(text = "Loading...", style = MaterialTheme.typography.bodyLarge)
        }
    }
}


enum class Pages {
    LISTING, DETAIL
}