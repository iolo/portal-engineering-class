# user #

| **Field** | **Type** | **Null** | **Key** | **Default** | **Extra** |
|:----------|:---------|:---------|:--------|:------------|:----------|
| id        | varchar(20) | NO       | PRI     | NULL        |           |
| password  | varchar(38) | YES      |         | NULL        |           |
| name      | varchar(20) | YES      |         |NULL         |           |
|profile    | text        | YES      |         | NULL        |           |
| path      | tinyint(1)  | NO       |         | NULL        |           |


# follow #

| **Field** | **Type** | **Null** | **Key** | **Default** | **Extra** |
|:----------|:---------|:---------|:--------|:------------|:----------|
| id        | varchar(20) | YES      |         | NULL        |           |
| following | varchar(38) | YES      |         | NULL        |           |



# twitt #

| **Field** | **Type** | **Null** | **Key** | **Default** | **Extra** |
|:----------|:---------|:---------|:--------|:------------|:----------|
| twinum       | int(11)  | NO       | PRI     | NULL        | auto\_increment      |
| id        | varchar(20) | YES      |NO       | NULL        |           |
| name      | varchar(20) | NO       |         |NULL         |           |
|content    | text        | YES      |         | NULL        |           |
| write\_date    | tinyint(1)  | NO       |         | NULL        |           |