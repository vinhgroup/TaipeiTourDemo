// To parse the JSON, install Klaxon and do:
//
//   val dataInfor = DataInfor.fromJson(jsonString)

package quicktype

import Imagex
import com.beust.klaxon.*

private fun <T> Klaxon.convert(k: kotlin.reflect.KClass<*>, fromJson: (JsonValue) -> T, toJson: (T) -> String, isUnion: Boolean = false) =
    this.converter(object: Converter {
        @Suppress("UNCHECKED_CAST")
        override fun toJson(value: Any)        = toJson(value as T)
        override fun fromJson(jv: JsonValue)   = fromJson(jv) as Any
        override fun canConvert(cls: Class<*>) = cls == k.java || (isUnion && cls.superclass == k.java)
    })

private val klaxon = Klaxon()


data class DataInfor (
    val total: Long,
    val data: List<Datum>
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<DataInfor>(json)
    }
}

data class Datum (
    val id: Long,
    val name: String,

    @Json(name = "name_zh")
    val name_zh: Any? = null,

    @Json(name = "open_status")
    val open_status: Long,

    val introduction: String,

    @Json(name = "open_time")
    val open_time: String,

    val zipcode: String,
    val distric: String,
    val address: String,
    val tel: String,
    val fax: String,
    val email: String,
    val months: String,
    val nlat: Double,
    val elong: Double,

    @Json(name = "official_site")
    val official_site: String,

    val facebook: String,
    val ticket: String,
    val remind: String,
    val staytime: String,
    val modified: String,
    val url: String,
    @Json(name = "images")
    val images: List<Imagex>,
    val category: List<Category>,
    val target: List<Category>,
    val service: List<Category>,
    val friendly: List<Any?>,
    val files: List<Any?>,
    val links: List<Link>
)

data class Category (
    val id: Long,
    val name: String
)

data class Link (
    val src: String,
    val subject: String
)




