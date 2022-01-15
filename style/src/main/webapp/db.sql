insert into post values(post_seq.nextval, '2', '1', '1', sysdate, '�ڸ�Ʈt', '1', '0');
insert into post values(post_seq.nextval, '2', '1', '1', sysdate, '�ڸ�Ʈt', '1', '0');
insert into post values(post_seq.nextval, '2', '1', '1', sysdate, '�ڸ�Ʈt', '1', '0');
insert into post values(post_seq.nextval, '2', '1', '1', sysdate, '�ڸ�Ʈt', '1', '0');
insert into post values(post_seq.nextval, '2', '1', '1', sysdate, '�ڸ�Ʈt', '1', '0');
insert into post values(post_seq.nextval, '2', '1', '1', sysdate, '�ڸ�Ʈt', '1', '0');
insert into post values(post_seq.nextval, '2', '1', '1', sysdate, '�ڸ�Ʈt', '1', '0');
insert into post values(post_seq.nextval, '2', '1', '1', sysdate, '�ڸ�Ʈt', '1', '0');
insert into post values(post_seq.nextval, '2', '1', '1', sysdate, '�ڸ�Ʈt', '1', '0');
insert into post values(post_seq.nextval, '2', '1', '1', sysdate, '�ڸ�Ʈt', '1', '0');
insert into post values(post_seq.nextval, '2', '1', '1', sysdate, '�ڸ�Ʈt', '1', '0');
insert into post values(post_seq.nextval, '2', '1', '1', sysdate, '�ڸ�Ʈt', '1', '0');
insert into post values(post_seq.nextval, '2', '1', '1', sysdate, '�ڸ�Ʈt', '1', '0');
insert into post values(post_seq.nextval, '2', '1', '1', sysdate, '�ڸ�Ʈt', '1', '0');
insert into post values(post_seq.nextval, '2', '1', '1', sysdate, '�ڸ�Ʈt', '1', '0');
insert into post values(post_seq.nextval, '2', '1', '1', sysdate, '�ڸ�Ʈt', '1', '0');




--���������̺� ����ϰ� �ٽû������ּ���(12��29��)
create table item(
i_no varchar2(20 char) primary key,
i_color varchar2(20 char) not null,
i_price varchar2(200 char) not null,
i_type varchar2(200 char) not null,
i_post_review varchar2(20 char) not null,
i_post_daily varchar2(20 char) not null
);
--������
CREATE sequence item_seq;

insert into item values(item_seq.nextval, 'color', '2000', '����', '����Ʈ�������̺�','����Ʈ���ϸ����̺�');

select * from item;

--����
create table users(
u_id varchar2(200 char) primary key,
u_pw varchar2(20 char) not null,
u_name varchar2(20 char) not null,
u_nickname varchar2(200 char) not null,
u_email varchar2(200 char) not null,
u_gender varchar2(200 char) not null,
u_style varchar2(200 char) not null,
u_profileImg varchar2(1000 char) not null,
u_typeOfManager varchar2(200 char) not null,
u_checkPoint varchar2(200 char) not null
);

select distinct u_profileImg, u_nickname from users, post_review where u_nickname = p_user;

insert into users values('���̵�', '���', '�̸�', '�г���', '�̸���', '����', '������', '����.jpg', '0', '1');

--20220110 ���� �⼮ ��¥ �÷� �߰�
ALTER TABLE users add u_checkDate VARCHAR2(100 char) default 0 not null;
--���� ��ü ������
update users set u_typeOfManager = '�����';
--���� ��ü ���� 100
update users set u_checkPoint = '100';
--��ý��¥ �ʱ�ȭ
update users set u_checkDate = '0';

select * from users;

--���ϸ�����Ʈ
create table post_daily(
p_no varchar2(20 char) primary key,
p_title varchar2(20 char) not null,
p_text varchar2(300 char) not null,
p_good varchar2(20 char) not null,
p_top varchar2(200 char) not null,
p_pants varchar2(200 char) not null,
p_shoes varchar2(200 char) not null,
p_accessary varchar2(300 char) not null,
p_hashtag varchar2(300 char) not null,
p_img varchar2(300 char) not null,
p_date date not null,
p_item varchar2(300 char) not null,
p_comment varchar2(300 char) not null,
p_user varchar2(300 char) not null,
p_view_count number(38) default 0,
p_price varchar2(300 char)
);

