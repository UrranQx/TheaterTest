@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package main
//Зрители в зале
/**
 * На вход подаётся изменяемый список places, содержащий информацию
 * о состоянии мест в зале в следующем виде: i-ый элемент списка
 * описывает состояние мест в i-ом ряду в зале.
 * Состояние мест в ряду также представлено списком, содержащим true,
 * если место занято, и false если свободно.
 *
 * Например:
 * [[true,false,false,false,true,false],[true,false,true,false]]
 *
 * Также, на вход подаётся ассоциативный массив requests, содержащий
 * информацию о запросах на места. Ключ это идентификатор зрителя,
 * а значение это пара из номера ряда и количества заказанных мест.
 *
 * Например:
 * {"Вася" = (0, 2), "Петя" = (1, 1)}
 * В примере Вася хочет 2 места в ряду 0, а Петя одно место в ряду 1.
 *
 * Необходимо каждому зрителю найти необходимое количество мест в зале
 * и зарезервировать их. Места могут располагаться НЕ рядом.
 * Требуется вернуть для каждого зрителя список зарезервированных
 * для него мест, а также внести изменения в переданный
 * на вход список, содержащий информацию о состоянии мест в зале.
 *
 * Если какому-либо из зрителей невозможно выделить необходимое
 * количество мест требуется выбросить IllegalStateException.
 *
 * Для данных из примера результат работы может быть следующим:
 * Зарезервированные места:
 * {"Вася" = [1, 5], "Петя" = [3]}
 * Изменённый список с информацией о местах:
 * [[true,true,false,false,true,true],[true,false,true,true]]
 *
 * Имя функции и тип результата функции предложить самостоятельно;
 * в задании указан тип Collection<Any>, то есть коллекция объектов
 * произвольного типа, можно (и нужно) изменить как вид коллекции,
 * так и тип её элементов.
 * Кроме функции, следует написать тесты,
 * подтверждающие её работоспособность.
 *
 * fun myFun(places: MutableList<MutableList<Boolean>>,
 *    requests: Map<String, Pair<Int, Int>>): Collection<Any> = TODO()

 */
val places =
    mutableListOf(mutableListOf(true, false, false, false, true, false), mutableListOf(true, false, true, false))
val requests = mapOf("Вася" to Pair(0, 2), "Петя" to Pair(1, 1))

fun main() {
    //println(places[0].filter { !it }.size)
    //println(switcher(mutableListOf(true, false, false, false, true, false), 2))
    println(requests)
    println(places)
    println(theater(places, requests))
    println(places)
}

/*fun switcher(row: MutableList<Boolean>, n: Int): MutableList<Boolean> {
    var c = 0
    for (i in row.indices) {
        if (c > n) break
        if (!row[i]) row[i] = true
        c++
    }
    return row
}*/

fun theater(
    places: MutableList<MutableList<Boolean>>,
    requests: Map<String, Pair<Int, Int>>
): MutableMap<String, List<Int>> {

    val ansMap = mutableMapOf<String, List<Int>>()
    for ((key, value) in requests) {
        val row = value.first
        val seats = value.second
        if (places[row].filter { !it }.size < seats) throw IllegalStateException()
        val preservedSeats = mutableListOf<Int>()
        //Заносим в список и
        // заменяем false N раз в places[row] на true
        var c = 0
        for (i in places[row].indices) {
            if (c >= seats) break // алтренатива if (c == seats) break
            if (!places[row][i]) {
                preservedSeats.add(i) // заносим в список
                places[row][i] = true
                c++// меняем значение
            }

        }
        ansMap[key] = preservedSeats
        // В случае того, что Банда Мышей зарезервирует не один ряд, а два? инпут вида "X to Pair(i,n), X to Pair(j,m)?
        // Тогда
    }
    return ansMap
}
/*
fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}*/
