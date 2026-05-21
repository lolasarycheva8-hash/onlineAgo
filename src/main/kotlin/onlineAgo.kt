fun minuteForm(minutes: Int): String {
    val lastTwo = minutes % 100
    val lastOne = minutes % 10
    return when {
        lastTwo in 11..14 -> "минут"
        lastOne == 1      -> "минуту"
        lastOne in 2..4   -> "минуты"
        else              -> "минут"
    }
}

fun hourForm(hours: Int): String {
    val lastTwo = hours % 100
    val lastOne = hours % 10
    return when {
        lastTwo in 11..20 -> "часов"
        lastOne == 1      -> "час"
        lastOne in 2..4   -> "часа"
        else              -> "часов"
    }
}

fun agoToText(seconds: Int): String {
    val minute = 60
    val hour   = 60 * 60
    val day    = 24 * 60 * 60

    return when {
        seconds <= minute      -> "был(а) только что"
        seconds <= hour        -> {
            val minutes = seconds / minute
            "был(а) $minutes ${minuteForm(minutes)} назад"
        }
        seconds <= day         -> {
            val hours = seconds / hour
            "был(а) $hours ${hourForm(hours)} назад"
        }
        seconds <= 2 * day     -> "был(а) вчера"
        seconds <= 3 * day     -> "был(а) позавчера"
        else                   -> "был(а) давно"
    }
}

fun main() {
    println(agoToText(175))           // только что
    println(agoToText(61))           // 1 минуту назад
    println(agoToText(130))          // 2 минуты назад
    println(agoToText(660))          // 11 минут назад
    println(agoToText(1260))         // 21 минуту назад
    println(agoToText(3601))         // 1 час назад
    println(agoToText(7200))         // 2 часа назад
    println(agoToText(18000))        // 5 часов назад
    println(agoToText(75600))        // 21 час назад
    println(agoToText(90000))        // вчера
    println(agoToText(180000))       // позавчера
    println(agoToText(300))       // давно
}