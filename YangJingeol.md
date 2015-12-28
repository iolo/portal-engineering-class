# user #

| **Field** | **Type** | **Null** | **Key** |
|:----------|:---------|:---------|:--------|
| id        | varchar(30) | NO       | PRI     |
| password  | text     | NO       | NULL    |
| name      | text     | NO       |NULL     |
|explain    | text     | NO       |NULL     |
| image     | text     | NO       |NULL     |


# following #

| **Field** | **Type** | **Null** | **Key** |
|:----------|:---------|:---------|:--------|
| id        | varchar(30) | YES      | NULL    |
| following | varchar(30) |YES       | NULL    |


# jinSNS #

| **Field** | **Type** | **Null** | **Key** |**Auto Increment**|
|:----------|:---------|:---------|:--------|:-----------------|
| index       | int(11)  | NO       | PRI     | NULL             |
| id        | varchar(30)  | NO       | NULL    |NULL              |
| sns       | text     | NO       |NULL     | NULL             |
|date       | text     | NO       |NULL     | NULL             |

