package example

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DateUtils {
    /**
     * String을 LocalDate로 변경
     */
    fun convertStringToLocalDate(date: String): LocalDate {
        return LocalDate.parse(date)
    }
    /**
     * DateFormatter을 지정하여 String을 LocalDate로 변경
     */
    fun convertStringToLocalDateDateFormat(date:String, dateTimeFormatter: DateTimeFormatter): LocalDate {
        return LocalDate.parse(date, dateTimeFormatter)
    }

    /**
     * 현재 시간을 LocalDate로 만들기
     */
    fun convertNowToLocalDate(): LocalDate {
        return LocalDate.now()
    }

}

fun main() {
    val dateUtils = DateUtils()
    val dateParse = dateUtils.convertStringToLocalDate("2012-11-08")
    val dateFormatParse = dateUtils.convertStringToLocalDateDateFormat("2021-11-08", DateTimeFormatter.ISO_DATE)

    println(dateParse.javaClass)
    println(dateFormatParse)
    println(dateUtils.convertNowToLocalDate())

}