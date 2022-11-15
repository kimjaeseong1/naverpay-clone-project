# 스프링 토이 프로젝트 team#1
## MVC 기반 네이버페이 웹 기능 구성
팀명 : 스틸마 남바완<br><br>
팀원 : **이성목(팀장)**, 제원석, 김재성, 유재민, 장재학, 이성제<br><br>
프로젝트 기간 : 2022.10.31 ~ 2022.11.11<br>
- - -
# 프로젝트 요약
스프링 MVC패턴을 활용하여 네이버페이의 웹 기능을 구현한다.

## 주의사항
- 구현범위에서 뷰 단은 모두 제외
  - 간단하게 출력하는 식으로 뷰를만들거나 뷰 없이 바로 Controller 단에서 테스트 하면 됨!
- API 설계는 네이버페이와 동일하게 할 필요 없음

## 구현 범위
- 메인 페이지 로그인 기능 
- https://nid.naver.com/nidlogin.login?url=http://pay.naver.com
<img src="https://echoiing-fastcampus.notion.site/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F9cac5b9b-8b24-47f8-804a-a8d79c4cd4df%2F%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2022-10-29_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%2592%25E1%2585%25AE_12.14.15.png?table=block&id=3c4528a0-658d-49f2-b348-83d7e75cf7ce&spaceId=9cc18492-9706-414c-804b-117439dd4a25&width=860&userId=&cache=v2">
<img src="https://echoiing-fastcampus.notion.site/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2Fdeebc6f5-4278-45c2-9a88-50d71c390a73%2F%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2022-10-29_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%2592%25E1%2585%25AE_12.27.19.png?table=block&id=34f2e1ae-bb08-444e-b74e-56396a078b06&spaceId=9cc18492-9706-414c-804b-117439dd4a25&width=860&userId=&cache=v2">

- 네이버페이의 쇼핑 부분
- [https://order.pay.naver.com/home](https://order.pay.naver.com/home)

- [https://pay.naver.com/payments/detail/20221014NP4742258625](https://pay.naver.com/payments/detail/20221014NP4742258625)

- [https://order.pay.naver.com/home/search?serviceGroup=SHOPPING&range.fromDate=2022.10.14&range.toDate=2022.10.31&tabMenu=SHOPPING](https://order.pay.naver.com/home/search?serviceGroup=SHOPPING&range.fromDate=2022.10.14&range.toDate=2022.10.31&tabMenu=SHOPPING)

## URL 설계
- URL은 직접 설계
- Naver PAy와 동일할 필요는 없음
- 아직 RestTAPI를 공부하기 전이므로 GET,POST 메소드로만 설계
  ![화면 캡처 2022-11-15 193518](https://user-images.githubusercontent.com/105026909/201898266-3471c2c6-ed41-4193-b423-de0617725a99.png)


시연 영상
![ezgif com-gif-maker](https://user-images.githubusercontent.com/105026909/201899174-77a9e085-1434-42db-9622-754b510ad2d1.gif)
