package kr.hs.dgsw.dohyunwook.domain

data class MainCharacter(
    val name: String?,
    val gender: String?,
    val age: String?,
    val species: String?,
    val species_explain: String?,
    val style: String?,
    val character: String?,
    val background_story: String?
) : java.io.Serializable
