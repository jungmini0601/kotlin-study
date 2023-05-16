fun main() {
    ex19()
}

fun ex19() {
    val ret = listOf(1, 2, 3, 4, 5).reduce{acc, y -> acc * y}
    println(ret)
}

fun ex18() {
    class Score(val name:String, val kor: Int, val eng: Int)

    val ret = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).sum()
    val ret2 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).sumOf{it.toLong()} // 오버플로우 해결 가능

    val scores = listOf(Score("test1", 100, 70), Score("test2", 50, 50))

    val korSum = scores.sumOf { it.kor }
    val engSum = scores.sumOf { it.eng }

    println(korSum)
    println(engSum)
}

fun ex17() {
    val chars = "This is an example of sentence".split(" ")
        .flatMap { it.toList() }
    println(chars)
}

fun ex16() {
    arrayOf(1, 2, 3, 4, 5).indexOf(1) // 0
    arrayOf(1, 2, 3, 4, 5).indexOf(2222) // -1
    arrayOf(1, 2, 3, 4, 5).indexOfFirst { it >= 4 }
}

fun ex15() {
    fun generateOrNull(x: Int) = if(x % 2 == 0) null else x * 2
    println(intArrayOf(1, 2, 3, 4, 5).map { generateOrNull(it) }.filterNotNull())
}

fun ex14() {
    println(intArrayOf(1, 2, 3, 4, 5).filterIndexed { index, _ -> index % 2 == 0})
    println(arrayOf(1, 2, 3, 4, 5).filterIndexed { index, _ -> index % 2 == 0})
    println(listOf(1, 2, 3, 4, 5).filterIndexed { index, _ -> index % 2 == 0})
    println(setOf(1, 2, 3, 4, 5).filterIndexed { index, _ -> index % 2 == 0})
}

fun ex13() {
    println(arrayOf(1, 2, 3, 4, 5).filter { it % 2 == 0 })
    println(listOf(1, 2, 3, 4, 5).filterNot { it % 2 == 0 })
    println(setOf(1, 2, 3, 4, 5).filter { it % 2 == 0 })

    val map = mapOf(1 to "one", 2 to "two", 3 to "three")
    println(map.filter { it.value.startsWith("t") })
}

fun ex12() {
    val emptyMap = mapOf<Int, String>()
    val map = mapOf("a" to 1, "b" to 2)
    val mutableMap = mutableMapOf("a" to 1, "b" to 2)

    val m = mapOf(1 to 1, 1 to 2) // 1 = 2 가 저장된다.

    for(entry in m) {
        println("${entry.key} ${entry.value}")
    }

    mutableMap["abc"] = 1234
    val x = mutableMap.put("abc", 2222) // 1234
    mutableMap.putAll(mapOf("123" to 123, "1234" to 1234))
}

fun ex11() {
    val set = sortedSetOf("a", "c", "b", "aa")
    for(m in set) println(m) // 정렬 되어 출력

    val reverseSet = sortedSetOf(Comparator{a, b -> b.compareTo(a)}, "a", "c" ,"b", "aa")
    for(m in reverseSet) println(m) // 정렬 되어 출력
}

fun ex10() {
    val intSet1 = setOf(1, 2, 3)
    val mutableSetOf = mutableSetOf(1, 2, 3)

    // set은 []로 접근 불가능
    intSet1.first()
    intSet1.last()

    println(0 in intSet1)
    println(0 !in intSet1)

    mutableSetOf.add(1)
    mutableSetOf.addAll(setOf(5,6,7,8,9))

    mutableSetOf.remove(0)
    mutableSetOf.remove(1)
}

fun ex9() {
    val l = listOf(*setOf(1,2,3,4,5).toTypedArray())
    println(l)
}

fun ex8() {
    // JVM환경에서만 돌아간다.
    val linkedList = java.util.LinkedList<Int>()
    val linkedList2 = java.util.LinkedList<Int>(setOf(1, 2, 3, 4, 5))

    println(linkedList2)
}

fun ex7() {
    val list = arrayListOf(1, 2, 3)
    list[1] = 100

    val arrayList1 = ArrayList<Int>() // 기본생성자
    val arrayList2 = ArrayList<Int>(10) // 초기 사이즈 10인 배열 생성
    val arrayList3 = ArrayList(setOf(1,2,3,4,5)) // [1,2,3,4,5]

    println(arrayList3)
}

fun ex6() {
    val intList1 = listOf(1, 2, 3)
    val intList2 = mutableListOf(1, 2, 3)

    val stringList1 = listOf("a", "b", "c")
    val stringList2 = mutableListOf("a", "b", "c")

    intList2.remove(0)
    intList2.removeAll(listOf(1, 2))
    intList2.removeLast()
    intList2.removeFirst()
}

fun ex5() {
    val intList1 = listOf(1, 2, 3)
    val intList2 = mutableListOf(1, 2, 3)

    val stringList1 = listOf("a", "b", "c")
    val stringList2 = mutableListOf("a", "b", "c")

    println(intList1[0])
    println(intList1[1])
    println(intList1[2])
    //println(intList1[3]) Error

    println(stringList1.first())
    println(stringList1.last())

    println(1 in intList1)
    println(100 in intList1)
    println(100 !in intList1)

    println(stringList1.containsAll(listOf("a", "b")))
    println(stringList1.containsAll(listOf("a", "b", "c", "d")))
}

fun ex4() {
    val names = Iterable {
        iterator {
            yield("111")
            yield("222")
            yield("333")
        }
    }

    names.forEachIndexed { index, value -> println("${index} ${value}") }
}

fun ex3() {
    val iter = iterator {
        yield(1)
        yield(2)
        yield(3)
        yield(4)
        yield(5)
    }

    iter.forEach { println(it) }
}

fun ex2() {
    // 이터러블 손쉽게 만들기
    class IterMaker: Iterable<Int>  {
        override fun iterator(): Iterator<Int> = iterator {
            (1..5).forEach{yield(it)}
        }
    }

    val iterable = IterMaker()
    for(value in iterable) {
        println(value)
    }
}

fun ex1() {
    // 이터레이터 생성 하는 방법 자바스크립트의 제너레이터와 비슷
    val generator = iterator {
        yield(1)
        yield(2)
        yield(3)
        yield(4)
        yield(5)
    }

    for(elem in generator) {
        println(elem)
    }
}