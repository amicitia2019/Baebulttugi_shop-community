create table board(
num NUMBER primary key ,
writer varchar2(10) not null, --�ۼ��� id
email1 varchar2(30), -- �̸���1
email2 varchar2(30), -- �̸���2
subject varchar2(50) not null,-- ������
passwd varchar2(12) not null,--��й�ȣ
reg_date timestamp(6) not null,--�ۼ���
readcount NUMBER default 0,--��ȸ��
ref NUMBER not null,-- �� �׷� ��ȣ
re_step NUMBER not null, -- ���� �׷쿡�� �� ��� ����
re_level NUMBER not null, -- ��� ����
content varchar2(4000) not null -- �� ����
);

CREATE SEQUENCE board_seq;


drop table board