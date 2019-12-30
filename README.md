涉及mysql数据库操作的表如下：  
t_user  CREATE TABLE `t_user` (                                                              
          `t_id` int(11) NOT NULL AUTO_INCREMENT,                                            
          `t_name` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,                      
          `t_age` int(10) DEFAULT NULL,                                                      
          `t_address` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,                  
          `t_pwd` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,                      
          UNIQUE KEY `t_id` (`t_id`)                                                   
          ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci  
