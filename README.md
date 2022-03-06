# 스프링부트와 AWS로 혼자 구현하는 웹 서비스
3번째 공부 시리즈(자바의 정석 -> 패스트캠퍼스 강의 -> )

# 환경설정
gadle 사용, 버전: 2.1.7.Relese, JUnit4, lombok, jpa                                                                                                                                                                                                                                                                                                    사용 

데이터베이스 : h2

##### 요구사항 분석
- 게시판 기능
  c,r,u,d
- 회원 기능
    구글 / 네이버 로그인
    로그인한 사용자 글 작성 권한
    보인 작성 글에 대한 권한 관리
  

###### 에러 내역
1. 만약에 h2 console이 안열린다면 application.properties 파일이 test 패키지 밑에 있는지 확인하기...
2. net::ERR_ABORTED 404로 js 파일을 가져오지 못한다면 rebuild 하기
3. p.181(유저 권한을 가진 사람만 허용 할 때)
   // 책 - hasRole(Role.USER.name())
   // 실제 - hasRole(String.valueOf(Role.USER))