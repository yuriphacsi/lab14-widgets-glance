package com.tecsup.lab14widgets

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle

class SimpleWidgetContent : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                MyContent(context)
            }
        }
    }

    @Composable
    private fun MyContent(context: Context) {
        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(GlanceTheme.colors.surface)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Mi Aplicación",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = GlanceTheme.colors.onSurface
                )
            )

            Text(
                text = "¿A dónde quieres ir?",
                style = TextStyle(
                    color = GlanceTheme.colors.onSurfaceVariant
                ),
                modifier = GlanceModifier.padding(top = 4.dp)
            )

            Spacer(modifier = GlanceModifier.height(16.dp))

            Button(
                text = "Home",
                onClick = actionStartActivity<MainActivity>(),
                modifier = GlanceModifier.fillMaxWidth()
            )

            Spacer(modifier = GlanceModifier.height(12.dp))

            Button(
                text = "Work",
                onClick = actionStartActivity<WorkActivity>(),
                modifier = GlanceModifier.fillMaxWidth()
            )
        }
    }
}