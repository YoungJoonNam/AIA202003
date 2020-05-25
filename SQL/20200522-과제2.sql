--[실습] join & sub query
--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
--(5) 박지성이구매한도서의출판사수
--[답]--------------------------------


select count(publisher)
from book 
where bookid in
    (select bookid from orders 
    where custid =
        (select custid from customer where name = '박지성'))
;

--------------------------------

select * from book;
select * from orders;
select * from customer;

select * from customer where name = '박지성';

select * from orders where custid ='1';

select count(*) from book where bookid=1 or bookid=2 or bookid=3;

--(6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이
--[답]--------------------------------
select bookname,price, price -(select saleprice from orders  o where o.bookid=b.bookid) as "차이"
from book b
where bookid in
    (select bookid from orders 
    where custid =
        (select custid from customer where name = '박지성'))
;
--------------------------------
--price - saleprice
select bookname,price, (select saleprice from orders o where o.bookid=b.bookid)
from book b
where bookid in
    (select bookid from orders 
    where custid =
        (select custid from customer where name = '박지성'))
;


select * from book;
select * from orders;
select * from customer;


select * from customer where name = '박지성';

select * from orders where custid ='1';

select *
from book 
where bookid in
    (select bookid from orders 
    where custid =
        (select custid from customer where name = '박지성'))
;

--(7) 박지성이구매하지않은도서의이름
--[답]--------------------------------
select bookname
from book 
where bookid not in
    (select bookid from orders 
    where custid =
        (select custid from customer where name = '박지성'))
;
--------------------------------
--
--2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.
--(8) 주문하지않은고객의이름(부속질의사용)
--[답]--------------------------------
select name from customer
where custid not in
    (select distinct(custid) from orders)
;

--------------------------------

select * from book;
select * from orders;
select * from customer;


--(9) 주문금액의총액과주문의평균금액
--[답]--------------------------------
select sum(saleprice),avg(saleprice)
from orders;
--------------------------------

select * from book;
select * from orders;
select * from customer;


--(10) 고객의이름과고객별구매액
--[답]--------------------------------
select name ,(select sum(saleprice) from orders o where o.custid=c.custid) as "구매액"
from customer c
;
--------------------------------

select * from book;
select * from orders;
select * from customer;



select sum(saleprice) from orders where custid=1;

--(11) 고객의이름과고객이구매한도서목록
--[답]--------------------------------

select 
(select name from customer c where c.custid = o.custid),
(select bookname from book b where b.bookid = o.bookid)
from orders o
where custid in
    (select custid
    from orders
    group by custid)
order by custid    
;
------------------------------

select custid,bookid from orders
where custid in
    (select custid
    from orders
    group by custid)
order by custid    
;


--(12) 도서의가격(Book 테이블)과판매가격(Orders 테이블)의차이가가장많은주문
--[답]--------------------------------
select orderid,(select price from book b where b.bookid=o.bookid)-saleprice as "차이"
from orders o
order by "차이" desc
;



select *
from 
    (select o.orderid, b.price-o.saleprice as 차이
    from book b, orders o 
    where b.bookid = o.bookid
    order by 차이 desc
    ) 
where rownum=1
;
 
--------------------------------
 

select orderid,( as "차이"
from orders o
order by "차이" desc
;

select *
from orders
where orderid = 
    (select orderid,max(차이) from
        (select orderid,(select price from book b where b.bookid=o.bookid)-saleprice as "차이"
        from orders o))
;

(select max(차이) from
        (select orderid,(select price from book b where b.bookid=o.bookid)-saleprice as "차이"
        from orders o));

select rownum, j
from (select job j,avg(sal) avg_sal from emp group by job order by avg_sal)
where rownum <=1
;
----

select (select price from book b where b.bookid=o.bookid)-saleprice as "차이"
from orders o
;

select name ,(select sum(saleprice) from orders o where o.custid=c.custid) as "구매액"
from customer c
;

select * from book;
select * from orders;
select * from customer;





--(13) 도서의판매액평균보다자신의구매액평균이더높은고객의이름
--[답]--------------------------------
select name 
from customer
where custid in
    (select cid from 
        (select o1.custid cid, avg(o1.saleprice) avgo1
        from orders o1
        group by o1.custid)
    where avgo1 >
        (select avg(saleprice) from orders))
;
--------------------------------


select cid,avgo1 from 
    (select o1.custid cid, avg(o1.saleprice) avgo1
    from orders o1
    group by o1.custid)
where avgo1 >
    (select avg(saleprice) from orders)
;



select * from book;
select * from orders;
select * from customer;

select avg(saleprice) from orders
group by custid;

select avg(saleprice) from orders;




--
--3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.
--(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
--[답]--------------------------------
select *
from customer
where custid in
    (select distinct(custid) from orders
    where bookid in
        (select bookid 
        from book
        where publisher in
            (select publisher
            from book 
            where bookid in
                (select bookid from orders 
                where custid =
                    (select custid from customer where name = '박지성')))))
;

select *
from customer
where (custid in
    (select distinct(custid) from orders
    where bookid in
        (select bookid 
        from book
        where publisher in
            (select publisher
            from book 
            where bookid in
                (select bookid from orders 
                where custid =
                    (select custid from customer where name = '박지성')))))
) and name != '박지성';
;



select name from orders o, customer c, book b where o.custid=c.custid and o.bookid = b.bookid
and publisher in (
    select publisher 
    from orders o natural join book b 
    where custid = (select custid from customer where name='박지성'))
and name != '박지성';
--------------------------------

select * from book;
select * from orders;
select * from customer;


--(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
--[답]--------------------------------
select name
from 
    (select name, publisher 
    from  
        (select * from customer c, orders o, book b 
        where c.custid=o.custid and b.bookid=o.bookid))
group by name
having count(distinct publisher) >= 2
;
--------------------------------


select name,publisher
from 
    (select name, publisher 
    from  
        (select * from customer c, orders o, book b 
        where c.custid=o.custid and b.bookid=o.bookid))
;

select * from book;
select * from orders;
select * from customer;

select * from orders
order by custid;
