package kr.hs.dgsw.dohyunwook.domain

import java.io.Serializable

data class RequestMakeCharacter(
    val character_count: Int,
    val world_story: String,
    val main_character: MainCharacter?,

) : Serializable
