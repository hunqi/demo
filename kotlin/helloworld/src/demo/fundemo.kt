package demo

// fun definition way 1
/*fun sum(a: Int, b: Int): Int {
    return a + b
}*/

// fun definition way 2
fun sum(a: Int, b: Int) = a + b

public fun sub(a: Int, b: Int) = b - a

fun vars(vararg v: Int){
    for(vt in v)
        print(vt)
    println()
}

fun main(args: Array<String>) {
    println("sum(1, 2)=" + sum(1, 2))
    println("sub(3, 8)=" + sub(3, 8))
    vars(1,2,3,4,5)
}