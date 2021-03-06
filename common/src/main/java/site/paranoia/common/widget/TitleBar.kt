package site.paranoia.common.widget

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.titlebar_container.view.*
import site.paranoia.common.R

/**
 * Created by Paranoia on 17-8-31.
 */
class TitleBar : LinearLayout {
    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    init {
        setBackgroundColor(ContextCompat.getColor(context, R.color.background))
        addView(inflate(context, R.layout.titlebar_container, null), LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
    }

    fun setTitleBarText(string: String?) {
        title_bar_title.text = string
    }

    fun setTitleBarVisible(visibility: Int) {
        title_bar_title.visibility=visibility
    }

    fun getToolBar(): Toolbar {
        return toolbar
    }
}