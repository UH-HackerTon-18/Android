package kr.hs.dgsw.dohyunwook.domain

data class ResponseGetInfoById(
    val character: List<ResponseGetInfoByWorkldID>
)

/*
{
	"id": "a3gD353d",
	"name" : "안나(Anna)",
  "gender": "FEMALE",
	"age": "30대 중반이지만 실제 연령보다 젊어보입니다.",
	"job": "전직 기자",
  "character": "다정함"
	"relation": [
        {
            "id": "a3gD353d",
            "name": "브레이든와 리사",
            "explain": "동료"
        }
    ]
}
 */