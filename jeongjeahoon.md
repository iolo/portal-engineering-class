follow 테이블

follow\_num	int(11)	NO	PRI	NULL	auto\_increment
userid	varchar(20)	YES
followerid	varchar(20)	YES

userinfo 테이블

userid	varchar(20)	NO	PRI	NULL
password	varchar(16)	NO		NULL
name	varchar(20)	NO		NULL
introduce	varchar(200)	YES		NULL
image	varchar(100)	YES		NULL

userpost 테이블

post\_num	int(11)	NO	PRI	NULL	auto\_increment
postid	varchar(20)	YES		NULL
content	varchar(280)	YES		NULL
regdate	timestamp	NO		CURRENT\_TIMESTAMP	on update CURRENT\_TIMESTAMP