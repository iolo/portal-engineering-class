# user #

|userNum|	int(11)|	NO|	PRI|	NULL|	auto\_increment|
|:------|:-------|:--|:---|:----|:---------------|
|id     |	varchar(512)|	NO	|		  |     |                |                |
|password|	varchar(512)|	NO|		  |	    |                |
|name   |	varchar(512)|	NO		|	   |     |                |
|description|	varchar(512)|	YES	|    |	NULL	|                |
|profileImg|	varchar(512)|	YES	|    |	NULL	|                |

# tweet #

|seq|	int(11)|	NO|	PRI|	NULL	|auto\_increment|
|:--|:-------|:--|:---|:-----|:--------------|
|userNum|	int(11)|	NO	|MUL |	NULL	|               |
|message	|text    |	NO|		  |NULL	 |               |
|date|	datetime	|NO |		  |NULL	 |               |

# follow #

|userNum	|int(11)|	NO	|PRI|	NULL	|
|:-------|:------|:---|:--|:-----|
|followingUserNum	|int(11)	|NO	 |PRI	|NULL	 |