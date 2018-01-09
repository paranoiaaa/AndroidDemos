package com.example.itemdecorationdemo

import android.app.Application
import site.paranoia.common.Common

/**
 * Created by Paranoia on 12/21/17.
 */
class App :Application(){
    override fun onCreate() {
        super.onCreate()
        Common.with(this)
    }
}