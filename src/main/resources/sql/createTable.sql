
create table if not exists `Address` (
  `id` bigint NOT NULL,
  `addrLine1` varchar(50) NOT NULL,
  `addrLine2` varchar(50) NOT NULL,
  `city` varchar(30) NOT NULL,
  `country` varchar(30) NOT NULL,
  `district` varchar(30) NOT NULL,
  `landmark` varchar(50) DEFAULT NULL,
  `pincode` int NOT NULL,
  `state` varchar(30) NOT NULL,
  `refID` int NOT NULL,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

create table if not exists `bank_details` (
  `bank_id` int NOT NULL AUTO_INCREMENT,
  `bank_name` varchar(49) DEFAULT NULL,
  `bank_ifsc` varchar(11) DEFAULT NULL,
  `bank_branch` varchar(74) DEFAULT NULL,
  `bank_address` varchar(195) DEFAULT NULL,
  `bank_city` varchar(50) DEFAULT NULL,
  `bank_district` varchar(50) DEFAULT NULL,
  `bank_state` varchar(26) DEFAULT NULL,
  PRIMARY KEY (`bank_id`)
) ENGINE=InnoDB AUTO_INCREMENT=127858 DEFAULT CHARSET=utf8mb3;

create table if not exists `Data` (
  `id` bigint NOT NULL,
  `descp` varchar(255) DEFAULT NULL,
  `phone` bigint DEFAULT NULL,
  `pin` int DEFAULT NULL,
  `title` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

create table if not exists `Education` (
  `id` bigint NOT NULL,
  `course` varchar(255) NOT NULL,
  `courseType` int NOT NULL,
  `education` varchar(255) NOT NULL,
  `endDate` datetime DEFAULT NULL,
  `institute` varchar(255) DEFAULT NULL,
  `refID` bigint NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `result` varchar(10) DEFAULT NULL,
  `resultType` int NOT NULL,
  `specialization` varchar(255) NOT NULL,
  `startDate` datetime DEFAULT NULL,
  `university` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

create table if not exists `files` (
  `id` bigint NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `data` longblob NOT NULL,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

create table if not exists  `Users` (
  `id` bigint NOT NULL,
  `created_on` datetime DEFAULT NULL,
  `emailID` varchar(50) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `mobileNo` varchar(255) NOT NULL,
  `userType` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
