package com.sjyt.codekata_anagrams

import java.io.File

class Anagrams {
    companion object {

        fun File.findAnagramsBySequence(): Sequence<List<String>> {
            return useLines { lines: Sequence<String> ->
                lines.groupBy { it.sorter() }
                    .asSequence()
                    .filter { it.value.count() > 1 }
                    .map { it.value }
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
            return  useLines { lines: Sequence<String> ->
                lines.groupBy { it.sorter() }
                    .asSequence()
                    .filter { it.value.count() > 1 }
                    .flatMap { it.value }
                    .reduce { longest, word ->
                        if (longest.length < word.length) {
                            return@reduce word
                        }
                        return@reduce longest
                    }
            }
        }


        private fun String.sorter(): String {
            return this.split("").sorted().joinToString("")
        }
    }
}
