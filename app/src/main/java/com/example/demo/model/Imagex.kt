import com.beust.klaxon.Json

data class Imagex(
    @Json(name = "src")
    val src: String,
    @Json(name = "subject")
    val subject: String,
    @Json(name = "ext")
    val ext: String
)