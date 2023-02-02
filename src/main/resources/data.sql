insert into member (nickname,account_Type,quit) values('임대인1','LESSOR',0);
insert into member (nickname,account_Type,quit) values('임대인2','LESSOR',0);
insert into member (nickname,account_Type,quit) values('임대인3','LESSOR',1);

insert into member (nickname,account_Type,quit) values('임차인1','LESSEE',0);
insert into member (nickname,account_Type,quit) values('임차인2','LESSEE',0);
insert into member (nickname,account_Type,quit) values('임차인3','LESSEE',1);

insert into member (nickname,account_Type,quit) values('공인중개사1','REALTOR',0);
insert into member (nickname,account_Type,quit) values('공인중개사2','REALTOR',0);
insert into member (nickname,account_Type,quit) values('공인중개사3','REALTOR',1);

INSERT INTO Article (member_Id, title,deleted) VALUES(1,'제목1!',0);
INSERT INTO Article (member_Id, TITLE,deleted) VALUES(1,'제목2!',0);
INSERT INTO Article (member_Id, TITLE,deleted) VALUES(2,'제목3!',1);

insert into Heart (article_Id,member_Id) values (1,1);
insert into Heart (article_Id,member_Id) values (1,2);
insert into Heart (article_Id,member_Id) values (1,4);
insert into Heart (article_Id,member_Id) values (2,5);
insert into Heart (article_Id,member_Id) values (3,5);


