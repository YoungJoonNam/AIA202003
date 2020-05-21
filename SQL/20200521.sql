select * from tab;

select * from emp;
select * from dept;

select * from emp, dept
order by emp.ename
;


select ename, dname, e.deptno
from emp e, dept d
where e.deptno = d.deptno
;


select *
from emp e, salgrade s
where e.sal >= s.losal and e.sal <= s.hisal
;

select ename, sal, grade
from emp e, salgrade s
where e.sal >= s.losal and e.sal <= s.hisal
;

select ename, sal, grade
from emp e, salgrade s
where sal between losal and hisal
;


select empl.ename || '의 매니저는'
|| manager.ename || '입니다'
From emp empl, emp manager
where empl.mgr = manager.empno(+)
;



select empl.ename,empl.empno,empl.sal,empl.comm,nvl(manager.ename,'관리자없음')
From emp empl, emp manager
where empl.mgr = manager.empno(+)
;

select * 
from emp
cross join
dept
;


select * from emp inner join dept on emp.deptno = dept.deptno;


select * from emp inner join dept on emp.deptno = dept.deptno;

select *
from emp e left outer join emp m
on e.mgr=m.empno
;


select *
from emp e right outer join emp m
on e.mgr=m.empno
;
