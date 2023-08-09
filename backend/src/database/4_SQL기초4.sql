drop database if exists sqldb5web;
create database sqldb5web;
use sqldb5web;
drop table if exists table1;
create table table1( 데이터1 int, 데이터2 varchar(100));

# CRUD :
# 1. insert [ C : create ]
	# insert into 테이블명( 필드명, 필드명 ) values( 값1, 값2 )
insert into table1( 데이터1, 데이터2 ) values( 1, '유재석' ); # 데이터1 필드에 '1' 데이터2 필드에 '유재석' 레코드 삽입  
insert into table1( 데이터1, 데이터2 ) values( 2, '강호동' );

# 2. select [ R : reading ] 
	# select 필드명 from 테이블명
	# select 필드명 from 테이블명 where 조건명 
select * from table1;							# 모든 레코드 검색 [ 모든필드 표시 ] 
select * from table1 where 데이터2 = '강호동';		# 데이터2 필드의 값이 '강호동'인 레코드 검색 [ 모든필드 표시 ]
    
# 3. update [ U : update ]
	# update 테이블명 set 필드명 = 수정값 , 필드명 = 수정값 
	# update 테이블명 set 필드명 = 수정값 , 필드명 = 수정값 where 조건절
update table1 set 데이터1 = 3;	# 메뉴 -> edit -> Preference -> sql editer -> 하단 -> safe updates 해제 [ update, delete 사용시 ]
update table1 set 데이터1 = 2 where 데이터2 = '유재석'; # 데이터2 필드의 값이 '유재석'인 레코드의 데이터1 필드의 값을 2로 변경 

# 4. delete [ D : delete ] 
	# delete from 테이블명 
    # delete from 테이블명 where 조건절
delete from table1; 						# 모든 레코드를 삭제 		
delete from table1 where 데이터2 = '유재석';	# 데이터2 필드의 값이 '유재석'인 레코드 삭제

#---------------------------------------------------------------------

use sqldb4web;
# 1. 테이블의 모든 레코드 검색 
select * from member;
# 2. 회원가입 : mno 자동부여이므로 생략 
insert into member(mid, mpw, mname, mphone) values('ezen02', '1234', '이젠', '010-443-1234'); 
# insert into member(mid, mpw, mname, mphone) values(?,?,?,?); 
# 3. 로그인 : 입력한 값이 존재하는지 검색
select * from member where mid = 'ezen02' and mpw = '1234'; # 로그인 성공 : 레코드 1개이상 검색되면
select * from member where mid = 'ezen02' and mpw = '12345'; # 로그인 시랲 : 레코드 0개 검색
# 4. 아이디/비밀번호 중복체크(유효성검사) : 입력한 값이 존재하는지 검색 
select * from member where mid = 'ezen02';
select * from member where mphone = '010-443-1234';
# 5. 아이디찾기/비밀번호 찾기 : 입력한 값의 레코드 검색 
select mid from member where mname = '이젠' and mphone = '010-443-1234';
# select mid from member where mname = ? and mphone = ?;
select mpw from member where mid = 'ezen02' and mphone = '010-443-1234';
# select mpw from member where mid = ? and mphone = ?;

# 6. 회원 수정 : 비밀번호 수정 : pk식별 조건 [ pk필드는 수정하지 않음 - 권장 ] 
update member set mpw = '12345' where mno = 4; # 4번 회원인 레코드의 비밀번호 수정
# update member set mpw = ? where mno = ?; 
# 6. 회원 수정 : 이름, 전화번호 수정 : pk식별 조건 [ pk필드는 수정하지 않음 - 권장 ] 
update member set mname = 'ezen', mphone = '010-1234-1234' where mno = 4; # 4번 회원인 레코드의 전화번호, 이름 수정
# update member set mname = ?, mphone = ? where mno = ?;

# 7. 회원탈퇴 : pk 식별조건 
delete from member where mno = 4; # 4번 회원 삭제 
# delete from member where mno = ?;