package com.kids.constants

import com.kids.common.data.AreaData
import okhttp3.internal.immutableListOf


fun getSidoCode(sido: String): String =
    areaData.filter { it.sidoName == sido }
        .map { it.sidoCode }.distinct()[0]

fun getSggCode(sido: String, sgg: String): String =
    areaData.filter { it.sidoName == sido && it.sggName == sgg }
        .map { it.sggCode }.distinct()[0]

val areaData = immutableListOf(
    AreaData("서울특별시", "11", "중구", "11140"),
    AreaData("서울특별시", "11", "영등포구", "11560"),
    AreaData("서울특별시", "11", "중랑구", "11260"),
    AreaData("서울특별시", "11", "은평구", "11380"),
    AreaData("서울특별시", "11", "금천구", "11545"),
    AreaData("서울특별시", "11", "동작구", "11590"),
    AreaData("서울특별시", "11", "강남구", "11680"),
    AreaData("서울특별시", "11", "종로구", "11110"),
    AreaData("서울특별시", "11", "용산구", "11170"),
    AreaData("서울특별시", "11", "광진구", "11215"),
    AreaData("서울특별시", "11", "양천구", "11470"),
    AreaData("서울특별시", "11", "관악구", "11620"),
    AreaData("서울특별시", "11", "서대문구", "11410"),
    AreaData("서울특별시", "11", "마포구", "11440"),
    AreaData("서울특별시", "11", "성동구", "11200"),
    AreaData("서울특별시", "11", "강북구", "11305"),
    AreaData("서울특별시", "11", "서초구", "11650"),
    AreaData("서울특별시", "11", "송파구", "11710"),
    AreaData("서울특별시", "11", "강동구", "11740"),
    AreaData("서울특별시", "11", "성북구", "11290"),
    AreaData("서울특별시", "11", "도봉구", "11320"),
    AreaData("서울특별시", "11", "노원구", "11350"),
    AreaData("서울특별시", "11", "강서구", "11500"),
    AreaData("서울특별시", "11", "구로구", "11530"),
    AreaData("서울특별시", "11", "동대문구", "11230"),
    AreaData("경기도", "41", "수원시 장안구", "41111"),
    AreaData("경기도", "41", "파주시", "41480"),
    AreaData("경기도", "41", "의정부시", "41150"),
    AreaData("경기도", "41", "남양주시", "41360"),
    AreaData("경기도", "41", "오산시", "41370"),
    AreaData("경기도", "41", "시흥시", "41390"),
    AreaData("경기도", "41", "용인시 처인구", "41461"),
    AreaData("경기도", "41", "부천시", "41190"),
    AreaData("경기도", "41", "부천시 소사구", "41197"),
    AreaData("경기도", "41", "안성시", "41550"),
    AreaData("경기도", "41", "화성시", "41590"),
    AreaData("경기도", "41", "김포시", "41570"),
    AreaData("경기도", "41", "여주시", "41670"),
    AreaData("경기도", "41", "수원시 팔달구", "41115"),
    AreaData("경기도", "41", "수원시 영통구", "41117"),
    AreaData("경기도", "41", "안양시 동안구", "41173"),
    AreaData("경기도", "41", "광명시", "41210"),
    AreaData("경기도", "41", "평택시", "41220"),
    AreaData("경기도", "41", "안산시 상록구", "41271"),
    AreaData("경기도", "41", "안산시 단원구", "41273"),
    AreaData("경기도", "41", "양주시", "41630"),
    AreaData("경기도", "41", "연천군", "41800"),
    AreaData("경기도", "41", "수원시", "41110"),
    AreaData("경기도", "41", "동두천시", "41250"),
    AreaData("경기도", "41", "용인시 기흥구", "41463"),
    AreaData("경기도", "41", "포천시", "41650"),
    AreaData("경기도", "41", "양평군", "41830"),
    AreaData("경기도", "41", "안양시", "41170"),
    AreaData("경기도", "41", "의왕시", "41430"),
    AreaData("경기도", "41", "성남시", "41130"),
    AreaData("경기도", "41", "성남시 수정구", "41131"),
    AreaData("경기도", "41", "하남시", "41450"),
    AreaData("경기도", "41", "광주시", "41610"),
    AreaData("경기도", "41", "가평군", "41820"),
    AreaData("경기도", "41", "수원시 권선구", "41113"),
    AreaData("경기도", "41", "성남시 분당구", "41135"),
    AreaData("경기도", "41", "고양시 일산서구", "41287"),
    AreaData("경기도", "41", "과천시", "41290"),
    AreaData("경기도", "41", "구리시", "41310"),
    AreaData("경기도", "41", "군포시", "41410"),
    AreaData("경기도", "41", "용인시 수지구", "41465"),
    AreaData("경기도", "41", "이천시", "41500"),
    AreaData("경기도", "41", "안양시 만안구", "41171"),
    AreaData("경기도", "41", "고양시 덕양구", "41281"),
    AreaData("경기도", "41", "고양시 일산동구", "41285"),
    AreaData("경기도", "41", "성남시 중원구", "41133"),
    AreaData("강원도", "42", "삼척시", "42230"),
    AreaData("강원도", "42", "영월군", "42750"),
    AreaData("강원도", "42", "고성군", "42820"),
    AreaData("강원도", "42", "춘천시", "42110"),
    AreaData("강원도", "42", "태백시", "42190"),
    AreaData("강원도", "42", "양구군", "42800"),
    AreaData("강원도", "42", "인제군", "42810"),
    AreaData("강원도", "42", "양양군", "42830"),
    AreaData("강원도", "42", "홍천군", "42720"),
    AreaData("강원도", "42", "정선군", "42770"),
    AreaData("강원도", "42", "강릉시", "42150"),
    AreaData("강원도", "42", "동해시", "42170"),
    AreaData("강원도", "42", "속초시", "42210"),
    AreaData("강원도", "42", "횡성군", "42730"),
    AreaData("강원도", "42", "평창군", "42760"),
    AreaData("강원도", "42", "화천군", "42790"),
    AreaData("강원도", "42", "원주시", "42130"),
    AreaData("강원도", "42", "철원군", "42780"),
    AreaData("인천광역시", "28", "미추홀구", "28177"),
    AreaData("인천광역시", "28", "강화군", "28710"),
    AreaData("인천광역시", "28", "동구", "28140"),
    AreaData("인천광역시", "28", "옹진군", "28720"),
    AreaData("인천광역시", "28", "부평구", "28237"),
    AreaData("인천광역시", "28", "남동구", "28200"),
    AreaData("인천광역시", "28", "계양구", "28245"),
    AreaData("인천광역시", "28", "서구", "28260"),
    AreaData("인천광역시", "28", "연수구", "28185"),
    AreaData("인천광역시", "28", "중구", "28110"),
    AreaData("광주광역시", "29", "북구", "29170"),
    AreaData("광주광역시", "29", "서구", "29140"),
    AreaData("광주광역시", "29", "남구", "29155"),
    AreaData("광주광역시", "29", "광산구", "29200"),
    AreaData("광주광역시", "29", "동구", "29110"),
    AreaData("대전광역시", "30", "대덕구", "30230"),
    AreaData("대전광역시", "30", "동구", "30110"),
    AreaData("대전광역시", "30", "서구", "30170"),
    AreaData("대전광역시", "30", "중구", "30140"),
    AreaData("대전광역시", "30", "유성구", "30200"),
    AreaData("울산광역시", "31", "중구", "31110"),
    AreaData("울산광역시", "31", "동구", "31170"),
    AreaData("울산광역시", "31", "남구", "31140"),
    AreaData("울산광역시", "31", "울주군", "31710"),
    AreaData("울산광역시", "31", "북구", "31200"),
    AreaData("세종특별자치시", "36", "세종특별자치시", "36110"),
    AreaData("충청북도", "43", "제천시", "43150"),
    AreaData("충청북도", "43", "괴산군", "43760"),
    AreaData("충청북도", "43", "보은군", "43720"),
    AreaData("충청북도", "43", "청주시 상당구", "43111"),
    AreaData("충청북도", "43", "청주시 청원구", "43114"),
    AreaData("충청북도", "43", "영동군", "43740"),
    AreaData("충청북도", "43", "청주시 흥덕구", "43113"),
    AreaData("충청북도", "43", "증평군", "43745"),
    AreaData("충청북도", "43", "음성군", "43770"),
    AreaData("충청북도", "43", "단양군", "43800"),
    AreaData("충청북도", "43", "충주시", "43130"),
    AreaData("충청북도", "43", "옥천군", "43730"),
    AreaData("충청북도", "43", "청주시 서원구", "43112"),
    AreaData("충청북도", "43", "진천군", "43750"),
    AreaData("충청남도", "44", "보령시", "44180"),
    AreaData("충청남도", "44", "홍성군", "44800"),
    AreaData("충청남도", "44", "천안시 동남구", "44131"),
    AreaData("충청남도", "44", "서산시", "44210"),
    AreaData("충청남도", "44", "논산시", "44230"),
    AreaData("충청남도", "44", "청양군", "44790"),
    AreaData("충청남도", "44", "아산시", "44200"),
    AreaData("충청남도", "44", "부여군", "44760"),
    AreaData("충청남도", "44", "천안시 서북구", "44133"),
    AreaData("충청남도", "44", "태안군", "44825"),
    AreaData("충청남도", "44", "계룡시", "44250"),
    AreaData("충청남도", "44", "당진시", "44270"),
    AreaData("충청남도", "44", "예산군", "44810"),
    AreaData("충청남도", "44", "공주시", "44150"),
    AreaData("충청남도", "44", "금산군", "44710"),
    AreaData("충청남도", "44", "서천군", "44770"),
    AreaData("충청남도", "45", "정읍시", "45180"),
    AreaData("충청남도", "45", "고창군", "45790"),
    AreaData("충청남도", "45", "임실군", "45750"),
    AreaData("충청남도", "45", "전주시 완산구", "45111"),
    AreaData("충청남도", "45", "군산시", "45130"),
    AreaData("충청남도", "45", "순창군", "45770"),
    AreaData("충청남도", "45", "부안군", "45800"),
    AreaData("충청남도", "45", "전주시 덕진구", "45113"),
    AreaData("충청남도", "45", "익산시", "45140"),
    AreaData("충청남도", "45", "완주군", "45710"),
    AreaData("충청남도", "45", "장수군", "45740"),
    AreaData("충청남도", "45", "진안군", "45720"),
    AreaData("충청남도", "45", "김제시", "45210"),
    AreaData("충청남도", "45", "남원시", "45190"),
    AreaData("충청남도", "45", "무주군", "45730"),
    AreaData("전라북도", "46", "목포시", "46110"),
    AreaData("전라북도", "46", "장성군", "46880"),
    AreaData("전라북도", "46", "완도군", "46890"),
    AreaData("전라북도", "46", "구례군", "46730"),
    AreaData("전라북도", "46", "여수시", "46130"),
    AreaData("전라북도", "46", "나주시", "46170"),
    AreaData("전라북도", "46", "화순군", "46790"),
    AreaData("전라북도", "46", "영광군", "46870"),
    AreaData("전라북도", "46", "담양군", "46710"),
    AreaData("전라북도", "46", "곡성군", "46720"),
    AreaData("전라북도", "46", "고흥군", "46770"),
    AreaData("전라북도", "46", "장흥군", "46800"),
    AreaData("전라북도", "46", "무안군", "46840"),
    AreaData("전라북도", "46", "보성군", "46780"),
    AreaData("전라북도", "46", "해남군", "46820"),
    AreaData("전라북도", "46", "광양시", "46230"),
    AreaData("전라북도", "46", "영암군", "46830"),
    AreaData("전라북도", "46", "신안군", "46910"),
    AreaData("전라북도", "46", "강진군", "46810"),
    AreaData("전라북도", "46", "진도군", "46900"),
    AreaData("전라북도", "46", "함평군", "46860"),
    AreaData("전라북도", "46", "순천시", "46150"),
    AreaData("경상북도", "47", "구미시", "47190"),
    AreaData("경상북도", "47", "성주군", "47840"),
    AreaData("경상북도", "47", "영덕군", "47770"),
    AreaData("경상북도", "47", "고령군", "47830"),
    AreaData("경상북도", "47", "칠곡군", "47850"),
    AreaData("경상북도", "47", "예천군", "47900"),
    AreaData("경상북도", "47", "울진군", "47930"),
    AreaData("경상북도", "47", "봉화군", "47920"),
    AreaData("경상북도", "47", "포항시 남구", "47111"),
    AreaData("경상북도", "47", "영주시", "47210"),
    AreaData("경상북도", "47", "경산시", "47290"),
    AreaData("경상북도", "47", "군위군", "47720"),
    AreaData("경상북도", "47", "청송군", "47750"),
    AreaData("경상북도", "47", "청도군", "47820"),
    AreaData("경상북도", "47", "울릉군", "47940"),
    AreaData("경상북도", "47", "경주시", "47130"),
    AreaData("경상북도", "47", "김천시", "47150"),
    AreaData("경상북도", "47", "안동시", "47170"),
    AreaData("경상북도", "47", "상주시", "47250"),
    AreaData("경상북도", "47", "문경시", "47280"),
    AreaData("경상북도", "47", "의성군", "47730"),
    AreaData("경상북도", "47", "영양군", "47760"),
    AreaData("경상북도", "47", "포항시", "47110"),
    AreaData("경상북도", "47", "영천시", "47230"),
    AreaData("경상북도", "47", "포항시 북구", "47113"),
    AreaData("경상남도", "48", "거제시", "48310"),
    AreaData("경상남도", "48", "양산시", "48330"),
    AreaData("경상남도", "48", "창녕군", "48740"),
    AreaData("경상남도", "48", "고성군", "48820"),
    AreaData("경상남도", "48", "함양군", "48870"),
    AreaData("경상남도", "48", "사천시", "48240"),
    AreaData("경상남도", "48", "의령군", "48720"),
    AreaData("경상남도", "48", "산청군", "48860"),
    AreaData("경상남도", "48", "합천군", "48890"),
    AreaData("경상남도", "48", "창원시 의창구", "48121"),
    AreaData("경상남도", "48", "통영시", "48220"),
    AreaData("경상남도", "48", "밀양시", "48270"),
    AreaData("경상남도", "48", "하동군", "48850"),
    AreaData("경상남도", "48", "거창군", "48880"),
    AreaData("경상남도", "48", "창원시", "48120"),
    AreaData("경상남도", "48", "창원시 마산회원구", "48127"),
    AreaData("경상남도", "48", "진주시", "48170"),
    AreaData("경상남도", "48", "함안군", "48730"),
    AreaData("경상남도", "48", "남해군", "48840"),
    AreaData("경상남도", "48", "창원시 성산구", "48123"),
    AreaData("경상남도", "48", "창원시 마산합포구", "48125"),
    AreaData("경상남도", "48", "창원시 진해구", "48129"),
    AreaData("경상남도", "48", "김해시", "48250"),
    AreaData("부산광역시", "26", "부산진구", "26230"),
    AreaData("부산광역시", "26", "사상구", "26530"),
    AreaData("부산광역시", "26", "서구", "26140"),
    AreaData("부산광역시", "26", "연제구", "26470"),
    AreaData("부산광역시", "26", "사하구", "26380"),
    AreaData("부산광역시", "26", "강서구", "26440"),
    AreaData("부산광역시", "26", "중구", "26110"),
    AreaData("부산광역시", "26", "동래구", "26260"),
    AreaData("부산광역시", "26", "수영구", "26500"),
    AreaData("부산광역시", "26", "동구", "26170"),
    AreaData("부산광역시", "26", "금정구", "26410"),
    AreaData("부산광역시", "26", "남구", "26290"),
    AreaData("부산광역시", "26", "영도구", "26200"),
    AreaData("부산광역시", "26", "해운대구", "26350"),
    AreaData("부산광역시", "26", "기장군", "26710"),
    AreaData("부산광역시", "26", "북구", "26320"),
    AreaData("대구광역시", "27", "달성군", "27710"),
    AreaData("대구광역시", "27", "남구", "27200"),
    AreaData("대구광역시", "27", "서구", "27170"),
    AreaData("대구광역시", "27", "달서구", "27290"),
    AreaData("대구광역시", "27", "수성구", "27260"),
    AreaData("대구광역시", "27", "중구", "27110"),
    AreaData("대구광역시", "27", "북구", "27230"),
    AreaData("대구광역시", "27", "동구", "27140"),
    AreaData("제주특별자치도", "50", "서귀포시", "50130"),
    AreaData("제주특별자치도", "50", "제주시", "50110")
)

