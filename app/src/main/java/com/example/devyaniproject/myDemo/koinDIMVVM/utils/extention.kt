package com.example.devyaniproject.myDemo.koinDIMVVM.utils

import android.app.*
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentActivity
import com.example.devyaniproject.R
import com.google.android.material.snackbar.Snackbar
import com.permissionx.guolindev.PermissionX
import java.util.*

inline val View.show: View
    get() {
        if (visibility != View.VISIBLE) {
            visibility = View.VISIBLE
        }
        return this
    }

/**
 * Hide the view. (visibility = View.INVISIBLE)
 */
inline val View.hide: View
    get() {
        if (visibility != View.INVISIBLE) {
            visibility = View.INVISIBLE
        }
        return this
    }

/**
 * Remove the view (visibility = View.GONE)
 */

inline val View.remove: View
    get() {
        if (visibility != View.GONE) {
            visibility = View.GONE
        }
        return this
    }

inline val cleanGC: Unit
    get() {

        System.runFinalization()
        Runtime.getRuntime().gc()
        Runtime.getRuntime().freeMemory()
        System.gc()
    }

fun View.showSnackBar(@NonNull fMessage: String) {
    Snackbar
        .make(this, fMessage, Snackbar.LENGTH_LONG)
        .show()
}


fun Activity.isPackageExisted(targetPackage: String?): Boolean {
    val pm: PackageManager = getPackageManager()
    try {
        val info: PackageInfo = pm.getPackageInfo(targetPackage!!, PackageManager.GET_META_DATA)
    } catch (e: PackageManager.NameNotFoundException) {
        return false
    }
    return true
}

fun Context.toast(@NonNull fMessage: String) {
    Toast.makeText(this, fMessage, Toast.LENGTH_SHORT).show()
}

fun Context.toastLong(@NonNull fMessage: String) {
    Toast.makeText(this, fMessage, Toast.LENGTH_LONG).show()
}

fun Context.hideStatusbar(mActivity: Activity) {
    mActivity.window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
}

/*fun FragmentActivity.replaceFragment(fragment: Fragment, tag: String) {
    val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
    ft.replace(R.id.contain_main, fragment, tag)
    ft.commit()
}*/

/*inline val Activity.getProgressDialog: ProgressDialog
    get() {
        val mProgressDialog = ProgressDialog(this, R.style.AppCompatAlertDialogStyle)
        mProgressDialog.setCancelable(false)
        mProgressDialog.setMessage(getString(R.string.loading))
        return mProgressDialog
    }

inline val Dialog.hideDialog: Unit
    get() {
        if (this.isShowing) {
            this.dismiss()
            this.cancel()
        }
    }*/

fun <T> Activity.goTo(
    fNextActivityClass: Class<T>,
    IsNeedToFinish: Boolean = false,
    fEnterAnimId: Int = R.anim.right_in,
    fExitAnimId: Int = R.anim.left_out,
    fBundle: Bundle.() -> Unit = {}
) {
    val lIntent = Intent(this, fNextActivityClass)
    lIntent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
    lIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
    lIntent.putExtras(Bundle().apply(fBundle))
    this.startActivity(lIntent)
    this.overridePendingTransition(fEnterAnimId, fExitAnimId)

    if (IsNeedToFinish) {
        this.finish()
    }
}

fun Activity.requestPermission(
    activity: FragmentActivity,
    permissionList: ArrayList<String>,
    isAllGranted: () -> Unit
) {
    PermissionX.init(activity)
        .permissions(
            permissionList
        )
        .onExplainRequestReason { scope, deniedList ->
            scope.showRequestReasonDialog(
                deniedList,
                "Core fundamental are based on these permissions",
                "OK",
                "Cancel"
            )
        }
        .onForwardToSettings { scope, deniedList ->
            scope.showForwardToSettingsDialog(
                deniedList,
                "You need to allow necessary permissions in Settings manually",
                "OK",
                "Cancel"
            )
        }
        .request { allGranted, grantedList, deniedList ->
            if (allGranted) {
                isAllGranted.invoke()
            } else {
                Toast.makeText(this, "These permissions are denied: $deniedList", Toast.LENGTH_LONG)
                    .show()
            }
        }
}

fun Context.isPermissionGranted(@NonNull fPermissionList: List<String>): Boolean {

    var lIsGranted = true
    for (lPermission in fPermissionList) {
        if (ActivityCompat.checkSelfPermission(
                this,
                lPermission
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            lIsGranted = false
        }
    }

    return lIsGranted
}

inline val View.hideKeyBord: Unit
    get() {
        this.clearFocus()
        (this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
            .hideSoftInputFromWindow(this.windowToken, 0)
    }

/**
 * Extension method for Showing Key Bord
 */
inline val View.showKeyBord: Unit
    get() {
        this.requestFocus()
        (this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
            .showSoftInput(this, 0)
    }

/**
 * Extension method for Focus EditText or showing keyBord
 */
inline val EditText.setKeyBordFocus: Unit
    get() {
        this.requestFocus()
        this.showKeyBord
    }
