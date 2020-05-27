-- 전체 친구 리스트
select *   
from phoneInfo_basic b, phoneInfo_univ u, phoneInfo_com c
where b.idx = c.fr_ref(+) and b.idx = u.fr_ref(+)
order by b.idx
;

-- VIEW : pb_all_view

CREATE OR REPLACE VIEW pb_all_view 
AS 
select b.idx, b.fr_name, b.fr_phonenumber, b.fr_address, b.fr_regdate, u.fr_u_major, u.fr_u_year, c.fr_c_company   
from phoneInfo_basic b, phoneInfo_univ u, phoneInfo_com c
where b.idx = c.fr_ref(+) and b.idx = u.fr_ref(+)
order by b.idx
;

select * from pb_all_view;

-- 회사 친구 리스트
select * 
from phoneInfo_basic b, phoneInfo_com c
where b.idx = c.fr_ref
;

-- view : pb_com_view

CREATE OR REPLACE VIEW pb_com_view 
AS 
select b.idx, b.fr_name, b.fr_phonenumber, b.fr_address, b.fr_regdate, c.fr_c_company    
from phoneInfo_basic b, phoneInfo_com c
where b.idx = c.fr_ref
;

select * from pb_com_view;

-- 학교 친구 리스트
select * 
from phoneInfo_basic b, phoneInfo_univ u
where b.idx = u.fr_ref
;


-- view : pb_univ_view

CREATE OR REPLACE VIEW pb_univ_view 
AS 
select b.idx, b.fr_name, b.fr_phonenumber, b.fr_address, b.fr_regdate, u.fr_u_major, u.fr_u_year
from phoneInfo_basic b, phoneInfo_univ u
where b.idx = u.fr_ref
;

select * from pb_univ_view;