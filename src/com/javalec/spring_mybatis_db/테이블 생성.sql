
--만료되서 비번을 **123으로 바꾸고 NEW ORACLE 설정에서 연결해줌. / 만료되지 않도록 설정해줌.
ALTER USER KH IDENTIFIED BY KH123;
ALTER PROFILE DEFAULT LIMIT PASSWORD_LIFE_TIME UNLIMITED;


--회원 테이블 //회원번호, 아이디, 비밀번호, 이름, 이메일, 전화번호, 포인트, 역할, 탈퇴여부
CREATE SEQUENCE MEMBERSEQ
NOCACHE;

DROP SEQUENCE MEMBERSEQ;

CREATE TABLE MEMBER(
MEMBERNO NUMBER PRIMARY KEY,
ID VARCHAR2(50) NOT NULL,
PW VARCHAR2(50) NOT NULL,
NAME VARCHAR2(50) NOT NULL,
EMAIL VARCHAR2(100) NOT NULL,
PHONE VARCHAR2(20) NOT NULL,
POINT NUMBER,
ROLE VARCHAR(50) NOT NULL,
ENABLED VARCHAR(3) NOT NULL,
CONSTRAINT UQ_ID UNIQUE(ID),
CONSTRAINT UQ_NAME UNIQUE(NAME),
CONSTRAINT UQ_EMAIL UNIQUE(EMAIL),
CONSTRAINT UQ_PHONE UNIQUE(PHONE),
CONSTRAINT CHK_ENABLED CHECK(ENABLED IN('Y', 'N'))
);
--프로필사진 컬럼 추가 (RBOARD 썸네일이랑 같은방법으로 함)
alter table member add (memberImg varchar2(2000));
alter table member add (memberThumbImg varchar2(2000));

--기본값
alter table member modify pw  default 0;
alter table member modify phone  default 0;
ALTER TABLE MEMBER MODIFY POINT DEFAULT 100;
alter table member modify ROLE  default 'user';
alter table member modify enabled  default 'Y';

alter table member modify(pw varchar2(2000));

delete from member where NAME='jei';

--제약조건 취소했다 다시되돌림
select * from user_constraints WHERE TABLE_NAME='MEMBER' AND CONSTRAINT_TYPE='C';
alter table member drop constraint SYS_C007741;
alter table member modify id not null;

--포인트 디폴트100 (회원가입)
ALTER TABLE MEMBER MODIFY POINT DEFAULT 100;
UPDATE MEMBER SET POINT='100' WHERE MEMBERNO='1';
UPDATE MEMBER SET POINT='100' WHERE MEMBERNO='2';

SELECT * FROM MEMBER;


CREATE SEQUENCE MEMBERNAVERSEQ
NOCACHE;
DROP SEQUENCE MEMBERNAVERSEQ;

--네이버 로그인 멤버테이블
CREATE TABLE MEMBERNAVER(
MEMBERNO NUMBER PRIMARY KEY,

ID VARCHAR2(50) NOT NULL,
PW VARCHAR2(50) DEFAULT 0,
NAME VARCHAR2(50) NOT NULL,
EMAIL VARCHAR2(100) NOT NULL,

PHONE VARCHAR2(20),
POINT NUMBER DEFAULT 100,
ROLE VARCHAR(50) DEFAULT 'user',
ENABLED VARCHAR(3) DEFAULT 'Y',

memberImg varchar2(2000),
memberThumbImg varchar2(2000)
);

DROP TABLE MEMBERNAVER;
select * from membernaver;

--레시피게시판 RBOARD  /번호, 제목, 회원아이디, 내용, 날짜, 조회수
--COMMENTCOUNT컬럼은 MYBATIS에서 RBOARDCOMMENTSEQ.NEXT로 넣으면됨.

CREATE SEQUENCE BOARDSEQ
NOCACHE;

DROP SEQUENCE BOARDSEQ;

CREATE TABLE RBOARD(
BOARDNO NUMBER PRIMARY KEY,
TITLE VARCHAR2(2000) NOT NULL,
MEMBERID VARCHAR2(100) NOT NULL,
CONTENT CLOB NOT NULL,
REG_DATE DATE NOT NULL,
READCOUNT NUMBER,
GDSIMG VARCHAR2(2000),
GDSTHUMBIMG VARCHAR2(2000),
FOODKIND VARCHAR2(2000),
COUNTRYKIND VARCHAR2(2000),
TIMEKIND VARCHAR2(2000),
MAJORMAT VARCHAR2(2000),
MINORMAT VARCHAR2(2000)
);
DROP TABLE RBOARD;

alter table rboard modify readcount number default 0;
--댓글수 컬럼 추가
alter table rboard modify (commentcount number default 0 ) ;
--멤버이미지 커럶 추가
alter table rboard add (memberimg varchar2(2000)  ) ;


--작성된 게시글 갯수
select count(*) from RBOARD;
select * from rboard order by boardno;

select to_char(reg_date, 'YYYY-MM-DD') from rboard;
select reg_date from rboard;
update rboard set reg_date= to_char(reg_date, 'YYMMDD') where boardno=52;


--RBOARD테이블 변경
--content 컬럼의 not null 제약조건 없앰
select * from user_constraints WHERE TABLE_NAME='RBOARD';
alter table rboard drop constraint SYS_C007965;

