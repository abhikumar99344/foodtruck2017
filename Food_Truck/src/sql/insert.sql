/*admin insert*/
insert into admin values('admin@gmail.com','admin','010-2644-5584');
insert into admin values('admin01@naver.com','admin01','010-5561-8445');


/*seller insert*/
insert into seller values('seller@daum.net','seller','������','010-7566-5921');
insert into seller values('seller01@naver.com','seller01','������','010-1234-2165');
insert into seller values('seller02@gmail.com','seller02','������','010-1234-2165');

/*license_no insert*/
insert into license_no values('2208183676','seller@daum.net');
insert into license_no values('1048636968','seller01@naver.com');
insert into license_no values('5215685165','seller02@gmail.com');
insert into license_no values('2266165516','seller02@gmail.com');
insert into license_no values('6516523553','seller02@gmail.com');
insert into license_no values('6565165166','seller01@naver.com');
insert into license_no values('1631165353','seller02@gmail.com');
insert into license_no values('5165133515','seller@daum.net');
insert into license_no values('6545135555','seller@daum.net');
insert into license_no values('6553633533','seller@daum.net');

/*foodtruck insert*/
insert into foodtruck values('2208183676','�Ƿ�����','010-8559-4645','����� ���Ǳ�','Y','N','Y',1.6,'img1.png','37.50179833140776','127.024631510072',01);
insert into foodtruck values('1048636968','BBQ','010-8559-5116','����� ����','N','Y','Y',2.3,'img2.png','37.501483068205566','127.02420165745722',01);
insert into foodtruck values('5215685165','�̽�������','010-8559-4645','����� ���빮��','Y','N','Y',2.4,'img3.png','37.50053696312773','127.02443884199365',02);
insert into foodtruck values('2266165516','��������','010-8559-5116','����� ��õ��','Y','N','Y',1.9,'img4.png','37.49870963045177','127.0269346568284',02);
insert into foodtruck values('6516523553','7��������','010-8559-4625','����� ������','Y','N','Y',5.0,'img5.png',NULL,NULL,02);
insert into foodtruck values('1631165353','������','010-8559-4645','����� ��������','Y','N','Y',2.3,'img6.png',NULL,NULL,02);
insert into foodtruck values('5165133515','�Ե�����','010-8559-4645','����� ���α�','Y','N','Y',2.0,NULL,NULL,NULL,03);
insert into foodtruck values('6545135555','��ȫ','010-8559-5116','����� ������','Y','N','Y',1.1,NULL,NULL,NULL,04);
insert into foodtruck values('6553633533','1�ΰ�����','010-8559-4645',NULL,'N','N','N',0.0,NULL,NULL,NULL,04);

/*product insert*/
insert into product values(2017121165,'������ �ʴ�','����Ű�� ������ ���ٸ� �ſ���� �ʴ߰� �̱��� ��Ƣ��',18000,'2208183676');
insert into product values(2017121166,'����ġŲ','����, ��¬�� �޴�',18000,'2208183676');
insert into product values(2017121167,'�������̵�','20�������� õ�� ������ �ø��� ���Ϸ� ���ְ� Ƣ�ܳ� ���ο� ġŲ',18900,'1048636968');
insert into product values(2017121168,'Ȳ�ݿø���ġŲ','���� ���� ���� ����, �Ծ� ������ ������ ����� ����',16000,'1048636968');
insert into product values(2017121169,'�λ꺣�','LGƮ������ ���� �丮���ִ� ������ ����',16000,'5215685165');
insert into product values(2017121170,'����ġ��ġŲ','���ִ� ����ġ��ġŲ',15000,'2266165516');
insert into product values(2017121171,'������������+�ܼ�����+�ӽ���+���̵�','���ִ� ������',12900,'6516523553');
insert into product values(2017121172,'�����ӹ�',NULL,10000,'1631165353');
insert into product values(2017121173,'�������� �����',NULL,9000,'5165133515');
insert into product values(2017121174,'������ġ��',NULL,8500,'6545135555');
insert into product values(2017121175,'�ݹ�','��Ʈ���� �ٰ�Ʈ�� ������ ���� �� ���� Ư��ҽ�..',7500,'6553633533');
insert into product values(2017121176,'�ϳ��� ��ȭ��¥','���Ͼ�ħ ���� �̴� ���� ������ ���Ұ��, ����, �������� �Բ�',18000,'6553633533');
insert into product values(2017121177,'�ϳ��� �ұ���','���� �ð� ���� �ѿ���� ��������',18900,'1631165353');
insert into product values(2017121178,'�Ի� ���������','��Ի�� ���, ������  ������ä�� �ҽ��� ���Ƴ� ����� ������',16000,'5165133515');
insert into product values(2017121179,'¥��','���� ������� ��Ʈ�� ���� ���̹���',16000,'1631165353');

/*member insert*/
insert into member values('user@naver.com','user','������','010-5498-6165');
insert into member values('user01@daum.net','user01','������','010-4352-2346');

/*orders insert*/
insert into orders values(123456789112344,'������','010-5498-6165',SYSDATE,'2017/12/13','Y','user@naver.com');
insert into orders values(123456789112345,'��ٽ�','010-5595-5816',SYSDATE,'2017/12/13','Y',null);
insert into orders values(123456789112346,'������','010-5595-5826',SYSDATE,'2017/12/13','N',null);

/*orderdetail insert*//*���⼭���� ����*/
insert into orderdetail values(2017121165,123456789112344,1,18000);
insert into orderdetail values(2017121166,123456789112344,2,36000);
insert into orderdetail values(2017121179,123456789112345,4,64000);
insert into orderdetail values(2017121178,123456789112345,2,32000);
insert into orderdetail values(2017121171,123456789112346,1,18900);

/*deliverydetail insert*/
insert into deliverydetail values(123456789112344,0,'����� ������ ��Ʈ��ǻ�� r45','2017/12/13');
insert into deliverydetail values(123456789112345,1,'����� ������ ��Ʈ��ǻ�� r45','2017/12/13');

/*review insert*/
insert into review values('2208183676',1,'�����Ҿ��',sysdate, 0, 'N',10.0,'user@naver.com');
insert into review values('2208183676',2,'����� �� ������ �ƽ����� ���־����',sysdate, 0, 'N',5.0,'user@naver.com');
insert into review values('2208183676',3,'���� �־� ���ĳ��Դٰ� ��������...',sysdate, 0, 'N',1.0, 'user@naver.com');

commit;
