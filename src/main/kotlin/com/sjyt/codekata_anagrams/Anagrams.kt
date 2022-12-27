import java.io.File
import java.nio.charset.Charset

class Anagrams {
    companion object {

        fun File.findAnagramsBySequence():Sequence<List<String>> {
            val result = this.useLines { lines: Sequence<String> ->
                lines.groupBy { it.sorter() }
                    .asSequence()
                    .filter { it.value.count() > 1 }
                    .map { it.value }
            }
            return result
        }

        fun File.findAnagramsByList(): List<List<String>> {
            val result = this.useLines { lines: Sequence<String> ->
                lines.groupBy { it.sorter() }
                    .filter { it.value.count() > 1 }
                    .map { it.value }
            }
            return result
        }


        private fun String.sorter(): String {
            return this.split("").sorted().joinToString("")
        }
    }
}
