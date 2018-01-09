package com.example.itemdecorationdemo

/**
 * Created by Paranoia on 12/21/17.
 */

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.view.View


class TitleItemDecoration(context: Context, val data: List<CityBean>) : RecyclerView.ItemDecoration() {
    private val mPaint: Paint = Paint()
    private val mBounds: Rect = Rect()
    private val mTitleHeight: Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30f, context.resources.displayMetrics).toInt()
    private val mTitleFontSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16f, context.resources.displayMetrics).toInt()

    init {
        mPaint.textSize = mTitleFontSize.toFloat()
        mPaint.isAntiAlias = true
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State?) {
        super.onDraw(c, parent, state)
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight
        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val params = child
                    .layoutParams as RecyclerView.LayoutParams
            val position = params.viewLayoutPosition
            if (position == 0) {
                drawTitleArea(c, left, right, child, params, position)
            } else {
                if (data[position].tag != data[position - 1].tag) {
                    drawTitleArea(c, left, right, child, params, position)
                }
            }
        }
    }

    private fun drawTitleArea(c: Canvas, left: Int, right: Int, child: View, params: RecyclerView.LayoutParams, position: Int) {
        mPaint.color =  Color.parseColor("#FFDFDFDF")
        c.drawRect(left.toFloat(), (child.top - params.topMargin - mTitleHeight).toFloat(), right.toFloat(), (child.top - params.topMargin).toFloat(), mPaint)
        mPaint.color =  Color.parseColor("#FF000000")
        mPaint.getTextBounds(data[position].tag, 0, data[position].tag.length, mBounds)
        c.drawText(data[position].tag, child.paddingLeft.toFloat(), (child.top - params.topMargin - (mTitleHeight / 2 - mBounds.height() / 2)).toFloat(), mPaint)
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State?) {
        val pos = (parent.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
        val tag = data[pos].tag
        val child = parent.findViewHolderForLayoutPosition(pos).itemView
        var flag = false
        if (pos + 1 < data.size) {
            if (tag != data[pos + 1].tag) {
                if (child.height + child.top < mTitleHeight) {
                    c.save()
                    flag = true
                    c.translate(0f, (child.height + child.top - mTitleHeight).toFloat())
                }
            }
        }
        mPaint.color =  Color.parseColor("#FFDFDFDF")
        c.drawRect(parent.paddingLeft.toFloat(), parent.paddingTop.toFloat(), (parent.right - parent.paddingRight).toFloat(), (parent.paddingTop + mTitleHeight).toFloat(), mPaint)
        mPaint.color =  Color.parseColor("#FF000000")
        mPaint.getTextBounds(tag, 0, tag.length, mBounds)
        c.drawText(tag, child.paddingLeft.toFloat(),
                (parent.paddingTop + mTitleHeight - (mTitleHeight / 2 - mBounds.height() / 2)).toFloat(),
                mPaint)
        if (flag) {
            c.restore()
        }
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = (view.layoutParams as RecyclerView.LayoutParams).viewLayoutPosition
        if (position == 0) {
            outRect.set(0, mTitleHeight, 0, 0)
        } else {
            if (data[position].tag != data[position - 1].tag) {
                outRect.set(0, mTitleHeight, 0, 0)
            } else {
                outRect.set(0, 0, 0, 0)
            }
        }
    }
}
