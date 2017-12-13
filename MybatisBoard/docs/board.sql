
--�Խ��� ������ ���̺�
create table board (
	boardnum 	number 			primary key,	--�Խñ� �Ϸù�ȣ
	name 		varchar2(20) 	not null,  		--�ۼ��� �̸�
	title 		varchar2(200) 	not null, 		--������
	content 	varchar2(2000) 	not null,  		--�۳���
	hits 		number default 0, 				--��ȸ��
	indate 		date default sysdate 			--�ۼ���
);

--�Խ��� �� �Ϸù�ȣ�� ����� ������ ����
create sequence boardseq;

--�Խ��� �� ���� ��
insert into board (boardnum, name, title, content)
values (boardseq.nextval, 'ȫ�浿', '������', '�۳����Դϴ�.');


--���� ���� ���̺�
create table reply (
	replynum	number	primary key,   		--���� �Ϸù�ȣ
	boardnum	number  not null, 			--�����۹�ȣ
	name		varchar2(20) not null, 		--���� �ۼ��� �̸�
	retext		varchar2(1000) not null,  	--���ó���
	constraint reply_fk foreign key(boardnum) 
	references board(boardnum) on delete cascade
);

--���� ���̺� �Ϸù�ȣ�� ����� ������ ����
create sequence replyseq;

--���� ���� ��
insert into reply values (replyseq.nextval, 1, '��ö��', '���ó���');



