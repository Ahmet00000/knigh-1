package com.example.mykoforward

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.graphics.PixelFormat
import android.view.Gravity
import android.view.WindowManager
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
 private var panel: LinearLayout? = null
 private lateinit var windowManager: WindowManager
 override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  windowManager = getSystemService(WINDOW_SERVICE) as WindowManager
  val root = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL; setPadding(36,36,36,36) }
  root.addView(TextView(this).apply { text="MyKO İleri — Android 16"; textSize=22f })
  root.addView(Button(this).apply { text="1. Erişilebilirlik izni"; setOnClickListener { startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)) } })
  root.addView(Button(this).apply { text="2. Ekran üzerinde gösterme izni"; setOnClickListener {
   startActivity(Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,Uri.parse("package:$packageName")))
  } })
  root.addView(Button(this).apply { text="3. Yüzen İLERİ düğmesini aç"; setOnClickListener { showPanel() } })
  root.addView(TextView(this).apply { text="Oyuna geç. Ekranda görünen İLERİ düğmesine dokun; DUR ile kes. Varsayılan joystick koordinatları örnektir." })
  setContentView(root)
 }
 private fun showPanel() {
  if (!Settings.canDrawOverlays(this)) { Toast.makeText(this,"Önce ekran üzerinde gösterme iznini aç",Toast.LENGTH_LONG).show();return }
  if (panel != null) return
  val view = LinearLayout(this).apply { orientation=LinearLayout.VERTICAL; setBackgroundColor(0xDD202020.toInt()); setPadding(8,8,8,8) }
  view.addView(Button(this).apply { text="İLERİ"; setOnClickListener {
   val ok=GestureService.current?.forward() ?: false
   Toast.makeText(this@MainActivity,if(ok) "İleri komutu gönderildi" else "Erişilebilirlik servisini aç",Toast.LENGTH_SHORT).show()
  } })
  view.addView(Button(this).apply { text="DUR"; setOnClickListener { GestureService.current?.stop() } })
  view.addView(Button(this).apply { text="X"; setOnClickListener { removePanel() } })
  val params=WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT,
   WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
   WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
   PixelFormat.TRANSLUCENT).apply { gravity=Gravity.TOP or Gravity.END; x=12; y=120 }
  windowManager.addView(view,params);panel=view
 }
 private fun removePanel() { panel?.let { windowManager.removeView(it) }; panel=null }
 override fun onDestroy() { removePanel(); super.onDestroy() }
}
