CREATE TABLE `follow` (
> `userid` varchar(20) NOT NULL COMMENT '사용자아이디',
> `followid` varchar(20) NOT NULL COMMENT '대상아이디',
> PRIMARY KEY (`userid`,`followid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `twituser` (
> `userid` varchar(20) NOT NULL COMMENT '사용자아이디',
> `password` varchar(20) NOT NULL COMMENT '비밀번호',
> `username` varchar(20) NOT NULL COMMENT '성명',
> `introduce` varchar(500) NOT NULL COMMENT '소개',
> `photo` varchar(25) DEFAULT NULL COMMENT '프로필이미지',
> PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='사용자테이블';

CREATE TABLE `userpost` (
> `userid` varchar(20) NOT NULL COMMENT '사용자아이디',
> `sequ_number` int(11) NOT NULL AUTO\_INCREMENT COMMENT '순번',
> `content` varchar(300) DEFAULT NULL COMMENT '내용',
> `write_date` timestamp NULL DEFAULT CURRENT\_TIMESTAMP COMMENT '작성일자',
> PRIMARY KEY (`userid`,`sequ_number`),
> KEY `sequ_number` (`sequ_number`)
) ENGINE=InnoDB AUTO\_INCREMENT=14 DEFAULT CHARSET=utf8;