package com.github.lincolnstuart.desafiointegradorapimarvel.model.comic

import android.annotation.SuppressLint
import android.os.Parcelable
import com.github.lincolnstuart.desafiointegradorapimarvel.util.Constants.Pattern.JSON_INPUT_DATE
import com.github.lincolnstuart.desafiointegradorapimarvel.util.Constants.Pattern.OUTPUT_DATE
import kotlinx.android.parcel.Parcelize
import java.text.SimpleDateFormat

@Parcelize
data class Date(
    val date: String,
    val type: String
) : Parcelable {

    fun formatted(): String {
//        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            modernWayToConvertADate()
//        } else {
//            oldAndFilthWayToConvertADate()
//        }
        return oldAndFilthWayToConvertADate()
    }

//    @RequiresApi(Build.VERSION_CODES.O)
//    private fun modernWayToConvertADate() =
//        LocalDateTime.parse(date)
//            .toLocalDate()
//            .format(
//                DateTimeFormatter
//                    .ofLocalizedDateTime(FormatStyle.LONG)
//                    .withLocale(Locale.US)
//            )

    @SuppressLint("SimpleDateFormat")
    private fun oldAndFilthWayToConvertADate(): String {
        val inputFormat = SimpleDateFormat(JSON_INPUT_DATE)
        val outputFormat = SimpleDateFormat(OUTPUT_DATE)
        return date.split("T").firstOrNull()?.let{string ->
            val javaDate = inputFormat.parse(string)
            return javaDate?.let {
                outputFormat.format(it)
            } ?: date
        } ?: date
    }

}