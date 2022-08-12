fun main() {
    var addFive = { x: Int -> x + 5 }
    println("Pass 6 to addFive: ${addFive(6)}")

    val addInts = { x: Int, y: Int -> x + y }
    val result = addInts.invoke(6, 7)
    println("Pass 6, 7 to addInts: $result")

    val intLambda: (Int, Int) -> Int = { x, y -> x * y }
    println("Pass 10, 11 to intLambda: ${intLambda(10, 11)}")

    val addSeven: (Int) -> Int = { it + 7 }
    println("Pass 12 to addSeven: ${addSeven(12)}")

    val myLambda: () -> Unit = { println("Hi") }
    myLambda()

    convert(20.0) { c: Double -> c * 1.8 + 32 }
    convertFive { it * 1.8 + 32 }

    val pounds = getConversionLambda("KgsToPounds")(2.5)
    println(pounds)

    convert(20.0, getConversionLambda("CentigradeToFahrenheit"))

    val kgsToPounds = { x: Double -> x * 2.204623 }
    val poundsToUSTons = { x: Double -> x / 2000.0 }
    val kgsToUSTons = combine(kgsToPounds, poundsToUSTons)
    val usTons = kgsToUSTons(1000.0)
}

fun convert(x: Double, converter: (Double) -> Double): Double {
    val result = converter(x)
    println("$x is converted to $result")
    return result
}

fun convertFive(converter: (Int) -> Double): Double {
    val result = converter(5)
    println("5 is converted to $result")
    return result
}

fun getConversionLambda(str: String): (Double) -> Double {
    return when (str) {
        "CentigradeToFahrenheit" -> {
            { it * 1.8 + 32 }
        }
        "KgsToPounds" -> {
            { it * 2.204623 }
        }
        "PoundsToUSTons" -> {
            { it / 2000.0 }
        }
        else -> {
            { it }
        }
    }
}

fun combine(lambda1: (Double) -> Double, lambda2: (Double) -> Double): (Double) -> Double {
    return { x: Double -> lambda2(lambda1(x)) }
}
