package com.sjyt.codekata_anagrams

import com.sjyt.codekata_anagrams.Anagrams.Companion.findAnagramsByList
import com.sjyt.codekata_anagrams.Anagrams.Companion.findAnagramsBySequence
import com.sjyt.codekata_anagrams.Anagrams.Companion.findContainingMostWordsInAnagrams
import com.sjyt.codekata_anagrams.Anagrams.Companion.findLongestWordInAnagrams
import com.sjyt.codekata_anagrams.Anagrams.Companion.findSixLetterOfTwoWordsAsReadable
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.File


class AnagramsTest {
    private lateinit var anagrams: Anagrams
    private lateinit var sampleFilePath: String
    private lateinit var prodFilePath: String

    @BeforeEach
    fun setup() {
        anagrams = Anagrams()
        sampleFilePath = "/Users/yutashoji/dev/codekata/codekata_anagrams/sampleWordList.txt"
        prodFilePath = "/Users/yutashoji/dev/codekata/codekata_anagrams/wordList.txt"
    }

    @Test
    fun `テストデータの中のアナグラムの組み合わせを見つけて返す`() {
        val expect = listOf(listOf("abcde", "edcba"), listOf("efghi", "ihgfe"))


        val actualAnagrams = File(sampleFilePath).findAnagramsBySequence()


        assertEquals(expect, actualAnagrams)
    }

    @Test
    fun `本物のデータの中でアナグラムの組み合わせ見つけて返す(Sequence)`() {
        val expectPair = 20683


        val actualAnagrams = File(prodFilePath).findAnagramsBySequence()


        assertEquals(expectPair, actualAnagrams.count())
    }

    @Test
    fun `本物のデータの中でアナグラムの組み合わせ見つけて返す(List)`() {
        val expectPair = 20683


        val actualAnagrams = File(prodFilePath).findAnagramsByList()


        assertEquals(expectPair, actualAnagrams.count())
    }

    @Test
    fun `アナグラムの中で最も文字数の多い単語を返す`() {
        val expectLongestWord = "acoustoelectrically"


        val actualLongestWord = File(prodFilePath).findLongestWordInAnagrams()


        assertEquals(expectLongestWord, actualLongestWord)
    }

    @Test
    fun `アナグラムの中で最も多い単語を含む組み合わせの配列を返す`() {
        val expectAnagramsContainingMostWords = listOf("alerts", "alters", "artels", "estral", "laster", "rastle", "ratels", "salter", "slater", "staler", "stelar", "talers", "tarsel")


        val actualAnagramsContainingMostWords = File(prodFilePath).findContainingMostWordsInAnagrams()


        assertEquals(expectAnagramsContainingMostWords, actualAnagramsContainingMostWords)
    }

    @Test
    fun `二つの単語が連結された6文字の単語を全て返す(Step1-Readable)`() {
        val expectAnagramsContainingMostWords = listOf("alerts", "alters", "artels", "estral", "laster", "rastle", "ratels", "salter", "slater", "staler", "stelar", "talers", "tarsel")


        val actualAnagramsContainingMostWords = File(prodFilePath).findSixLetterOfTwoWordsAsReadable()


        assertEquals(expectAnagramsContainingMostWords, actualAnagramsContainingMostWords)
    }
}