package kr.hs.dgsw.dohyunwook.domain

data class Character(
    val id: String,
    val name: String,
    val gender: String,
    val age: String,
    val job: String,
    val character: String,
    val profile_image_url: String,
    val relation: List<Relation>
)
