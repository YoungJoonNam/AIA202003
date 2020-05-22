--2020.05.22

select * from tab;


--평균 급여를 구하는 쿼리문을 서브 쿼리로 사용하여 
--평균 급여보다 더
--많은 급여를 받는 사원을 검색

select ename, sal
from emp
where sal > 
(select avg(sal) from emp)
;



select * 
from emp
where deptno = 20
;

select deptno from emp where ename='SCOTT';


select * 
from emp
where deptno = (select deptno from emp where ename='SCOTT')
;

--
--3000 이상 받는 사원이 소속된 부서(10번, 20번)와 동일한
--부서에서 근무하는 사원이기에 서브 쿼리의 결과 중에서 하나라도
--일치하면 참인 결과를 구하는 IN 연산자와 함께 사용되어야 합니다.

SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO IN ( SELECT DISTINCT DEPTNO
FROM EMP
WHERE SAL>=3000);


--30번 소속 사원들 중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를
--받는 사람의 이름, 급여를 출력하는 쿼리문을 작성해 봅시다.

SELECT SAL
FROM EMP
WHERE DEPTNO =30
;

SELECT ENAME, SAL
FROM EMP
WHERE SAL > ALL(SELECT SAL
FROM EMP
WHERE DEPTNO =30);



--부서번호가 30번인 사원들의 급여 중 가장 작은 값(950)보다 
--많은 급여를 받는 사원의 이름, 급여를 출력하는 예제


SELECT ENAME, SAL 
FROM EMP 
WHERE SAL > ANY 
( SELECT SAL FROM EMP WHERE DEPTNO = 30 );


SELECT ENAME, SAL 
FROM EMP 
WHERE SAL > 
( SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30 );


-- ROWNUM : 입력순서의 번호

SELECT ROWNUM, ENAME
FROM EMP
;


--마당서점의 고객별 판매액을 보이시오
--(결과는 고객이름과 고객별 판매액을 출력).

SELECT * FROM ORDERS;

SELECT * 
FROM Customer cs,Orders od 
WHERE cs.custid=od.custid;



SELECT 
( SELECT name FROM Customer cs WHERE cs.custid=od.custid ) "name",
SUM(saleprice) "total" 
FROM Orders od 
GROUP BY od.custid;



--질의 고객번호가 2 이하인 고객의 판매액을 보이시오 
--(결과는 고객이름과 고객별 판매액 출력)


select * from customer where custid <=2;

select cs.name
from customer cs, orders od
where cs.custid=od.custid
group by cs.name
;

select cs.name
from (select * from customer where custid <=2) cs, orders od
where cs.custid=od.custid
group by cs.name
;

SELECT cs.name, SUM(od.saleprice) "total"
FROM (SELECT custid, name
FROM Customer
WHERE custid <= 2) cs,
Orders od
WHERE cs.custid=od.custid
GROUP BY cs.name;

select rownum, ename from emp;

select rownum,ename,empno,sal
from (select ename, empno, job, deptno, sal from emp order by sal desc)
where rownum <= 3
;


--질의. 평균 주문금액 이하의 주문에 대해서 주문번호와 금액을 보이시오.

SELECT AVG(saleprice) FROM Orders;

SELECT orderid, saleprice 
FROM Orders 
WHERE saleprice <= 
(SELECT AVG(saleprice) FROM Orders);


--질의. 각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해서 
--주문번호, 고객번호, 금액을 보이시오.

SELECT orderid, custid, saleprice 
FROM Orders od 
WHERE saleprice > 
(SELECT AVG(saleprice) FROM Orders so WHERE od.custid=so.custid);


--질의. 대한민국에 거주하는 고객에게 판매한 도서의 총판매액을 구하시오.

SELECT SUM(saleprice) "total" 
FROM Orders 
WHERE custid 
IN (SELECT custid FROM Customer WHERE address LIKE '%대한민국%');


