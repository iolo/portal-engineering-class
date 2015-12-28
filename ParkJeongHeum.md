# DB 테이블 목록 #

**follow	 Browse	  Structure	 Search	  Insert	 Empty	  Drop	13	MyISAM	utf8\_general\_ci**

**member	 Browse	  Structure	 Search	  Insert	 Empty	  Drop	11	MyISAM	utf8\_general\_ci**

**twit	 Browse	  Structure	 Search	  Insert	 Empty	  Drop	12	MyISAM	utf8\_general\_ci**

# follow 테이블 #
**1	target	varchar(20)	utf8\_general\_ci		No	None**

**2	follower	varchar(20)	utf8\_general\_ci		No	None**

# member 테이블 #
**1	id	varchar(20)	utf8\_general\_ci		No	None**

**2	name	varchar(20)	utf8\_general\_ci		No	None**

**3	password	varchar(38)	utf8\_general\_ci		No	None**

**4	comment	text	utf8\_general\_ci		No	None**

**5	image	varchar(20)	utf8\_general\_ci		No	None**

# twit 테이블 #
**1	id	int(11)			No	None	AUTO\_INCREMENT**

**2	writer	varchar(20)	utf8\_general\_ci		No	None**

**3	twit\_text	text	utf8\_general\_ci		No	None**

