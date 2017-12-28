package site.paranoia.kotlin

import org.junit.Test

/**
 * Created by Paranoia on 12/26/17.
 */
class MapListSetTest {

    @Test
    fun testList () {
        val items = listOf(1, 2, 3, 4)
        items.filter { it % 2 == 0 }
        println(items)

        val  mutableList = mutableListOf(1,2,3,34)

        val arrayList = arrayListOf(1,2,3,4)

        mutableList.map {  }

    }

    @Test
    fun testMap () {

    }


}