fun main() {


    val addFive1 = { x: Int -> x + 5 }
    val addInts = { x: Int, y: Int -> x + y }
    val addInts2 = { x: Int, y: Int ->
        x + y
        x * 2
    }

    val result1 = addInts.invoke(6, 7)
    val result2 = addInts(6, 7)
    println(addInts2(2, 3))

    val add: (Int, Int) -> Int
    add = { x: Int, y: Int -> x + y }

    val greeting: () -> String
    greeting = { "Hello!" }


    val addFive2: (Int) -> Int = { x -> x + 5 }
    val addFive3: (Int) -> Int = { it + 5 }
}