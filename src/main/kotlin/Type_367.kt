fun main() {
    var lambda1: (Double) -> Int
    var lambda2: (Int) -> Double = { it + 7.1 }
    var lambda3: (Int) -> Int = { x: Int -> x + 56 }
    var lambda4: (Double) -> Unit = { println("Hello!") }
//    var lambda5
}

/*
1 -> 5 -
2 -> 1 +
3 -> 3 +- | +2
4 -> 4 +- | +1,2,3,5
5 -> 2 -  | 3,4,5
 */