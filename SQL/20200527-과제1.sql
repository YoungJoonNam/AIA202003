-- 전체 친구 리스트
select *   
from phoneInfo_basic b, phoneInfo_univ u, phoneInfo_com c
where b.idx = c.fr_ref(+) and b.idx = u.fr_ref(+)
order by b.idx
;

-- 회사 친구 리스트
select * 
from phoneInfo_basic b, phoneInfo_com c
where b.idx = c.fr_ref
;

-- 학교 친구 리스트
select * 
from phoneInfo_basic b, phoneInfo_univ u
where b.idx = u.fr_ref
;


----------------------------------------------------------
-- 수정을 위한 SQL
----------------------------------------------------------
-- 1. 회사 친구의 정보 변경

-- PET의 지역을 'ANYANG' 으로 변경
update phoneinfo_basic
set fr_address = 'ANYANG'
where fr_name = 'PET'
;

-- JOHN의 회사를 AAA 로 변경, 이메일을 john@AAA.com 로 변경 

update phoneinfo_com
set fr_c_company = 'AAA'
where fr_ref =
 (select idx from phoneinfo_basic where fr_name='JOHN')
;

update phoneinfo_basic
set fr_email = 'john@AAA.com'
where fr_name = 'JOHN'
;

-- 2. 학교 친구의 정보 변경

-- aaa의 이름을 'Ana' 로 변경
update phoneinfo_basic
set fr_name = 'Ana'
where fr_name = 'aaa'
;

-- BOA의 학과를 SCIENCE , 학년을 2 로 변경

update phoneinfo_univ
set fr_u_major = 'SCIENCE', fr_u_year='2'
where fr_ref =
 (select idx from phoneinfo_basic where fr_name='BOA')
;



----------------------------------------------------------
-- 삭제를 위한 SQL
----------------------------------------------------------
-- 1. 회사 친구의 정보 삭제

-- KANG의 정보 삭제

delete from phoneinfo_com
where fr_ref =
 (select idx from phoneinfo_basic where fr_name='KANG')
;

delete from phoneinfo_basic
where fr_name='KANG'
;


-- 2. 학교 친구의 정보 삭제

-- joshua 의 정보 삭제

delete from phoneinfo_univ
where fr_ref =
 (select idx from phoneinfo_basic where fr_name='joshua')
;

delete from phoneinfo_basic
where fr_name='joshua'
;

rollback;


-- 왜래키 설정시 부모의 행이 삭제 될 때 설정
--REFERENCES phoneInfo_basic(idx) on delete 설정 옵션
-- no action : 모두 삭제 불가
-- cascade : 참조를 하고 있는 자식 테이블의 모든 행도 삭제
-- set null : 참조를 하고 있는 자식 테이블의 모든 행의 외래키 컬럼의 값을 null로 변경
-- set default : 참조를 하고 있는 자식 테이블의 모든 행의 외래키 컬럼의 값을 기본값으로 변경
--
--
--create table phoneInfo_univ(
--idx                          number(6),
--fr_u_major                 varchar2(20) default 'N'  
--    CONSTRAINT PINFO_UNIV_FR_U_MAJOR_NN NOT NULL,
--fr_u_year                  number(1) default '1'
--    CONSTRAINT PINFO_UNIV_FR_U_YEAR_NN NOT NULL,
--fr_ref                       number(6)
--    CONSTRAINT PINFO_UNIV_FR_REF_NN NOT NULL,
--CONSTRAINT PINFO_UNIV_IDX_PK primary key(idx),
--CONSTRAINT PINFO_UNIV_FR_REF_FK FOREIGN KEY(fr_ref) REFERENCES phoneInfo_basic(idx) on delete,
--CONSTRAINT PINFO_UNIV_FR_U_YEAR_CK CHECK (fr_u_year IN('1', '2', '3', '4'))
--);



