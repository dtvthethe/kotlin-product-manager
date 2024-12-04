package org.dtvthe.kotlinproductmanager.controller

import org.junit.jupiter.api.*
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // --> Không dùng static nếu là Kotlin
class StandardTests {
    @BeforeAll
    fun setupGlobal() {
        println("Thiết lập trước tất cả test chỉ chạy 1 lần.")
    }

    @BeforeEach
    fun setupEach() {
        println("Chuẩn bị trước mỗi test case.")
    }


    ///////////////////////////
    @Test
    fun test1() {
        println("Test case 1")
        assertEquals(2, 1 + 1)
    }

    @Test
    fun test2() {
        println("Test case 2")
        assertTrue(3 > 2)
    }

    @Disabled("Không chạy test case này.")
    @Test
    fun testDisabled() {
        println("Test bị tắt.")
    }
    ///////////////////////////



    @AfterEach
    fun cleanupEach() {
        println("Dọn dẹp sau mỗi test case.")
    }

    @AfterAll
    fun cleanupGlobal() {
        println("Dọn dẹp sau tất cả test chỉ chạy 1 lần.")
    }
}
