package kr.hs.dgsw.dohyunwook.domain

import java.io.Serializable

data class RequestMakeCharacter(
    val world_story: String,
    val main_character: MainCharacter?,
    val character_count: Int,
) : Serializable