CREATE sequence post_daily_seq;

insert into post_daily values(post_daily_seq.nextval, 'title','text', '���ƿ�', '����', '����', '�Ź�', '�Ǽ�����', '�ؽ��±�', '�̹���', sysdate, '������t', '�ڸ�Ʈt', 'userT');

select * from post_daily;

drop table post_daily cascade constraint purge;

--��������Ʈ
create table post_review(
p_no varchar2(20 char) primary key,
p_title varchar2(20 char) not null,
p_text varchar2(300 char) not null,
p_good varchar2(20 char) not null,
p_top varchar2(200 char) not null,
p_pants varchar2(200 char) not null,
p_shoes varchar2(200 char) not null,
p_accessary varchar2(300 char) not null,
p_hashtag varchar2(300 char) not null,
p_img varchar2(300 char) not null,
p_date date not null,
p_item varchar2(300 char) not null,
p_comment varchar2(300 char) not null,
p_user varchar2(300 char) not null,
p_view_count number(38) default 0,
p_price varchar2(300 char)
);

CREATE sequence post_review_seq;

insert into post_review values(post_review_seq.nextval, 'title','text', '���ƿ�', '����', '����', '�Ź�', '�Ǽ�����', '�ؽ��±�', '�̹���', sysdate, '������t', '�ڸ�Ʈt', 'userT');

select * from post_review;

drop table post_review cascade constraint purge;

--���
create table comments(
c_no varchar2(20 char) primary key,
c_text varchar2(20 char) not null,
c_date date not null,
c_users varchar2(200 char) not null,
c_post varchar2(200 char) not null
);

CREATE sequence comments_seq;

insert into comments values(comments_seq.nextval, '����', sysdate, '����t', '����Ʈt');

select * from comments;

--������
create table post(
p_no varchar2(20 char) primary key,
p_title varchar2(20 char) not null,
p_text varchar2(20 char) not null,
p_img varchar2(300 char) not null,
p_date date not null,
p_comment varchar2(300 char) not null,
p_user varchar2(300 char) not null
);

CREATE sequence post_seq;

drop sequence post_seq;

insert into post values(post_seq.nextval, 'ŷ��11','text', '�̹���', sysdate, '�ڸ�Ʈt', 'userT');

select * from post;

--������
create table postA(
p_no varchar2(20 char) primary key,
p_title varchar2(20 char) not null,
p_text varchar2(20 char) not null,
p_img varchar2(300 char) not null,
p_date date not null,
p_comment varchar2(300 char) not null,
p_user varchar2(300 char) not null,
p_view_count number(10) default 0 not null
);

CREATE sequence postA_seq;


insert into postA values(postA_seq.nextval, 'ŷ��11','text', '�̹���', sysdate, '�ڸ�Ʈt', 'userT',0);

select * from postA;
--���ǰ�

create table postQ(
p_no varchar2(20 char) primary key,
p_title varchar2(20 char) not null,
p_text varchar2(20 char) not null,
p_img varchar2(300 char) not null,
p_date date not null,
p_comment varchar2(300 char) not null,
p_user varchar2(300 char) not null,
p_view_count number(10) default 0 not null
);

CREATE sequence postQ_seq;



insert into postQ values(postQ_seq.nextval, 'ŷ��11','text', '�̹���', sysdate, '�ڸ�Ʈt', 'userT',0);

select * from postQ;

--ȿ���� ����
drop table POST;

select * from ( select rownum num, P.* from (select * from post order by p_date desc) P)"
						+ " where num between 1 and 33;
						
delete post where p_no=23;



--delete ���̺�
delete from item;
delete from users;
delete from post_daily;
delete from post_review;
delete from comments;
delete from post;
--drop ���̺�
drop table item;						
drop table users;						
drop table post_daily;						
drop table post_review;						
drop table comments;						
drop table post;	
--drop������
drop sequence item_seq;
drop sequence users_seq;
drop sequence post_daily_seq;
drop sequence post_review_seq;
drop sequence comments_seq;
drop sequence post_seq;

-- ��ȸ�� Ȯ���� ���� �÷��߰�
alter table post add p_view_count number(10) default 0 not null;

