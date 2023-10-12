package kr.hs.dgsw.dohyunwook.domain

data class MainCharacter(
    val species: String?,
    val species_explain: String?,
    val style: String?,
    val name: String?,
    val gender: String?,
    val age: String?,
    val character: String?,
    val background_story: String?
) : java.io.Serializable

/*
* "species": "인간",
        "species_explain": "착함",
        "style": "2D",
        "name": "라이언",
        "gender": "남성",
        "age": "30",
        "character": "명령적인 성격",
        "background_story": "평범한 직장인이였던 라이언은 가족을 모두 읽고 아포칼립스 세상에서 살아가게된다."
*/