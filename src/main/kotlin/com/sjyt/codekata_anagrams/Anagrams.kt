package com.sjyt.codekata_anagrams

import java.io.File

class Anagrams {
    companion object {

        fun File.findAnagramsBySequence(): List<List<String>> {
            return useLines { lines: Sequence<String> ->
                lines.groupBy { it.sorter() }
                    .asSequence()
                    .filter { it.value.count() > 1 }
                    .map { it.value }
                    .toList()
            }
        }

        fun File.findAnagramsByList(): List<List<String>> {
            return useLines { lines: Sequence<String> ->
                lines.groupBy { it.sorter() }
                    .filter { it.value.count() > 1 }
                    .map { it.value }
            }
        }

        fun File.findLongestWordInAnagrams(): String {
            return useLines { lines: Sequence<String> ->
                lines.groupBy { it.sorter() }
                    .asSequence()
                    .filter { it.value.count() > 1 }
                    .flatMap { it.value }
                    .maxBy { it.length }
            }
        }

        fun File.findContainingMostWordsInAnagrams(): List<String> {
            return useLines { lines: Sequence<String> ->
                lines.groupBy { it.sorter() }
                    .asSequence()
                    .filter { it.value.count() > 1 }
                    .map { it.value }
                    .maxBy { it.size }
            }
        }

        fun File.findSixLetterOfTwoWordsAsReadable(): List<String> {
            return useLines { lines: Sequence<String> ->
                lines.filter { it.length < 6 }
                    .fold(mutableListOf<String>()) { results, target ->
                        lines
                            .forEach { word ->
                                if (
                                    target != word
                                    && "${target}${word}".length == 6
                                    && lines.contains("${target}${word}")
                                ) {
                                    results.add("${target}${word}")
                                }
                            }
                        return@fold results
                    }
                    .toList()
            }
        }

        fun File.findSixLetterOfTwoWordsToRunFast(): List<String> {
            return listOf("")
        }

        fun File.findSixLetterOfTwoWordsAsExtendable(): List<String> {
            return listOf("")
        }


        private fun String.sorter(): String {
            return this.split("").sorted().joinToString("")
        }
    }
}
