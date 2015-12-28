table :follow

> id	bigint(20)	NO	PRI	NULL
> following\_id	bigint(20)	NO	PRI	NULL

table : user

> id	bigint(20)	NO	PRI	NULL	auto\_increment
> login\_id	varchar(255)	YES		NULL
> password	varchar(255)	YES		NULL
> username	varchar(255)	YES		NULL
> explanation	varchar(255)	YES		NULL
> img\_url	varchar(255)	YES		NULL

table : tweet

> tweet\_id	bigint(20)	NO	PRI	NULL	auto\_increment
> contents	varchar(1024)	YES		NULL
> create\_date	datetime	YES		NULL
> id	bigint(20)	NO	MUL	NULL


