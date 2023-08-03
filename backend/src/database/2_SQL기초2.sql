/*
	   문제3 : 
      1. 웹개발 하는데 DB저장소 'sqldb2web1' 이름으로 DB 생성
      2. 해당 db에 memberboard 테이블 생성
            회원번호      ( 필드명 : mno      타입 : 최대 21억정도 )
                회원아이디      ( 필드명 : mid      타입 : 문자열 최대 20 )
                회원비밀번호    ( 필드명 : mpw      타입 : 문자열 최대 20 )
            게시물번호    ( 필드명 : bno        타입 : 최대 21억정도 )
            게시물제목      ( 필드명 : btitle    타입 : 문자열 최대 100 )   
            게시물내용    ( 필드명 : bcontent    타입 : 문자열 최대 6만5천 이상 )
            게시물조회수   ( 필드명 : bview       타입 : 최대 21억정도 )
            게시물작성일    ( 필드명 : bdate       타입 : 날짜/시간 )
*/
/*
	- 제약조건
		1. pk : primary key ( pk 필드명 )
        2. fk : foreign key ( fk 필드명 ) references pk테이블명(pk필드명)
*/
drop database if exists sqldb2web1; # [명령어]; 마다 컨트롤+엔터
create database sqldb2web1;
use sqldb2web1;

create table memberboard(
	mno int,
    mid varchar(20),
    mpw varchar(20),
    bno int,
    btitle varchar(100),
    bcontent longtext,
    bview int,
    bdate datetime
);

# 문제4 memberboard table 2개의 table로 나누기

create table member(
	mno int,
    mid varchar(20),
    mpw varchar(20)
);

create table board(
	bno int,
    mno int,
    btitle varchar(100),
    bcontent longtext,
    bview int,
    bdate datetime
);

select * from board;
# --------------------------> 테이블 관계 확인
use sqldb2web1;

drop table if exists member2;
create table member2(
	mno int,
    mid varchar(20),
    mpw varchar(20),
    primary key( mno ) -- 현재 테이블에서 mno라는 필드를 primary key로 설정
);

drop table if exists board2;
create table board2(
	bno int,
    mno int,
    btitle varchar(100),
    bcontent longtext,
    bview int,
    bdate datetime,
    primary key( bno ),
    foreign key( mno ) references member2(mno) -- 2. 현재 테이블에서 member2의 mno와 foreign key로 설정
);


/*
   문제5 : 조건
      1) 키오스크 시스템 개발하는데 'sqldb2sys' 라는 이름으로 DB 생성 
        2) 카테고리(category) 와 제품(product) 테이블 2개를  선언 
        3)    카테고리 : 카테고리번호(cno) , 카테고리명(cname)  
         제품 : 제품번호(pno) , 제품명(pname) , 제품가격(pprice) 
         - 필드 타입은 적절한 타입으로 선언 
      4) 두 테이블간 관계 
         - pk필드는 새로 생성하지 않고 pk설정만 하고 fk필드는 선언후 관계 설정한다.
*/

drop database if exists sqldb2sys;
create database sqldb2sys;
use sqldb2sys;
# 조건2) 1. 테이블선언하고 필드명과 필드타입 선언 2. pk 선정 [ 테이블당 1개 권장 ] 3. 1:M 관계 경우에는 M쪽 테이블에 FK 필드 선언/설정
create table category(
	cno int primary key,
    cname varchar(20)
);

create table product(
	pno int primary key,
    pname varchar(20),
    pprice int,
    cno int,
    foreign key(cno) references category(cno)
);

create table orders(
	ono int primary key,
    onum int,
    oproduct varchar(20),
    odate datetime,
    ocount int
);