--gdsImg, gdsThumbImg 컬럼 추가

alter table rboard add (gdsImg varchar2(2000));
alter table rboard add (gdsThumbImg varchar2(2000));
alter table rboard drop column gdsImg; 
alter table rboard drop column gdsThumbImg;
alter table rboard 
INSERT INTO RBOARD VALUES(BOARDSEQ.NEXTVAL, '첫번째요리', 'jey', '스테이크', SYSDATE, 1);

-- 기존 컬럼을 삭제합니다. 
ALTER TABLE RBOARD DROP COLUMN CONTENT; 
ALTER TABLE RBOARD DROP COLUMN COMMENTCOUNT;
--CLOB컬럼으로 변경
ALTER TABLE RBOARD ADD (CONTENT CLOB);



--파일테이블
CREATE TABLE FILE_TABLE(
FILE_NUM NUMBER,
O_NAME VARCHAR2(100),
FILE_NAME VARCHAR2(100),
FILE_SIZE NUMBER,
ARTICLE_NUM NUMBER
);
CREATE SEQUENCE FILE_NUM
NOCACHE;
SELECT*FROM FILE_TABLE;
SELECT*FROM RBOARD;



--댓글테이블
CREATE SEQUENCE RBOARDCOMMENTSEQ
NOCACHE;

DROP TABLE RBOARDCOMMENT;
DROP SEQUENCE RBOARDCOMMENTSEQ;


CREATE TABLE RBOARDCOMMENT(
COMMENTNO NUMBER PRIMARY KEY,
BOARDNO NUMBER NOT NULL,
COMMENTWRITER VARCHAR2(50) NOT NULL,
COMMENTCONTENT VARCHAR2(4000) NOT NULL,
COMMENTDATE DATE,
CONSTRAINT FK_NO FOREIGN KEY(BOARDNO) REFERENCES RBOARD(BOARDNO)
);

--게시글(부모)지워지면 자식 자동삭제
ALTER TABLE rboardcomment ADD constraint FK_NO FOREIGN KEY (BOARDNO) 
REFERENCES rboard(boardno) ON DELETE CASCADE;

--멤버프로필사진 컬럼 추가
alter table rboardcomment add (memberImg varchar2(2000));


--회원아이디의 not null제약조건 없앰 --로그인안해도 댓글쓸수있게
select * from user_constraints WHERE TABLE_NAME='RBOARDCOMMENT';
alter table rboardcomment drop constraint FK_NO;

INSERT INTO RBOARDCOMMENT VALUES(RBOARDCOMMENTSEQ.NEXTVAL, 15 , 'j' , '댓글1', SYSDATE );
SELECT * FROM RBOARDCOMMENT;



CREATE TABLE RBOARDLIKE(
BOARDNO NUMBER NOT NULL,
LIKEMEMBERID VARCHAR2(50) NOT NULL
);


select * from rboardlike;







--restau3페이지의 지도에 추가될 데이터
--업소명 행정동명 소재지지번 소재지도로명 전화번호 업태명(일식)
CREATE TABLE RESTAU(
  UPSO_NM VARCHAR2(4000) PRIMARY KEY,
  ADMDNG_NM VARCHAR2(4000), 
  SITE_ADDR VARCHAR2(4000),   
  SITE_ADDR_RD VARCHAR2(4000), 
  UPSO_SITE_TELNO VARCHAR2(4000), 
  SNT_UPTAE_NM VARCHAR2(4000),
  DCB_YMD VARCHAR2(4000)
);
 

SELECT * FROM RESTAU;

SELECT * FROM RESTAU WHERE ADMDNG_NM='논현1동' AND SNT_UPTAE_NM='경약식';

SELECT COUNT(*) FROM RESTAU;



DROP TABLE RESTAU;
--중복된 값 지움
 DELETE FROM restau a
     WHERE ROWID > (SELECT MIN(ROWID) 
                    FROM restau b
                    WHERE b.site_addr = a.site_addr);
                    
--unique제약조건
alter table restau 
add constraint unique_site_addr unique(site_addr);

--삭제
alter table restau 
drop constraint unique_site_addr; 

--null이 아닌값 모두 지워줌. (현존하는 음식점만 남김)
delete from restau where dcb_ymd != 'null';
select * from restau where upso_nm='아띠랑스';
select upso_nm from restau where snt_uptae_nm='경양식';

SELECT COUNT(*) FROM RESTAU;
rollback
commit
SELECT SITE_ADDR_RD FROM RESTAU;

--제약조건
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME='RESTAU';
ALTER TABLE RESTAU DROP CONSTRAINT SYS_C007998; 

--실수로 삭제시
INSERT INTO RESTAU
SELECT * FROM RESTAU AS OF TIMESTAMP(SYSTIMESTAMP-INTERVAL '15' MINUTE);
FLASHBACK TABLE RESTAU TO BEFORE DROP 
ALTER SESSION SET recyclebin = ON;
show recyclebin
SELECT * FROM RECYCLEBIN

update sys.props$ set value$='AL32UTF8' where name='NLS_CHARACTERSET';  
update sys.props$ set value$='AL32UTF8' where name='NLS_NCHAR_CHARACTERSET';  
SELECT * FROM sys.props$
where name like '%CHARACTERSET%';

select * from nls_database_parameters where parameter like 'NLS_LANGUAGE';



select name, value$ from sys.props$;
