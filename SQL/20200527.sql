-- 2020.05.27.수


create table emp_hir
as
select empno, ename, hiredate from emp where 1<0
;

create table emp_mgr
as
select empno, ename, mgr from emp where 1<0
;

desc emp_hir;
desc emp_mgr;

-- 두개 테이블에 emp 테이블의 데이터를 기반으로 삽입
insert all
into emp_hir values(empno, ename, hiredate)
into emp_mgr values(empno, ename, mgr)
select empno, ename, hiredate, mgr
from emp
--where deptno=20
;

desc emp;
select * from emp;

select * from emp_hir;
select * from emp_mgr;



--INSERT ALL 명령문에 WHEN 절을 추가해서 조건을 제시하여 
---조건에 맞는 행만 추출하여 테이블에 추가합니다.
--EMP_HIR02 테이블에는 1982 년 01 월01 일 이후에 입사한 
---사원들의 번호, 사원 명, 입사일을 추가합니다.
--EMP_SAL 테이블에는 급여가 2000 이상인 사원들의 번호, 
---사원 명, 급여를 추가합니다.

create table emp_hir02
as
select empno, ename,hiredate from emp where 1<0;

create table emp_sal
as
select empno, ename, sal from emp where 1<0;

desc emp_hir02;

desc emp_sal;

insert all
when hiredate > '82/01/01' then
    into emp_hir02 values (empno, ename, hiredate)
when sal > 2000 then
    into emp_sal values(empno, ename, sal)
select empno, ename, hiredate, sal
from emp
;

select * from emp_hir02;

select * from emp_sal;

-------------------------------------------------------

desc emp01;

create table emp01
as
select * from emp
;

-- 컬럼의 데이터 변경(수정)

select * from emp01;

UPDATE EMP01 
SET DEPTNO=30
;

rollback;

commit;

UPDATE EMP01
SET DEPTNO=30
WHERE DEPTNO=10
;

UPDATE EMP01 
SET SAL = SAL * 1.1 
WHERE SAL >= 3000
;


UPDATE EMP01 
SET DEPTNO=10, JOB='MANAGER' 
WHERE ENAME='SCOTT';



desc dept01;
select * from dept01;


-- 1. 20번 부서의 지역명을 
--    40번 부서의 지역명으로 변경하기 위해서 서브 쿼리문을 사용해 봅시다.

update dept01
set loc=(
    select loc from dept01 where deptno=40
)
where deptno=20
;

rollback;


drop table dept01;
create table dept01
as
select * from dept
;
select * from dept01;




-- 서브 쿼리를 이용해서 부서번호가 20인 부서의 
-- 부서명과 지역명을 
-- 부서 번호가 40번인 부서와 동일하게 변경하도록 해 봅시다.
update dept01
set dname=(select dname from dept01 where deptno=40),
    loc=(select loc from dept01 where deptno=40)
where deptno=20
;
update dept01
set  (dname, loc)=(select dname, loc from dept01 where deptno=40)
where deptno=20
;


--------------------------------------------------------
-- DML : 삭제
--------------------------------------------------------

-- delete  from 테이블 이름 where 행을 찾을 조건식
-- where 절이 없으면 모든행에 영향을 준다.

-- 부서 테이블의 모든 행을 삭제합시다.
delete from dept01;
select * from dept01;

-- 부서 테이블에서 30번 부서만 삭제합시다.
ROLLBACK;

delete from dept01 where deptno=30;

-- 사원 테이블에서 
-- 부서명이 SALES인 사원을 모두 삭제해봅시다.

select deptno from dept where dname='SALES' ;

select * from emp01;

delete from emp01 where deptno=(
    select deptno from dept where dname='SALES'
)
;

------------------------------------------------------

-- View

------------------------------------------------------

CREATE VIEW EMP_VIEW30
AS
SELECT EMPNO, ENAME, DEPTNO
FROM EMP
WHERE DEPTNO=30;

desc user_views;


select * from user_views;

drop view EMP_VIEW30;


CREATE OR REPLACE VIEW VIEW_HIRE 
AS 
SELECT EMPNO, ENAME, HIREDATE 
FROM EMP 
ORDER BY HIREDATE;

select * from view_hire;


SELECT ROWNUM, EMPNO, ENAME, HIREDATE FROM VIEW_HIRE
WHERE ROWNUM<=5
;


----------------------------------------------------------------
-- sequence : 번호 자동 생성기
----------------------------------------------------------------

-- create sequence 시퀀스이름 
-- start with 시작값  0 시작
-- increment by 증가값 1
-- maxvalue 최대값
-- minvalue 최소값
-- cycle | nocycle 반복 여부
-- cache | nocache

-- 부서번호 deptno 의 sequence 생성
create sequence dept_deptno_seq01;

select dept_deptno_seq01.nextval
from dual;

select dept_deptno_seq01.currval
from dual;





