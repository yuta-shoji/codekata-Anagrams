package com.sjyt.codekata_anagrams

import Anagrams
import Anagrams.Companion.findAnagramsByList
import Anagrams.Companion.findAnagramsBySequence
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.File


class AnagramsTest {
    private lateinit var anagrams: Anagrams

    @BeforeEach
    fun setup() {
        anagrams = Anagrams()
    }

    @Test
    fun `テストデータの中のアナグラムの組み合わせを見つけて返す`() {
        val filePath = "/Users/yutashoji/dev/codekata/codekata_anagrams/sampleWordList.txt"
        val expect = listOf("abcde", "edcba", "efghi", "ihgfe")


        val actualAnagrams = File(filePath).findAnagramsBySequence().toList().flatten()


        assertEquals(expect, actualAnagrams)
    }

    @Test
    fun `本物のデータの中でアナグラムの組み合わせ見つけて返す(Sequence)`() {
        val filePath = "/Users/yutashoji/dev/codekata/codekata_anagrams/wordList.txt"
        val expectPair = 20683


        val actualAnagrams = File(filePath).findAnagramsBySequence()


        assertEquals(expectPair, actualAnagrams.count())
    }

    @Test
    fun `本物のデータの中でアナグラムの組み合わせ見つけて返す(List)`() {
        val filePath = "/Users/yutashoji/dev/codekata/codekata_anagrams/wordList.txt"
        val expectPair = 20683


        val actualAnagrams = File(filePath).findAnagramsByList()


        assertEquals(expectPair, actualAnagrams.count())
    }

}