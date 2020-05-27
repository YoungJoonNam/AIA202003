-- 과제3

create table phoneInfo_basic(
idx                          number(6),
fr_name                    varchar2(20) CONSTRAINT PINFO_BASIC_FRNAME_NN NOT NULL,
fr_phonenumber         varchar2(20) CONSTRAINT PINFO_BASIC_FRPHONENUMBER_NN NOT NULL,
fr_email                    varchar2(20),
fr_address                 varchar2(20),
fr_regdate                 date default SYSDATE,
CONSTRAINT PHONEINFO_BASIC_IDX_PK primary key(idx)
);

desc phoneInfo_basic;

--delete  from phoneInfo_basic;

create table phoneInfo_univ(
idx                          number(6),
fr_u_major                 varchar2(20) default 'N'  
    CONSTRAINT PINFO_UNIV_FR_U_MAJOR_NN NOT NULL,
fr_u_year                  number(1) default '1'
    CONSTRAINT PINFO_UNIV_FR_U_YEAR_NN NOT NULL,
fr_ref                       number(6)
    CONSTRAINT PINFO_UNIV_FR_REF_NN NOT NULL,
CONSTRAINT PINFO_UNIV_IDX_PK primary key(idx),
CONSTRAINT PINFO_UNIV_FR_REF_FK FOREIGN KEY(fr_ref) REFERENCES phoneInfo_basic(idx),
CONSTRAINT PINFO_UNIV_FR_U_YEAR_CK CHECK (fr_u_year IN('1', '2', '3', '4'))
);

--drop table phoneInfo_univ;
desc phoneInfo_univ;

create table phoneInfo_com(
idx                          number(6),
fr_c_company            varchar2(20) default 'N'  
    CONSTRAINT PINFO_COM_FR_U_MAJOR_NN NOT NULL,
fr_ref                       number(6)
    CONSTRAINT PINFO_COM_FR_REF_NN NOT NULL,
CONSTRAINT PINFO_COM_IDX_PK primary key(idx),
CONSTRAINT PINFO_COM_FR_REF_FK FOREIGN KEY(fr_ref) REFERENCES phoneInfo_basic(idx)
);

desc phoneInfo_com;


select * from phoneInfo_basic;
select * from phoneInfo_univ;
select * from phoneInfo_com;

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

-- 학교 친구 정보 입력

insert into phoneInfo_basic 
 (idx,fr_name,fr_phonenumber,fr_email,fr_address)
values
 ('1','aaa','010-2222-1111','22@a.com','ANAYANG')
;

insert into phoneInfo_univ 
 (idx,fr_u_major,fr_u_year,fr_ref)
values
 ('1','MATH','1','1')
;


insert into phoneInfo_basic 
 (idx,fr_name,fr_phonenumber,fr_email,fr_address)
values
 ('2','joshua','010-6675-4341','22@a.com','JEJU')
;

insert into phoneInfo_univ 
 (idx,fr_u_major,fr_u_year,fr_ref)
values
 ('2','MATH','2','2')
;

insert into phoneInfo_basic 
 (idx,fr_name,fr_phonenumber,fr_email,fr_address)
values
 ('3','BOA','010-5425-2241','BOA@B.com','HWASUNG')
;

insert into phoneInfo_univ 
 (idx,fr_u_major,fr_ref)
values
 ('3','ELECTRONIC','3')
;


-- 회사 친구 정보 입력

insert into phoneInfo_basic 
 (idx,fr_name,fr_phonenumber,fr_email,fr_address)
values
 ('4','JOHN','010-1671-5412','AVD@DD.com','SEOUL')
;

insert into phoneInfo_com 
 (idx,fr_c_company,fr_ref)
values
 ('1','kirin','4')
;


insert into phoneInfo_basic 
 (idx,fr_name,fr_phonenumber,fr_email,fr_address)
values
 ('5','PET','010-7652-5464','BAT@DD.com','SEOUL')
;

insert into phoneInfo_com 
 (idx,fr_c_company,fr_ref)
values
 ('2','OB','5')
;


insert into phoneInfo_basic 
 (idx,fr_name,fr_phonenumber,fr_email,fr_address)
values
 ('6','KANG','010-9090-9911','KANG@DD.com','SEOUL')
;

insert into phoneInfo_com 
 (idx,fr_c_company,fr_ref)
values
 ('3','ECE','6')
;
