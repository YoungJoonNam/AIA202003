-- 전화번호 관리 프로그램
-- 이름, 전화번호, 생일, 이메일
-- 전공, 학년
-- 부서이름, 직급
-- 모임이름, 닉네임

-- 대리키 : 일련번호 ->  pIdx    ( p_idx   member_idx, memberIDX)

-- 전화번호 부 (Contact)

--===== 전화번호 부( Contact )

-- 대리키 : 일련번호 -> pIdx
-- 이름, 전화번호, 주소, 이메일 <- 기본정보 : not null
-- 주소값과 이메일은 입력이 없을 때 기본값 입력  : 디폴트 속성
-- 친구의 타입 (카테고리) : univ, com, cafe 세가지 값만 저장 가능 : 체크제약

------ 선택 정보
-- 전공, 학년
-- 회사이름, 부서이름, 직급
-- 모임이름, 닉네임

CREATE TABLE CONTACT( 
pIdx              varchar2(10),
name            varchar2(20) CONSTRAINT CONTACT_NAME_NN NOT NULL,
phoneNumber varchar2(20) CONSTRAINT CONTACT_PHONENUMBER_NN NOT NULL,
address          varchar2(50) DEFAULT 'Nothing' CONSTRAINT CONTACT_ADDRESS_NN NOT NULL,
eMail             varchar2(20) DEFAULT 'Nothing' CONSTRAINT CONTACT_EMAIL_NN NOT NULL,
type              varchar2(4),  
major             varchar2(20),  
grade             number(1),  
company         varchar2(50),  
dept              varchar2(20),
rank              varchar2(20),  
cafename        varchar2(50),  
nickname        varchar2(20),
CONSTRAINT CONTACT_PIDX_PK PRIMARY KEY(pIdx),
CONSTRAINT CONTACT_TYPE_CK CHECK (type IN('univ', 'com', 'cafe'))
);


desc contact;











