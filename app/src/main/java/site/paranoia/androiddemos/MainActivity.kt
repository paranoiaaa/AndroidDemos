package site.paranoia.androiddemos

import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import pers.victor.ext.click

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_test_open_wifi.setOnClickListener {
            showDialog()
        }

        tv_test_close_wifi.click {
        }
    }

    private fun showDialog() {
        val dialog = AlertDialog.Builder(this,R.style.LoadingDialog).create()
        dialog.show()
        dialog.setContentView(R.layout.alert_layout)
        val animator = ObjectAnimator()
        animator.propertyName = "alpha"
        animator.target = dialog.window!!.findViewById(R.id.alert_root_view)
        animator.duration = 400
        animator.setFloatValues(0f, 1f)
        animator.start()
    }
}
