package site.paranoia.common.base

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.titlebar_container.*
import site.paranoia.common.widget.TitleBar

/**
 * Created by Paranoia on 17-8-31.
 */
abstract class TitleBarActivity : BaseActivity() {

    private var titleBar: TitleBar? = null

    private lateinit var layoutMain: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        layoutMain = LinearLayout(this)
        layoutMain.orientation = LinearLayout.VERTICAL
        titleBar = TitleBar(this)
        layoutMain.addView(titleBar, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        setSupportActionBar(toolbar)
        super.onCreate(savedInstanceState)
    }

    override fun setContentView(view: View?) {
        layoutMain.addView(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        super.setContentView(layoutMain)
    }

    override fun setContentView(layoutResID: Int) {
        var view = layoutInflater.inflate(layoutResID, layoutMain, false)
        layoutMain.addView(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        super.setContentView(layoutMain)
    }

    override fun setContentView(view: View?, params: ViewGroup.LayoutParams?) {
        layoutMain.addView(view, params)
        super.setContentView(layoutMain)
    }

    fun setTitleBarText(string: String?) {
        titleBar!!.setTitleBarText(string)
    }


    fun getToolBar(): Toolbar {
        return titleBar!!.getToolBar()
    }

}