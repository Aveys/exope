package com.aveys.exope

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class TranslatorTest {

    lateinit var translator:Translator

    @BeforeAll
    fun setUp() {
        translator = Translator()
    }

    @Test
    fun encode() {
        assertEquals( "bavonjavour", translator.encode("bonjour"))
        assertEquals( "chavantave", translator.encode("chante"))
        assertEquals( "mavoyen", translator.encode("moyen"))
        assertEquals( "avexavemplave", translator.encode("exemple"))
        assertEquals( "avau", translator.encode("au"))
        assertEquals( "avavavantavagave", translator.encode("avantage"))
    }

    @Test
    fun decode() {
        assertEquals( "bonjour", translator.decode("bavonjavour"))
        assertEquals( "chante", translator.decode("chavantave"))
        assertEquals( "moyen", translator.decode("mavoyen"))
        assertEquals( "exemple", translator.decode("avexavemplave"))
        assertEquals( "au", translator.decode("avau"))
    }
}