package com.example.mykoforward

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.graphics.Path
import android.view.accessibility.AccessibilityEvent

class GestureService : AccessibilityService() {
 companion object { var current: GestureService? = null }
 override fun onServiceConnected() { super.onServiceConnected(); current = this }
 override fun onDestroy() { if (current === this) current = null; super.onDestroy() }
 override fun onAccessibilityEvent(event: AccessibilityEvent?) {}
 override fun onInterrupt() {}

 // Values refer to landscape screen dimensions; calibrate after first test.
 fun forward(): Boolean {
  val dm = resources.displayMetrics
  val x = dm.widthPixels * .15f
  val y = dm.heightPixels * .82f
  val targetY = dm.heightPixels * .68f
  val path = Path().apply { moveTo(x,y); lineTo(x,targetY) }
  val stroke = GestureDescription.StrokeDescription(path,0,10000)
  return dispatchGesture(GestureDescription.Builder().addStroke(stroke).build(),null,null)
 }
 fun stop(): Boolean {
  val dm = resources.displayMetrics
  val x = dm.widthPixels * .15f
  val y = dm.heightPixels * .68f
  val path = Path().apply { moveTo(x,y); lineTo(x,y+1f) }
  return dispatchGesture(GestureDescription.Builder().addStroke(GestureDescription.StrokeDescription(path,0,50)).build(),null,null)
 }
}
