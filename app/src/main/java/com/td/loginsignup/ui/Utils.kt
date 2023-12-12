package com.td.loginsignup.ui

import android.app.Activity
import android.content.Intent

/**
 * Start new [Activity] using the provided [Class]
 *
 * @param A Activity class
 * @param activity Provide [Activity] to be started
 */

fun <A : Activity> Activity.startNewActivity(activity: Class<A>){
    val intent  = Intent(this, activity).also {
        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(it)
    }
}

/**
 * Enable/disable visibility of View objects
 *
 * @param isVisible
 */
