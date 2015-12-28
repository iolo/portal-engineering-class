User Table


| **Field** | **Type** | **Null** | **Key** | **Default** |
|:----------|:---------|:---------|:--------|:------------|
| Id        | varchar(30) | NO       | PRI     | NULL        |
| Password  | text     | YES      |         | NULL        |
| Name      | text     | YES      |         | NULL        |
| Information | text     | NO       |         | NULL        |
| ImageURI  | text     | YES      |         | NULL        |


Twitt Table
| **Field** | **Type** | **Null** | **Key** | **Default** |
|:----------|:---------|:---------|:--------|:------------|
| id        | varchar(30) | NO       | MUL     | NULL        |
| twiitText | text     | NO       |         | NULL        |
| writeDate | text     | NO       |         | NULL        |
| twiitNumber | text     | NO       |         | NULL        |



Follow Talbe
| **Field** | **Type** | **Null** | **Key** | **Default** |
|:----------|:---------|:---------|:--------|:------------|
| id        | varchar(30) | NO       | MUL     | NULL        |
| following | varchar(30) |          | NO      | NULL        |



늦어서 죄송합니다. 내려가서 원격으로 하는데 서버가 내려갔네요..