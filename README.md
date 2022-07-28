
# Project - 우리의 서재

##  도서 정보 어플
> ### 도서 정보를 조회하고 구매할 수 있는 어플입니다. 
> ### 찜 기능과 다이어리 기능으로 나만의 공간을 느낄 수 있습니다.

## 🛠 프로젝트에 사용한 언어 및 프레임워크 / API / 라이브러리

- [ ]  Backend : <img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=JAVA&logoColor=white"> <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white">
- [ ]  Frontend : <img src="https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=Android&logoColor=white">
- [ ]  버전관리 : <img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=GitHub&logoColor=white"> <img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=Git&logoColor=white">

## 프로젝트 기간

- 2022 06.08 ~ 2022 06.14

## 프로그램 기능

### ✔️ 추천 도서

추천 도서는 랜덤으로 랜더링해서 보여줍니다.

### ✔️ 광고

시간 indicator를 이용한 광고 효과를 냈습니다.

### ✔️ 도서 조회

베스트, 신간, 장르별 도서를 조회할 수 있습니다.

id값을 정해두고 서버에 저장을 한 뒤, 

각 카테고리에 해당하는 id 값으로 서버에 접근하여 Retrofit2를 이용하여 데이터를 불러왔습니다.

### ✔️ 도서 제목 검색

검색한 단어가 들어가는 제목의 책을 전부 검색해옵니다.

### ✔️ 없는 값을 입력했을 때 예외 처리

### ✔️ 도서 상세보기

도서에 대한 모든 정보를 조회할 수 있습니다.

도서 제목 / 작가 / 장르 / 발행일 / 출판사 / 판매가 

별점 / 줄거리 / 구매링크

| 도서 조회 (추천, 베스트, 신간, 장르별) | 도서 검색 |
|--|--|
| ![1](https://user-images.githubusercontent.com/102580742/181462313-46970891-c66b-4271-b707-7ec345d82d8f.gif) | ![search](https://user-images.githubusercontent.com/102580742/181463980-2fbec978-c693-4d9b-b1d7-0d5f7a2ca960.gif) |

### ✔️ 독후감 기능의 다이어리

독서를 하고 간단한 메모나 독후감을 기록할 수 있도록 다이어리 기능을 추가했습니다.

SharedPreference를 이용하여 기기 자체에 데이터를 저장하였고, 여러 개 작성할 수 있습니다.

### ✔️ 찜 기능

관심 있는 도서에 하트를 눌러 찜 목록에 담을 수 있습니다.

찜 목록에서 상세 페이지, 구매 사이트까지 연결됩니다.

| 다이어리 | 찜 기능 |
|--|--|
| ![diary](https://user-images.githubusercontent.com/102580742/181462327-b1a155e0-5350-4fe6-9c33-211818ab0e04.gif) | ![likes](https://user-images.githubusercontent.com/102580742/181463929-b53af0fe-5bf1-4ca9-a980-045e3eb9b532.gif) |


### ✔️ 실제 구매 사이트 연결

도서를 직접 구매할 수 있도록 사이트를 연결합니다.

| 도서 구매사이트 링크 |  
|--|
| ![link](https://user-images.githubusercontent.com/102580742/181463952-f51dcd44-4838-4983-90da-05801913c2fb.gif) 

---
- ### 프로그램 구현 영상

https://user-images.githubusercontent.com/102580743/181428934-0d1781b0-37d1-4290-9d28-2734b9e67c1f.mp4
---
## 페이지 구성

![메인페이지(추천)](https://user-images.githubusercontent.com/102580743/181202807-9082528f-6304-4c6b-9c7f-1a9c740dacd0.png)

![베스트셀러](https://user-images.githubusercontent.com/102580743/181202812-5dcd6b15-2f82-4b5b-81ca-8e21fad877e0.png)

![신간 도서](https://user-images.githubusercontent.com/102580743/181202816-cdb1e2ad-ae09-485d-88d0-6233bfd93e0f.png)

![장르별 페이지 (소설, 추리소설, 에세이, 자기계발, 경제)](https://user-images.githubusercontent.com/102580743/181202821-070932aa-6896-487b-8438-2fa9a42cf702.png)

![도서 상세페이지](https://user-images.githubusercontent.com/102580743/181202823-c4a38e4a-5619-4690-b006-35f536e2fd87.png)

![구매링크](https://user-images.githubusercontent.com/102580743/181202825-d9d03c5a-f193-4f5a-918b-46d0c55ca96e.png)

![검색페이지 (메인페이지 우상단 클릭시)](https://user-images.githubusercontent.com/102580743/181202828-c08d1f3a-795c-4dec-b0eb-6feaa1178de2.png)

![다이어리 메인](https://user-images.githubusercontent.com/102580743/181202830-a6c31d07-7ccb-4c84-b575-f4c6a567c2e4.png)

![다이어리 작성](https://user-images.githubusercontent.com/102580743/181202851-776bf512-4b66-40c9-8671-1b34dfdd1f18.png)

![다이어리 작성목록](https://user-images.githubusercontent.com/102580743/181202868-4d71c7de-67c7-47ea-9715-a2448ff1e82d.png)

![찜리스트 페이지 (도서 상세페이지 하트 클릭시 생성)](https://user-images.githubusercontent.com/102580743/181202871-3d0738a3-f7ac-4dc7-b1d5-6c207d50002e.png)

