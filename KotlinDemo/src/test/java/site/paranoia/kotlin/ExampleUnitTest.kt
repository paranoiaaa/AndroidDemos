package site.paranoia.kotlin

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun testMap () {
        val params = mapOf("1" to "2",1 to "2")
        println(params["1"])
    }

    @Test
    fun testList () {
        val params = listOf(1,2,3)
        println(params.last())
    }
}
