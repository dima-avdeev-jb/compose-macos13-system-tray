// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*

val trayState = TrayState()

fun sendNotification(text: String) {
    trayState.sendNotification(Notification("tips", text, Notification.Type.Info))
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, state = remember {
        WindowState(
            width = 200.dp, height = 200.dp, position = WindowPosition.Aligned(Alignment.Center)
        )
    }) {
        Tray(state = trayState, icon = ColorPainter(Color.Black))
        MaterialTheme {
            Button(onClick = {
                sendNotification(System.currentTimeMillis().toString())
            }) {
                Text("sendNotification")
            }
        }
    }
}
