--create table board(
--num NUMBER primary key ,
--writer varchar2(10) not null, --�ۼ��� id
--email1 varchar2(30), -- �̸���1
--email2 varchar2(30), -- �̸���2
--subject varchar2(50) not null,-- ������
--passwd varchar2(12) not null,--��й�ȣ
--reg_date timestamp(6) not null,--�ۼ���
--readcount NUMBER default 0,--��ȸ��
--ref NUMBER not null,-- �� �׷� ��ȣ
--re_step NUMBER not null, -- ���� �׷쿡�� �� ��� ����
--re_level NUMBER not null, -- ��� ����
--content varchar2(4000) not null -- �� ����
--);
--
--CREATE SEQUENCE board_seq;
--
--
--drop table board


create table qboard(
qnum NUMBER primary key ,
qwriter varchar2(30) not null, --�ۼ��� id
qemail1 varchar2(30), -- �̸���1
qemail2 varchar2(30), -- �̸���2
qsubject varchar2(50) not null,-- ������
qpasswd varchar2(15) not null,--��й�ȣ
qreg_date timestamp(6) not null,--�ۼ���
qreadcount NUMBER default 0,--��ȸ��
qref NUMBER not null,-- �� �׷� ��ȣ
qre_step NUMBER not null, -- ���� �׷쿡�� �� ��� ����
qre_level NUMBER not null, -- ��� ����
qcontent varchar2(4000) not null -- �� ����
);

CREATE SEQUENCE qboard_seq;


drop table qboard

alter table qboard 
modify writer varchar2(20);
