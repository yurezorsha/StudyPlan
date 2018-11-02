drop  database if exists study_plan2 ; 
create database study_plan2;
use study_plan2;






CREATE TABLE `group_components` (
  `id` int(10) NOT NULL auto_increment,    
  `name` enum('Государственный компонент', 'Компонент учреждения высшего образования', 'Факультативные дисциплины', 'Дополнительные виды обучения'), 
  
   PRIMARY KEY (`id`)    
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;

INSERT INTO `group_components` VALUES (1,1);
INSERT INTO `group_components` VALUES (2,2);
INSERT INTO `group_components` VALUES (3,3);
INSERT INTO `group_components` VALUES (4,4);

CREATE TABLE `speciality` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `shifr` varchar(50), 
  
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;
  
  INSERT INTO `speciality` (`name`, `shifr`) VALUES 
('Информационные системы и технологии', '1-40 05 01-01'),
('Автоматизация технологических процессов и производств (легкая промышленность)', '1-53 01 01-05');


CREATE TABLE `group_units` (
  `id` int(10) NOT NULL auto_increment,    
  `name` varchar(100), 
  `id_group_components` int(10), 
  
  
   PRIMARY KEY (`id`),
   KEY `FKgrunit` (`id_group_components`),
  CONSTRAINT `FKgrunit` 
  FOREIGN KEY (`id_group_components`) 
  REFERENCES `group_components` (`id`)    
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;
  
  
CREATE TABLE `subject` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(200) NOT NULL,
  `shifr` varchar(50), 
  `id_unit` int(10),
  
  
  PRIMARY KEY (`id`),
  KEY `FKsub` (`id_unit`),
  CONSTRAINT `FKsub` 
  FOREIGN KEY (`id_unit`) 
  REFERENCES `group_units` (`id`)  
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;
  
  

CREATE TABLE `plan` (
  `id` int(10) NOT NULL auto_increment,
  `id_speciality` int(10),  
  `set_data_group` int(10),
  
  
   PRIMARY KEY (`id`),
   KEY `FKpp1` (`id_speciality`),
  CONSTRAINT `FKpp1` 
  FOREIGN KEY (`id_speciality`) 
  REFERENCES `speciality` (`id`)
  
   
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;


CREATE TABLE `node` (
  `id` int(10) NOT NULL auto_increment,
  `id_subject` int(10),
  `id_cathedra` int(10),  
  `id_plan` int(10), 
  
  
  
  PRIMARY KEY (`id`),
  KEY `FK` (`id_subject`),
  CONSTRAINT `FK` 
  FOREIGN KEY (`id_subject`) 
  REFERENCES `subject` (`id`), 
 
  KEY `FK10` (`id_plan`),
  CONSTRAINT `FK10` 
  FOREIGN KEY (`id_plan`) 
  REFERENCES `plan` (`id`)
  

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;


  CREATE TABLE `semestr` (
  `id` int(10) NOT NULL auto_increment,
  `number` int(10) NOT NULL,  
  `lecture` int(10),
  `laboratory` int(10),
  `practice` int(10),
  `seminar` int(10),
  `type` enum('экзамен', 'зачет'),
  `rgr` int(1),
  `course_work_type` enum('work', 'project'),
  `id_node` int(10),
  `ze` int(10),
  `cource_work_ze` int(10),
  `cource_work_hours` int(10),
  `id_teacher` int(10),
  `id_faculty` int(10),
  `diplom_hour` int(10),
  `diplom_ze` int(10),
  `prac_hour` int(10),
  `prac_ze` int(10),
  `id_sub_prac_type` int(10),
    
     
  PRIMARY KEY (`id`),
  KEY `FKS` (`id_node`),
  CONSTRAINT `FKS` 
  FOREIGN KEY (`id_node`) 
  REFERENCES `node` (`id`),
  
  KEY `FKS2` (`id_sub_prac_type`),
  CONSTRAINT `FKS2` 
  FOREIGN KEY (`id_sub_prac_type`) 
  REFERENCES `subject` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;


CREATE TABLE `weeks_semestr` (
  `id` int(10) NOT NULL auto_increment,
  `number_semestr` int(10),
  `count_weeks` int(10),
  `id_plan` int(10),
  
  PRIMARY KEY (`id`),   
  KEY `FKweek` (`id_plan`),
  CONSTRAINT `FKweek` 
  FOREIGN KEY (`id_plan`) 
  REFERENCES `plan` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;



CREATE TABLE `study_programm` (
  `id` int(10) NOT NULL auto_increment,  
  `id_subject` int(10), 
  `date_approve` date, 
  
   PRIMARY KEY (`id`),
   KEY `FKstudy` (`id_subject`),
  CONSTRAINT `FKstudy` 
  FOREIGN KEY (`id_subject`) 
  REFERENCES `subject` (`id`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;


CREATE TABLE `creator_study_programm` (
  `id` int(10) NOT NULL auto_increment,  
  `id_teacher` int(10), 
  `id_study_programm` int(10), 
  
   PRIMARY KEY (`id`),
   KEY `FKcr` (`id_study_programm`),
  CONSTRAINT `FKcr` 
  FOREIGN KEY (`id_study_programm`) 
  REFERENCES `study_programm` (`id`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;


CREATE TABLE `certification` (
  `id` int(10) NOT NULL auto_increment,  
  `id_plan` int(10), 
  
  
   PRIMARY KEY (`id`),
   KEY `FKcerf` (`id_plan`),
  CONSTRAINT `FKcerf` 
  FOREIGN KEY (`id_plan`) 
  REFERENCES `plan` (`id`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;



CREATE TABLE `fakultativ` (
  `id` int(10) NOT NULL auto_increment,  
  `id_plan` int(10), 
  `name` varchar(100), 
  
   PRIMARY KEY (`id`),
   KEY `FKfak` (`id_plan`),
  CONSTRAINT `FKfak` 
  FOREIGN KEY (`id_plan`) 
  REFERENCES `plan` (`id`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;


CREATE TABLE `competence` (
  `id` int(10) NOT NULL auto_increment, 
  `code` varchar(10), 
  `name_competence` varchar(500),
  
  
   PRIMARY KEY (`id`)
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;



CREATE TABLE `sub_competence` (
  `id` int(10) NOT NULL auto_increment,    
  `id_competence` int(10), 
  `id_subject` int(10), 
  
  
   PRIMARY KEY (`id`),
   KEY `FKcom` (`id_competence`),
  CONSTRAINT `FKcom` 
  FOREIGN KEY (`id_competence`) 
  REFERENCES `competence` (`id`),
  
  KEY `FKcom2` (`id_subject`),
  CONSTRAINT `FKcom2` 
  FOREIGN KEY (`id_subject`) 
  REFERENCES `subject` (`id`)    
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;


CREATE TABLE `groups` (
  `id` int(10) NOT NULL auto_increment,   
  `id_plan` int(10), 
  `count_students` int(10), 
  
  
   PRIMARY KEY (`id`),
   KEY `FKgr` (`id_plan`),
  CONSTRAINT `FKgr` 
  FOREIGN KEY (`id_plan`) 
  REFERENCES `plan` (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;
