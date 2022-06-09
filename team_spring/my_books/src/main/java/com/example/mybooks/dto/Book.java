package com.example.mybooks.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

	// 신간 0, 베스트 1, 둘다 아니면 2
	private Integer id;

	// 1. 소설, 2. 추리, 3. 에세이, 4. 자기계발, 5.경제, 6. 기타, 7. 어린이
	private Integer thema;

	private String title;
	private String author;
	private Integer price;
	private String publicationDate; // 출간일
	private String publisher; // 출판사
	private Double rating;
	private String imageUrl;

	public static List<Book> sampleData() {
		ArrayList<Book> list = new ArrayList<>();
		list.add(new Book(1, 1, "작별인사", "김영하", 12600, "2022년 05월 02일", "복복서가", 9.7,
				"http://image.kyobobook.co.kr/images/book/xlarge/225/x9791191114225.jpg"));
		list.add(new Book(1, 7, "흔한남매 10", "백난도", 12150, "2022년 04월 28일", "미래엔아이세움", 9.8,
				"http://image.kyobobook.co.kr/images/book/xlarge/685/x9791168411685.jpg"));
		list.add(new Book(1, 1, "불편한 편의점(40만부 기념 벚꽃 에디션)", "김호연", 12600, "2021년 04월 20일", "나무옆의자", 9.8,
				"http://image.kyobobook.co.kr/images/book/xlarge/188/x9791161571188.jpg"));
		list.add(new Book(1, 6, "마음의 법칙", "김희상", 14400, "2022년 02월 10일", "포레스트북스", 9.5,
				"http://image.kyobobook.co.kr/images/book/xlarge/685/x9791191347685.jpg"));
		list.add(new Book(1, 3, "문재인의 위로", "더 휴먼 편집부", 14220, "2022년 05월 10일", "더 휴먼", 9.6,
				"http://image.kyobobook.co.kr/images/book/xlarge/676/x9791164455676.jpg"));
		list.add(new Book(1, 3, "기분을 관리하면 인생이 관리된다", "김다슬", 15840, "2022년 04월 12일", "클라우디아", 9.2,
				"http://image.kyobobook.co.kr/images/book/xlarge/127/x9791196617127.jpg"));
		list.add(new Book(1, 6, "무엇이 옳은가", "이경식", 16020, "2022년 04월 19일", "세계사", 9.5,
				"http://image.kyobobook.co.kr/images/book/xlarge/805/x9788933871805.jpg"));
		list.add(new Book(1, 4, "멘탈을 바꿔야 인생이 바뀐다", "박세니", 14220, "2022년 04월 30일", "마인드셋(Mindset)", 9.6,
				"http://image.kyobobook.co.kr/images/book/xlarge/761/x9791191043761.jpg"));
		list.add(new Book(1, 6, "컬러애 물들다", "최진선", 15120, "2022년 05월 11일", "리드리드출판", 9.8,
				"http://image.kyobobook.co.kr/images/book/xlarge/610/x9788972773610.jpg"));
		list.add(new Book(1, 7, "이상한 과자 가게 전천당 14", "김정화", 10800, "2022년 04월 25일", "길벗스쿨", 9.8,
				"http://image.kyobobook.co.kr/images/book/xlarge/243/x9791164064243.jpg"));
		list.add(new Book(1, 6, "이어령의 마지막 수업", "김지수, 이어령", 14850, "2021년 10월 28일", "열림원", 9.7,
				"http://image.kyobobook.co.kr/images/book/xlarge/523/x9791170400523.jpg"));
		list.add(new Book(1, 6, "인플레이션에서 살아남기", "오건영", 16920, "2022년 05월 23일", "페이지2북스", 9.4,
				"http://image.kyobobook.co.kr/images/book/xlarge/661/x9791190977661.jpg"));
		list.add(new Book(1, 6, "내가 틀릴 수도 있습니다", "박미경", 14400, "2022년 04월 18일", "다산초당", 9.7,
				"http://image.kyobobook.co.kr/images/book/xlarge/890/x9791130689890.jpg"));
		list.add(new Book(1, 1, "어서 오세요, 휴남동 서점입니다 (여름 숲 에디션)", "황보름", 13500, "2022년 01월 17일", "클레이하우스", 9.7,
				"http://image.kyobobook.co.kr/images/book/xlarge/143/x9791197377143.jpg"));
		list.add(new Book(1, 1, "2022 제13회 젊은작가상 수상작품집", "임솔라, 김멜라, 김병운, 김지연, 김혜진, 서수진, 서이제", 6930, "2022년 04월 08일",
				"문학동네", 9.7, "http://image.kyobobook.co.kr/images/book/xlarge/887/x9788954685887.jpg"));
		list.add(new Book(1, 6, "물고기는 존재하지 않는다", "정지인", 15300, "2021년 12월 17일", "곰출판", 9.2,
				"http://image.kyobobook.co.kr/images/book/xlarge/156/x9791189327156.jpg"));
		list.add(new Book(1, 5, "운명을 바꾸는 부동산 투자 수업: 기초편", "정태익", 15120, "2022년 03월 22일", "리더스북", 9.7,
				"http://image.kyobobook.co.kr/images/book/xlarge/307/x9788901259307.jpg"));
		list.add(new Book(1, 7, "둥실이네 떡집", "김리리", 9900, "2022년 04월 22일", "비룡소", 9.9,
				"http://image.kyobobook.co.kr/images/book/xlarge/188/x9788949162188.jpg"));
		list.add(new Book(1, 1, "어느 날, 내 죽음에 네가 들어왔다", "김윤경", 13500, "2022년 05월 09일", "모모", 9.7,
				"http://image.kyobobook.co.kr/images/book/xlarge/723/x9791191043723.jpg"));
		list.add(new Book(1, 5, "나의 투자는 새벽 4시에 시작된다", "유목민", 17820, "2022년 04월 15일", "리더스북", 9.3,
				"http://image.kyobobook.co.kr/images/book/xlarge/703/x9788901259703.jpg"));
		list.add(new Book(0, 6, "바프일기", "권헬린", 19800, "2022년 05월 30일", "헬린일기", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/305/x9791197810305.jpg"));
		list.add(new Book(0, 6, "세상에서 가장 짧은 한국사", "김재원 ", 16020, "2022년 06월 15일", "빅피시", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/404/x9791191825404.jpg"));
		list.add(new Book(0, 6, "엄마와 아이를 이어주는 따뜻한 무의식", "이무석 , 이인수", 14400, "2022년 06월 10일", "미류책방", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/053/x9791188632053.jpg"));
		list.add(new Book(0, 6, "교과서가 쉬워지는 주말여행(2022-2023)", "김수진, 박은하", 0, "2022년 05월 27일", "길벗", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/833/x9791165219833.jpg"));
		list.add(new Book(0, 6, "빌 게이츠 넥스트 팬데믹을 대비하는 법", "이영래", 16200, "2022년 06월 10일", "비즈니스북스", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/804/x9791162542804.jpg"));
		list.add(new Book(0, 4, "신녀성의 레미장센", "안상아(신녀성)", 15300, "2022년 06월 22일", "토네이도", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/446/x9791158512446.jpg"));
		list.add(new Book(0, 6, "약혼자를 고용해 봤습니다만 1", "오하라", 4950, "2022년 05월 30일", "서울미디어코믹스(서울문화사)", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/042/x9791136754042.jpg"));
		list.add(new Book(0, 6, "[생채소 x 빵] 샌드위치, 어떻게 조립해야 하나?", "용동희", 16200, "2022년 05월 10일", "그린쿡", 0.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/228/x9788971908228.jpg"));
		list.add(new Book(0, 4, "역행자", "자청", 15750, "2022년 05월 30일", "웅진지식하우스", 9.7,
				"http://image.kyobobook.co.kr/images/book/xlarge/716/x9788901260716.jpg"));
		list.add(new Book(0, 4, "어른의 시간 완벽하지 않은 날들을 위한 인생 수업", "박선영", 0, "2022년 05월 31일", "온워드", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/529/x9791168982529.jpg"));
		list.add(new Book(0, 4, "말의 시나리오", "김윤나", 14400, "2022년 06월 03일", "카시오페아", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/428/x9791168270428.jpg"));
		list.add(new Book(0, 4, "예민한 사람도 마음이 편안해지는 작은 습관(포근포근 에디션)", "이은혜", 13950, "2022년 04월 30일", "더퀘스트", 9.8,
				"http://image.kyobobook.co.kr/images/book/xlarge/835/x9791165215835.jpg"));
		list.add(new Book(0, 4, "브라이언 트레이시 성공의 지도", "정미나", 14850, "2022년 05월 31일", "갤리온", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/617/x9788901260617.jpg"));
		list.add(new Book(0, 4, "마음 발견의 기술", "김종명", 15300, "2022년 05월 25일", "불광출판사", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/535/x9788974795535.jpg"));
		list.add(new Book(0, 4, "감정의 늪에서 빠져나오는 중입니다", "전경아", 11700, "2022년 05월 23일", "현대지성", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/952/x9791139704952.jpg"));
		list.add(new Book(0, 4, "설득의 디테일", "이정민", 14850, "2022년 05월 26일", "현대지성", 0.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/065/x9791139705065.jpg"));
		list.add(new Book(0, 4, "인생의 무기가 되는 히든 스토리", "이은경", 16020, "2022년 05월 25일", "윌북", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/857/x9791155814857.jpg"));
		list.add(new Book(0, 4, "말 잘한다는 소리를 들으면 소원이 없겠다", "정흥수", 14400, "2022년 06월 06일", "비지니스북스", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/828/x9791162542828.jpg"));
		list.add(new Book(0, 5, "아들아 부동산 공부해야 한다", "정선용, 안창순", 15300, "2022년 05월 16일", "리더스북", 9.8,
				"http://image.kyobobook.co.kr/images/book/xlarge/358/x9788901260358.jpg"));
		list.add(new Book(0, 5, "초뷰카 시대 지속가능성의 실험실", "윤정구", 22500, "2022년 05월 23일", "21세기북스", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/557/x9788950900557.jpg"));
		list.add(new Book(0, 5, "이웃집 백만장자(골드 리커버 에디션)", "홍정희", 16920, "2022년 06월 10일", "리드리드출판", 9.9,
				"http://image.kyobobook.co.kr/images/book/xlarge/627/x9788972773627.jpg"));
		list.add(new Book(0, 5, "메타버스 새로운 부의 탄생", "정주은", 15300, "2022년 05월 16일", "비즈니스맵", 0.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/551/x9788986022551.jpg"));
		list.add(new Book(0, 5, "변화하는 세계 질서", "송이루, 조용빈", 34200, "2022년 06월 01일", "한빛비즈", 9.6,
				"http://image.kyobobook.co.kr/images/book/xlarge/798/x9791157845798.jpg"));
		list.add(new Book(0, 5, "메타버스 시티", "심재국", 13500, "2022년 05월 23일", "매일경제신문사", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/159/x9791164844159.jpg"));
		list.add(new Book(0, 5, "이렇게만 하면 장사는 저절로 됩니다", "강호동", 0, "2022년 05월 18일", "위즈덤하우스", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/175/x9791168123175.jpg"));
		list.add(new Book(0, 5, "돈이 된다! ETF 월급 만들기", "투생(이금옥)", 16200, "2022년 05월 27일", "진서원", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/882/x9791186647882.jpg"));
		list.add(new Book(0, 5, "부의 본능(골드 에디션)", "우석", 15300, "2022년 05월 31일", "토트", 0.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/787/x9791187444787.jpg"));
		list.add(new Book(0, 2, "샤일록의 아이들", "민경욱", 12000, "2022년 06월 08일", "인플루엔셜", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/275/x9791168340275.jpg"));
		list.add(new Book(0, 2, "십자도 살인사건", "윤자영", 13500, "2022년 06월 07일", "북오션", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/819/x9788967996819.jpg"));
		list.add(new Book(0, 2, "루팡의 딸 4", "권하영", 11000, "2022년 05월 10일", "북플라자", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/544/x9791190157544.jpg"));
		list.add(new Book(2, 3, "모든 것은 기본에서 시작한다", "손웅정", 14400, "2021년 10월 15일", "수오서재", 9.7,
				"http://image.kyobobook.co.kr/images/book/xlarge/502/x9791190382502.jpg"));
		list.add(new Book(2, 3, "당신은 결국 무엇이든 해내는 사람", "김상현", 13500, "2022년 04월 20일", "필름(Feelm)", 9.6,
				"http://image.kyobobook.co.kr/images/book/xlarge/994/x9791188469994.jpg"));
		list.add(new Book(2, 3, "잘했고 잘하고 있고 잘 될 것이다(20만 부 기념 개정판)", "정영욱", 0, "2021년 05월 14일", "부크럼", 9.7,
				"http://image.kyobobook.co.kr/images/book/xlarge/605/x9791162143605.jpg"));
		list.add(new Book(2, 3, "햇빛은 찬란하고 인생은 귀하니까요: 밀라논나 이야기", "장명숙", 13320, "2021년 08월 18일", "김영사", 9.7,
				"http://image.kyobobook.co.kr/images/book/xlarge/051/x9788934985051.jpg"));
		list.add(new Book(2, 3, "H마트에서 울다", "정혜윤", 14400, "2022년 02월 28일", "문학동네", 9.9,
				"http://image.kyobobook.co.kr/images/book/xlarge/371/x9788954683371.jpg"));
		list.add(new Book(2, 3, "어린이라는 세계(리커버 특별판)", "김소영", 13500, "2020년 11월 16일", "사계절", 9.7,
				"http://image.kyobobook.co.kr/images/book/xlarge/918/x9791160946918.jpg"));
		list.add(new Book(2, 3, "우리는 조구만 존재야", "조구만 스튜디오", 12150, "2020년 12월 11일", "더퀘스트", 9.5,
				"http://image.kyobobook.co.kr/images/book/xlarge/497/x9791165213497.jpg"));
		list.add(new Book(2, 3, "눈 감으면 보이는 것들", "신순규", 12420, "2015년 10월 27일", "판미동", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/194/x9791158880194.jpg"));
		list.add(new Book(2, 3, "어둠 속에서 빛나는 것들", "신순규", 13320, "2021년 07월 12일", "판미동", 9.4,
				"http://image.kyobobook.co.kr/images/book/xlarge/746/x9791158889746.jpg"));
		list.add(new Book(2, 3, "내가 죽으면 장례식에 누가 와줄까(너나들이 리커버 에디션)", "김상현", 13500, "2020년 01월 16일", "필름(Feelm)", 9.4,
				"http://image.kyobobook.co.kr/images/book/xlarge/468/x9791188469468.jpg"));
		list.add(new Book(2, 3, "여행의 이유", "김영하", 12150, "2019년 04월 17일", "문학동네", 9.3,
				"http://image.kyobobook.co.kr/images/book/xlarge/972/x9788954655972.jpg"));
		list.add(new Book(2, 7, "반짝반짝 캐치! 티니핑 마음 성장 동화 2: 내가 책임질게!", "SAMG", 10800, "2022년 05월 16일", "아이휴먼", 9.4,
				"http://image.kyobobook.co.kr/images/book/xlarge/220/x9791165383220.jpg"));
		list.add(new Book(2, 7, "구름빵", "백희나", 11700, "2019년 12월 05일", "한솔수북", 9.3,
				"http://image.kyobobook.co.kr/images/book/xlarge/836/x9791170283836.jpg"));
		list.add(new Book(2, 7, "착한 달걀", "존리 존", 11700, "2022년 03월 10일", "길벗어린이", 9.4,
				"http://image.kyobobook.co.kr/images/book/xlarge/418/x9788955826418.jpg"));
		list.add(new Book(2, 7, "방구석 탈출 글로벌 어린이 세계지도", "소울하우스, 책마중", 12150, "2020년 07월 20일", "스마트베어", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/699/x9788930262699.jpg"));
		list.add(new Book(2, 7, "쉽고 재미있는 어린이 첫 그림 한자 사전 1단계", "한자교재개발팀", 9000, "2015년 07월 20일", "글송이", 9.4,
				"http://image.kyobobook.co.kr/images/book/xlarge/814/x9791170180814.jpg"));
		list.add(new Book(2, 7, "어린이 스티커 컬러링 2: 탈것", "일과놀이콘텐츠랩", 6750, "2021년 04월 05일", "북센스", 0.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/549/x9788993746549.jpg"));
		list.add(new Book(2, 7, "어린이 첫 공룡 사전", "최유성", 9000, "2015년 07월 20일", "글송이", 9.4,
				"http://image.kyobobook.co.kr/images/book/xlarge/784/x9791170180784.jpg"));
		list.add(new Book(2, 7, "어린이", "베아트리체 알레마냐", 11700, "2020년 02월 03일", "한솔수북", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/966/x9791170283966.jpg"));
		list.add(new Book(2, 7, "우리들은 자란다(길벗어린이 과학그림책 9)", "이은희", 10800, "2018년 01월 19일", "길벗어린이", 0.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/400/x9788955823400.jpg"));
		list.add(new Book(2, 7, "착한 어린이 대상! 제제벨", "토니 로스", 13500, "2020년 04월 10일", "키위북스", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/696/x9791185173696.jpg"));
		list.add(new Book(2, 7, "[키움]똑똑한 어린이 첫 동화 시리즈 세트 (전래동화+이솝우화+세계명작)(전 3권)", "알음외", 32400, "2016년 06월 01일", "키움외",
				0.0, "http://image.kyobobook.co.kr/images/book/large/703/l2909100735703.jpg"));
		list.add(new Book(2, 7, "어린이 회의", "기타무라 유카", 10800, "2020년 04월 20일", "한림출판사", 0.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/724/x9788970940724.jpg"));
		list.add(new Book(2, 7, "어린이 첫 동물 사전", "최유성", 9000, "2015년 07월 20일", "글송이", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/791/x9791170180791.jpg"));
		list.add(new Book(2, 7, "어린이 찬미", "방정환, 이주영", 10800, "2020년 06월 22일", "현북스", 0.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/051/x9791157412051.jpg"));
		list.add(new Book(2, 1, "스패로", "메리 도리아 러셀", 16200, "2022년 05월 31일", "황금가지", 0.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/679/x9791170521679.jpg"));
		list.add(new Book(2, 1, "행성 1", "베르나르 베르베르", 15120, "2022년 05월 30일", "열린책들", 9.6,
				"http://image.kyobobook.co.kr/images/book/xlarge/362/x9788932922362.jpg"));
		list.add(new Book(2, 1, "저만치 혼자서", "김훈", 13500, "2022년 06월 01일", "문학동네", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/921/x9788954686921.jpg"));
		list.add(new Book(2, 1, "밝은 밤", "최은영", 13050, "2021년 07월 27일", "문학동네", 9.8,
				"http://image.kyobobook.co.kr/images/book/xlarge/179/x9788954681179.jpg"));
		list.add(new Book(2, 1, "달러구트 꿈 백화점", "이미예", 12420, "2020년 07월 08일", "팩토리나인", 9.2,
				"http://image.kyobobook.co.kr/images/book/xlarge/909/x9791165341909.jpg"));
		list.add(new Book(2, 1, "애쓰지 않아도", "최은영", 13050, "2022년 04월 30일", "마음산책", 9.5,
				"http://image.kyobobook.co.kr/images/book/xlarge/348/x9788960907348.jpg"));
		list.add(new Book(2, 1, "모순", "양귀자", 11700, "2013년 04월 01일", "쓰다", 9.8,
				"http://image.kyobobook.co.kr/images/book/xlarge/012/x9788998441012.jpg"));
		list.add(new Book(2, 1, "미드나잇 라이브러리(1주년 스페셜 에디션)", "매트 헤이그", 14220, "2021년 04월 28일", "인플루엔셜", 9.3,
				"http://image.kyobobook.co.kr/images/book/xlarge/556/x9791191056556.jpg"));
		list.add(new Book(2, 1, "테라피스트", "B. A. 패리스", 14400, "2021년 12월 06일", "모모", 9.6,
				"http://image.kyobobook.co.kr/images/book/xlarge/518/x9791191043518.jpg"));
		list.add(new Book(2, 1, "지구 끝의 온실", "김초엽", 13500, "2021년 08월 18일", "자이언트북스", 9.7,
				"http://image.kyobobook.co.kr/images/book/xlarge/001/x9791191824001.jpg"));
		list.add(new Book(2, 1, "인간 실격", "다자이 오사무", 8100, "2012년 04월 10일", "민음사", 9.4,
				"http://image.kyobobook.co.kr/images/book/xlarge/033/x9788937461033.jpg"));
		list.add(new Book(2, 5, "제로 투 원(리커버 에디션)", "피터 틸 , 블레이크 매스터스", 14400, "2021년 10월 04일", "한국경제신문", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/567/x9788947547567.jpg"));
		list.add(new Book(2, 5, "환율과 금리로 보는 앞으로 3년 경제전쟁의 미래", "오건영", 16200, "2019년 08월 02일", "지식노마드", 9.5,
				"http://image.kyobobook.co.kr/images/book/xlarge/607/x9791187481607.jpg"));
		list.add(new Book(2, 5, "파이어 FIRE", "강환국", 16200, "2022년 04월 08일", "페이지2북스", 9.3,
				"http://image.kyobobook.co.kr/images/book/xlarge/616/x9791190977616.jpg"));
		list.add(new Book(2, 5, "현명한 투자자", "벤저민 그레이엄", 20700, "2020년 05월 26일", "국일증권경제연구소", 9.6,
				"http://image.kyobobook.co.kr/images/book/xlarge/305/x9788957821305.jpg"));
		list.add(new Book(2, 5, "보도 섀퍼의 돈", "보도 섀퍼", 12600, "2011년 05월 15일", "에포케", 9.8,
				"http://image.kyobobook.co.kr/images/book/xlarge/013/x9788919205013.jpg"));
		list.add(new Book(2, 5, "최재붕의 메타버스 이야기", "최재붕", 15300, "2022년 05월 13일", "북인어박스", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/027/x9791197617027.jpg"));
		list.add(new Book(2, 5, "아들아, 돈 공부해야 한다(10만 부 기념 골드 에디션)", "정선용(정스토리)", 15300, "2022년 04월 20일", "알에이치코리아", 8.5,
				"http://image.kyobobook.co.kr/images/book/xlarge/354/x9788925578354.jpg"));
		list.add(new Book(2, 5, "코인 좀 아는 사람", "닐 메타, 아다티야 아가쉐, 파스 디트로자", 17820, "2022년 05월 30일", "윌북", 8.3,
				"http://image.kyobobook.co.kr/images/book/xlarge/840/x9791155814840.jpg"));
		list.add(new Book(2, 4, "쥬비스 미라클", "조성경", 14400, "2022년 03월 28일", "쌤앤파커스", 9.7,
				"http://image.kyobobook.co.kr/images/book/xlarge/870/x9791165344870.jpg"));
		list.add(new Book(2, 4, "마음챙김", "샤우나 샤피로", 14850, "2021년 01월 06일", "안드로메디안", 9.4,
				"http://image.kyobobook.co.kr/images/book/xlarge/218/x9791135493218.jpg"));
		list.add(new Book(2, 4, "데일 카네기 자기계발시리즈 3종 세트(특별한정보급판)", "데일 카네기", 27720, "2017년 01월 30일", "더클래식", 10.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/053/x9791159034053.jpg"));
		list.add(new Book(2, 4, "세상에서 가장 재미있는 88가지 심리실험: 자기계발편", "나이토 요시히토", 16200, "2020년 08월 31일", "사람과나무사이", 9.7,
				"http://image.kyobobook.co.kr/images/book/xlarge/306/x9791188635306.jpg"));
		list.add(new Book(2, 4, "내 인생의 탐나는 자기계발 50", "톰 버틀러 보던", 16200, "2019년 07월 25일", "흐름출판", 0.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/332/x9788965963332.jpg"));
		list.add(new Book(2, 4, "성공의 차이를 만드는 의사소통과 자기계발", "문소윤", 18000, "2019년 06월 20일", "지식인", 0.0,
				"http://image.kyobobook.co.kr/images/book/xlarge/373/x9791188105373.jpg"));

		return list;
	}
}
