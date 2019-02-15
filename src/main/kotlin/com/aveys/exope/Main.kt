package com.aveys.exope

val translator = Translator()

fun main(args: Array<String>) {
    val argsList = args.asList()
    when {
        argsList.size != 2 -> showHelp()
        argsList[0] == "-f" -> {
            println("La traduction de ${argsList[1]} en français est : " + translator.decode(argsList[1]))
        }
        argsList[0] == "-j" -> {
            println("La traduction de ${argsList[1]} en javanais est : " + translator.encode(argsList[1]))
        }
        else -> showHelp()
    }
}

fun showHelp() {
    println("Usage : -f <javanais> : traduction de javanais en français")
    println("-j <français> : traduction de français en javanais")
}
