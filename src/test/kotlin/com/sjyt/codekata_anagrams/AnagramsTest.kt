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

    @BeforeEach
    fun setup() {
        anagrams = Anagrams()
    }

    @Test
    fun `テストデータの中のアナグラムの組み合わせを見つけて返す`() {
        val filePath = "/Users/yutashoji/dev/codekata/codekata_anagrams/sampleWordList.txt"
        val expect = listOf(listOf("abcde", "edcba"), listOf("efghi", "ihgfe"))


        val actualAnagrams = File(filePath).findAnagramsBySequence()


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

    @Test
    fun `アナグラムの中で最も文字数の多い単語を返す`() {
        val filePath = "/Users/yutashoji/dev/codekata/codekata_anagrams/wordList.txt"
        val expectLongestWord = "acoustoelectrically"


        val actualLongestWord = File(filePath).findLongestWordInAnagrams()


        assertEquals(expectLongestWord, actualLongestWord)
    }

    @Test
    fun `アナグラムの中で最も多い単語を含む組み合わせの配列を返す`() {
        val filePath = "/Users/yutashoji/dev/codekata/codekata_anagrams/wordList.txt"
        val expectAnagramsContainingMostWords = listOf("alerts", "alters", "artels", "estral", "laster", "rastle", "ratels", "salter", "slater", "staler", "stelar", "talers", "tarsel")


        val actualAnagramsContainingMostWords = File(filePath).findContainingMostWordsInAnagrams()


        assertEquals(expectAnagramsContainingMostWords, actualAnagramsContainingMostWords)
    }

    @Test
    fun `二つの単語が連結された6文字の単語を全て返す`() {
        val filePath = "/Users/yutashoji/dev/codekata/codekata_anagrams/wordList.txt"
        val expectAnagramsContainingMostWords = listOf("alerts", "alters", "artels", "estral", "laster", "rastle", "ratels", "salter", "slater", "staler", "stelar", "talers", "tarsel")


        val actualAnagramsContainingMostWords = File(filePath).findSixLetterOfTwoWordsAsReadable()


        assertEquals(expectAnagramsContainingMostWords, actualAnagramsContainingMostWords)
    }
}