
# ----------------------
# JDBC 연결할 DB 선언
drop database if exists sqldb4web;
create database sqldb4web;
use sqldb4web;
create table member(
   mno int not null unique auto_increment ,   -- 자동부여[무조건PK만가능] 
    mid varchar(30) not null unique,
    mpw varchar(30)  not null ,      -- 중복허용 
    mname varchar(30) not null ,   -- 중복허용 
    mphone varchar(13) not null unique ,
    primary key(mno) 
);

drop table if exists member;

select * from member;

# 1. 회원가입
insert into member(mid, mpw, mname, mphone) values ('ezen01', '1234', '이젠', '031-444-2222');

# 2. 로그인 
select mid from member; -- mid 필드의 레코드만 검색 
select mid, mpw from member; -- mid와 mpw필드의 레코드만 검색
select * from member;	-- *[모든필드 뜻] 모든필드의 레코드 검색 
# 1. 로그인할때 필요한 필드 [ 아이디, 패스워드 ] 검색 
select mid, mpw from member; # select * from member;
# 2. 아이디와 패스워드가 일치한 레코드 검색 
select mid, mpw from member where mid = 'qwe'; # 만약에 mid필드에 'qwe'문자열이 있는 레코드 검색 
select mid, mpw from member where mid = 'ezen01'; # 만약에 mid필드에 'ezen01'문자열이 있는 레코드 검색 
/*
	1. 테이블의 필드에 해당하는 레코드 검색 
		select 필드명 from 테이블명 				: 해당 필드의 레코드 검색 
        select 필드명, 필드명, 필드명 from 테이블		: 여러개 필드들의 레코드 검색 
		select * from 테이블명					: 모든 필드[*]의 레코드 검색 
        
	2. 필드에 조건 추가				[ where 조건절 ]
		select 필드명 							from 테이블명 whewre 조건
        select 필드명, 필드명, 필드명 				from 테이블 whewre 조건
		select * from 테이블명					: 모든 필드[*]의 레코드 검색 
        
*/