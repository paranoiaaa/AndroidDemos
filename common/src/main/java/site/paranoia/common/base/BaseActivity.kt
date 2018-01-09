package site.paranoia.common.base

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pers.victor.ext.ActivityMgr
import site.paranoia.common.widget.LoadingDialog


/**
 * Created by Paranoia on 17-8-30.
 */
abstract class BaseActivity: AppCompatActivity() {
    lateinit var mContext: Context

    private lateinit var loadingDialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        setContentView(bindLayout())
        window.setBackgroundDrawable(ColorDrawable(Color.WHITE))
        ActivityMgr.add(this)
        loadingDialog = LoadingDialog(this)
        initWidget()
        initInject()
        setListener()
    }

    fun showLoading(message: CharSequence? = "") {
        loadingDialog.show(message)
    }

    fun dismiss() {
        loadingDialog.dissmiss()
    }

    abstract fun initWidget()

    open fun initInject() {

    }

    abstract fun bindLayout(): Int

    open fun setListener(){

    }

    open fun loadData(){

    }
}