-- �ܷ�Ű �缳���� ���� drop
ALTER TABLE comments DROP constraint fk_cno;

-- �ۻ����� ��ۻ����� ���� �ǰ� ����
ALTER TABLE comments ADD CONSTRAINT fk_cno FOREIGN KEY (c_post) REFERENCES post(p_no) ON DELETE CASCADE;
--20220108������
alter table post_review add p_view_count number(38) default 0;

select * from comments group by c_post; 

SELECT c_post , count(*) noc FROM comments_post_review GROUP BY c_post;


-- 1�� 13�� �ϱ⳻�� �߰��ʿ�

create table comments_post_review(
c_no varchar2(20 char) primary key,
c_text varchar2(20 char) not null,
c_date date not null,
c_users varchar2(200 char) not null,
c_post varchar2(200 char) not null
);
create table comments_post_daily(
c_no varchar2(20 char) primary key,
c_text varchar2(20 char) not null,
c_date date not null,
c_users varchar2(200 char) not null,
c_post varchar2(200 char) not null
);
create table comments_postQ(
c_no varchar2(20 char) primary key,
c_text varchar2(20 char) not null,
c_date date not null,
c_users varchar2(200 char) not null,
c_post varchar2(200 char) not null
);
create table comments_postA(
c_no varchar2(20 char) primary key,
c_text varchar2(20 char) not null,
c_date date not null,
c_users varchar2(200 char) not null,
c_post varchar2(200 char) not null
);

select * from comments_post_review;
select * from comments_post_daily;
select * from comments_postQ;
select * from comments_postA;

ALTER TABLE comments_post_review ADD CONSTRAINT fk_review FOREIGN KEY (c_post) REFERENCES post_review(p_no) ON DELETE CASCADE;
ALTER TABLE comments_post_daily ADD CONSTRAINT fk_daily FOREIGN KEY (c_post) REFERENCES post_daily(p_no) ON DELETE CASCADE;
ALTER TABLE comments_postQ ADD CONSTRAINT fk_qna FOREIGN KEY (c_post) REFERENCES postQ(p_no) ON DELETE CASCADE;
ALTER TABLE comments_postA ADD CONSTRAINT fk_anno FOREIGN KEY (c_post) REFERENCES postA(p_no) ON DELETE CASCADE;


-- �ϱ�� ���೻�� Ȯ�ο� sql���Դϴ�.

SELECT * FROM    ALL_CONSTRAINTS
WHERE    TABLE_NAME = 'comments';

select* from user_constraints;
select* from user_constraints where TABLE_NAME like '%COMMENTS%';

--1�� 13�� ���ƿ� �߰�
create table likebox(
l_no varchar2(20 char) primary key,
l_checkstatus varchar2(2 char) not null,
l_date date not null,
l_users varchar2(200 char) not null,
l_post varchar2(200 char) not null
);
select * from user_sequences;

CREATE sequence likebox_seq;

insert into likebox values(likebox_seq.nextval, '1', sysdate, 'userT','41');

select * from likebox;

ALTER TABLE likebox ADD CONSTRAINT fk_like FOREIGN KEY (l_post) REFERENCES post_review(p_no) ON DELETE CASCADE;

--1�� 13�� 8�� ���� �߰�

alter table likebox add constraint uq_test unique (l_post, l_users);


SELECT l_post , count(*) nol FROM likebox group by l_post;

--1��14�Ϻ�й�ȣ ���� �ִ����(varchar2)����
alter table users modify(u_pw varchar2(200 char));
--�����ڵ�� �����
update USERS set u_typeOfManager = '���̾�' where u_id = (���̵�);

--1.14 added
create table likebox2(
l_no varchar2(20 char) primary key,
l_checkstatus varchar2(2 char) not null,
l_date date not null,
l_users varchar2(200 char) not null,
l_post varchar2(200 char) not null
);

CREATE sequence likebox2_seq;

select * from likebox2;

ALTER TABLE likebox2 ADD CONSTRAINT fk_like2 FOREIGN KEY (l_post) REFERENCES post_daily(p_no) ON DELETE CASCADE;

alter table likebox2 add constraint uq_test2 unique (l_post, l_users);