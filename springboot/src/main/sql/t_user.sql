/*Column Information For - workman.t_user*/
-------------------------------------------

Field      Type          Collation           Null    Key     Default  Extra           Privileges                       Comment
---------  ------------  ------------------  ------  ------  -------  --------------  -------------------------------  -------
t_id       int(11)       (NULL)              NO      PRI     (NULL)   auto_increment  select,insert,update,references
t_name     varchar(30)   utf8mb4_general_ci  YES             (NULL)                   select,insert,update,references
t_age      int(10)       (NULL)              YES             (NULL)                   select,insert,update,references
t_address  varchar(100)  utf8mb4_general_ci  YES             (NULL)                   select,insert,update,references
t_pwd      varchar(100)  utf8mb4_general_ci  YES             (NULL)                   select,insert,update,references

/*Index Information For - workman.t_user*/
------------------------------------------

Table   Non_unique  Key_name  Seq_in_index  Column_name  Collation  Cardinality  Sub_part  Packed  Null    Index_type  Comment  Index_comment  Visible  Expression
------  ----------  --------  ------------  -----------  ---------  -----------  --------  ------  ------  ----------  -------  -------------  -------  ----------
t_user           0  t_id                 1  t_id         A                    0    (NULL)  (NULL)          BTREE                               YES      (NULL)

/*DDL Information For - workman.t_user*/
----------------------------------------

Table   Create Table
------  -------------------------------------------------------------------------------------
t_user  CREATE TABLE `t_user` (
          `t_id` int(11) NOT NULL AUTO_INCREMENT,
          `t_name` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
          `t_age` int(10) DEFAULT NULL,
          `t_address` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
          `t_pwd` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
          UNIQUE KEY `t_id` (`t_id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci
