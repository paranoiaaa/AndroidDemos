package com.wqd.rxhttp

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers

/**
 * Created by Paranoia on 12/24/17.
 */


private class CommonFilter<T> : Function<BaseReturnBean<T>, BaseReturnBean<T>> {
    @Throws(Exception::class)
    override fun apply(t: BaseReturnBean<T>): BaseReturnBean<T> {
        try {
            if (200 != t.statusCode) {
                throw HttpRuntimeException(t.statusMsg)
            }
        }catch (e:Exception) {

        }

        return t
    }
}


@SuppressLint("CheckResult")
fun <T> http(observable: Observable<BaseReturnBean<T>>, success: ((json: BaseReturnBean<T>) -> Unit))  {
    observable
            .map(CommonFilter())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ data ->
                success.invoke(data)
            }, { throwable ->
                try {
                    throwable.printStackTrace()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            })
}
