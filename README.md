# springboot
springboot test

用户登录时会记录用户日志到库中

表信息如下  
CREATE TABLE `t_user` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `t_age` int(10) DEFAULT NULL,
  `t_address` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `t_pwd` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  UNIQUE KEY `t_id` (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
    
CREATE TABLE `t_logger_infos` (
  `ali_id` int(11) NOT NULL AUTO_INCREMENT,
  `ali_client_ip` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ali_uri` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ali_type` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ali_method` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ali_param_data` longtext COLLATE utf8mb4_general_ci,
  `ali_session_id` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ali_time` timestamp NULL DEFAULT NULL,
  `ali_return_time` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ali_return_data` longtext COLLATE utf8mb4_general_ci,
  `ali_http_status_code` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ali_time_consuming` int(8) DEFAULT NULL,
  PRIMARY KEY (`ali_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
