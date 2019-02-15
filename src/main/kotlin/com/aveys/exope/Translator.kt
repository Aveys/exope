package com.aveys.exope

class Translator {

    private val vowels: CharArray = charArrayOf('a', 'o', 'i', 'u', 'e', 'y')

    /**
     * Encode french to javanese
     * @param text The text to encode
     * @return encoded string
     */
    fun encode(text: String): String {
        var result = ""
        var previousVowel = false
        text.asIterable().forEach {
            if (vowels.contains(it)) {
                if (!previousVowel)
                    result += "av"
                previousVowel = true
            } else {
                previousVowel = false
            }
            result += it
        }
        return result
    }

    /**
     * Decode javanese to french
     * @param text The text to decode
     * @return decoded string
     */
    fun decode(text: String): String {
        var result = ""
        var stack: String? = null

        // remove starting "av" for convenience
        val array = if (text.startsWith("av") && vowels.contains(text[2])) {
            text.removePrefix("av").toCharArray()
        } else {
            text.toCharArray()
        }

        //scanning from right to left
        for (i in (array.size - 1) downTo 0) {
            if (stack != null) {
                // stack is full, analysing content
                if (stack.length == 2) {
                    if (stack != "av") {
                        result = array[i] + stack + result
                        stack = null
                    } else if (stack == "av" && !vowels.contains(array[i])) {
                        result = array[i] + result
                        stack = null
                    } else if (stack == "av" && vowels.contains(array[i])) {
                        result = array[i] + stack + result
                        stack = null
                    }
                } else if (stack.length < 2) {
                    // stacking possible parasitic syllabus
                    if (array[i] == 'a' || array[i] == 'v') {
                        stack = array[i] + stack
                    } else {
                        // resume normal scanning at this point
                        if (vowels.contains(array[i])) {
                            stack = ""
                        } else {
                            stack = null
                        }
                        result = array[i] + result
                    }
                }
            } else {
                if (vowels.contains(array[i])) {
                    // vowel detected, starting to stack 2 character
                    stack = ""
                }
                result = array[i] + result
            }
        }
        // add stack at start if not empty
        if(!stack.isNullOrEmpty()){
            result = stack + result
        }

        return result
    }
}