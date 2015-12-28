DB 구조 입니다.
```
mysql> desc user;
+-----------+--------------+------+-----+----------------------+-------+
| Field     | Type         | Null | Key | Default              | Extra |
+-----------+--------------+------+-----+----------------------+-------+
| id        | varchar(20)  | NO   | PRI |                      |       |
| password  | varchar(100) | YES  |     | NULL                 |       |
| name      | varchar(10)  | NO   |     |                      |       |
| introduce | text         | NO   |     | NULL                 |       |
| image     | varchar(100) | NO   |     | DefaultUserImage.jpg |       |
+-----------+--------------+------+-----+----------------------+-------+
5 rows in set (0.00 sec)

mysql> desc ssiggle;
+-------+--------------+------+-----+-------------------+-----------------------------+
| Field | Type         | Null | Key | Default           | Extra                       |
+-------+--------------+------+-----+-------------------+-----------------------------+
| id    | int(11)      | NO   | PRI | NULL              | auto_increment              |
| text  | varchar(255) | NO   |     |                   |                             |
| time  | timestamp    | NO   |     | CURRENT_TIMESTAMP | on update CURRENT_TIMESTAMP |
| user  | varchar(20)  | NO   | MUL | NULL              |                             |
+-------+--------------+------+-----+-------------------+-----------------------------+
4 rows in set (0.00 sec)

mysql> desc following;
+-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| user      | varchar(10) | NO   | PRI |         |       |
| following | varchar(10) | NO   | PRI |         |       |
+-----------+-------------+------+-----+---------+-------+
2 rows in set (0.00 sec)
```