drop database if exists sqldb4web;
create database sqldb4web;

use sqldb4web;

# 회원번호[자동] 아이디 비밀번호 이름 전화번호를 저장하는 member 테이블 생성 
# 테이블과 비슷하게 memberDto 클래스 설계
drop table if exists member;
create table member(
   	mno int not null unique auto_increment ,   -- 자동부여[무조건PK만가능] 
    mid varchar(30) not null unique,
    mpw varchar(30)  not null ,      -- 중복허용 
    mname varchar(30) not null ,   -- 중복허용 
    mphone varchar(13) not null unique ,
    primary key(mno) 
);

drop table if exists board;
create table board(
	bno		int auto_increment,		# 정수, 자동번호 부여
    btitle	varchar(50) not null,	# 문자50, 공백 불가 
    bcontent longtext,				# 긴글[4G]
    bdate datetime default now(),	# 날짜/시간, 기본값을 레코드삽입기준 자동 
    bview int default 0,			# 정수, 기본값을 0
    mno int,						# 작성자의 회원번호 [ 작성자의 식별번호 ]
    primary key(bno),				# 제약조건 [ PK ]
	foreign key(mno) references member(mno) on delete cascade 	# 회원탈퇴[PK레코드 삭제] 되면 FK의 레코드 값이 같이 삭제
);

create table message(
	msno int auto_increment primary key, 			# 메세지 번호
    sender int, 									# 보낸 사람 (member테이블의 mno fk)
    taker int,										# 받은 사람 (member테이블의 mno fk)
    mscontent varchar(300),
    foreign key(sender) references member(mno),
    foreign key(taker) references member(mno)
);