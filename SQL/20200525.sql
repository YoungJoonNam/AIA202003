--20200525

---------------------------------------------
-- DDL
---------------------------------------------

-- 테이블 생성
-- create table 테이블의 이름 () <- 괄호 안에 컬럼을 정의
-- ( 컬럼명1 타입(사이즈) , 컬럼명2 타입(사이즈) , ... )

-- ddl_test 라는 이름의 테이블을 생성
-- 컬럼1 : no, 숫자타입 사이즈는 3
-- 컬럼2 : name, 가변 문자열 저장, 사이즈 10
-- 컬럼3 : birth, 날짜 타입, 기본값은 현재 날짜 시간

create table ddl_test (
    no number(3),
    name varchar2(10),
    birth date default sysdate
);

desc ddl_test;


CREATE TABLE EMP01(
EMPNO NUMBER(4),
ENAME VARCHAR2(20),
SAL NUMBER(7, 2));

desc emp01;

create table emp02
as
select * from emp;

select * from emp02;


CREATE TABLE EMP03( 
EMPNO NUMBER(4) UNIQUE, 
ENAME VARCHAR2(10) NOT NULL, 
JOB VARCHAR2(9), 
DEPTNO NUMBER(2) );

drop table emp03;


CREATE TABLE EMP04( 
EMPNO NUMBER(4) CONSTRAINT EMP04_EMPNO_UK UNIQUE, 
ENAME VARCHAR2(10) CONSTRAINT EMP04_ENAME_NN NOT NULL, 
JOB VARCHAR2(9), DEPTNO NUMBER(2) );

desc emp04;

