package org.example.krona

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import android.widget.VideoView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.net.toUri

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppWithSplash()
        }
    }
}

@Composable
actual fun PlayStartupVideo(onVideoEnd: () -> Unit) {
    val context = LocalContext.current

    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { ctx ->
            VideoView(ctx).apply {
                setVideoURI("android.resource://${context.packageName}/raw/krona".toUri())
                setOnCompletionListener {
                    onVideoEnd()
                }
                start()
            }
        }
    )
}

@Preview
@Composable
fun AppAndroidPreview() {
    AppWithSplash()
}