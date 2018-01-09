package site.paranoia.androiddemos

import android.app.Application
import site.paranoia.common.Common

/**
 * Created by Paranoia on 12/27/17.
 */
class App :Application(){
    override fun onCreate() {
        super.onCreate()
        Common.with(this)
    }
}