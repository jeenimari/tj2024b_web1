create database tmember;
use tmember;
-- 회원 테이블 생성
create table t_member(
id varchar(10) primary key,
pwd varchar(10),
name varchar(50),
email varchar(50),
joindate datetime default current_timestamp
);

-- 회원 정보 추가
insert into t_member
values('hong','1212','홍길동','hong@gamil.com',current_date());

insert into t_member
values('lee','1212','이순신','lee@test.com',current_date());

insert into t_member
values('kim','1212','김유신','kim@jweb.com',current_date());
commit;

select*from t_member;