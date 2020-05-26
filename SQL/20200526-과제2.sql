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


