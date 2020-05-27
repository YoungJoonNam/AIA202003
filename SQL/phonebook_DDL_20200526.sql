-- phonebook_DDL_20200526


-- 입력 SQL 작성

desc phonebook;

desc contact;

select * from contact;

truncate table contact;


-- 기본 정보 입력
insert into contact 
 (pIdx,name,phoneNumber,address,eMail,type)
values
 ('1','test1','010-1111-1111','SEOUL','1@a.com','univ')
;
-- 학교 친구 정보 입력
insert into contact 
 (pIdx,name,phoneNumber,address,eMail,type,major,grade)
values
 ('2','aaa','010-2222-1111','ANAYANG','22@a.com','univ','MATH','1')
;

insert into contact 
 (pIdx,name,phoneNumber,address,eMail,type,major,grade)
values
 ('5','joshua','010-6675-4341','JEJU','22@a.com','univ','MATH','2')
;

insert into contact 
 (pIdx,name,phoneNumber,address,eMail,type,major,grade)
values
 ('6','BOA','010-5425-2241','HWASUNG','BOA@B.com','univ','ELECTRONIC','1')
;
-- 회사 친구 정보 입력
insert into contact 
 (pIdx,name,phoneNumber,address,eMail,type,company,dept,rank)
values
 ('3','JOHN','010-1671-5412','SEOUL','AVD@DD.com','com','kirin','sales','clerk')
;

insert into contact 
 (pIdx,name,phoneNumber,address,eMail,type,company,dept,rank)
values
 ('7','PET','010-7652-5464','SEOUL','BAT@DD.com','com','OB','marketing','chief')
;

insert into contact 
 (pIdx,name,phoneNumber,address,eMail,type,company,dept,rank)
values
 ('8','KANG','010-9090-9911','SEOUL','KANG@DD.com','com','ECE','general affairs','boss')
;
-- 모임 친구 정보 입력
insert into contact 
 (pIdx,name,phoneNumber,address,eMail,type,cafename,nickname)
values
 ('4','ANA','010-4533-3422','BUSAN','BB@BBB.com','cafe','boxing','bloodpunch')
;

insert into contact 
 (pIdx,name,phoneNumber,address,eMail,type,cafename,nickname)
values
 ('9','KATE','010-5444-3443','GYUNGJOO','KATE@BBB.com','cafe','running','skyrun')
;

insert into contact 
 (pIdx,name,phoneNumber,address,eMail,type,cafename,nickname)
values
 ('10','TRACY','010-2311-8964','GURI','T1@DDC.com','cafe','skydiving','cloudy')
;
--CONSTRAINT CONTACT_TYPE_CK CHECK (type IN('univ', 'com', 'cafe'))
-- pIdx,name,phoneNumber,address,eMail,type,major,grade,company,dept,rank,cafename,nickname


----------------------------------------------------------
-- 수정을 위한 SQL
----------------------------------------------------------
-- 1. 회사 친구의 정보 변경


-- 2. 학교 친구의 정보 변경



----------------------------------------------------------
-- 삭제를 위한 SQL
----------------------------------------------------------
-- 1. 회사 친구의 정보 삭제


-- 2. 학교 친구의 정보 삭제











