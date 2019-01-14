drop  database if exists study_plan2 ; 
create database study_plan2;
use study_plan2;


CREATE TABLE `group_components` (
  `id` int(10) NOT NULL auto_increment,    
  `name` enum('Государственный компонент', 'Компонент учреждения высшего образования', 'Факультативные дисциплины', 'Дополнительные виды обучения'), 
  
   PRIMARY KEY (`id`)    
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;


CREATE TABLE `speciality` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `shifr` varchar(50), 
  `qualification` varchar(50),
  
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;
  



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
  `set_year_group` int(4),
  `date_approve` date,
  `count_semesters` int(2),
  `first_year` int(4),
  `second_year` int(4),
  `registration_number` varchar(20),
  `registration_number_standard` varchar(20),
  `protocol_number` int(10),
  `date_protocol` date,
  `file_name` varchar(150),
  `doc` longblob,
  
   PRIMARY KEY (`id`),
   KEY `FKpp1` (`id_speciality`),
  CONSTRAINT `FKpp1` 
  FOREIGN KEY (`id_speciality`) 
  REFERENCES `speciality` (`id`)
  
   
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;


CREATE TABLE `practice` (
  `id` int(10) NOT NULL auto_increment,  
  `id_plan` int(10), 
  `name` varchar(100), 
  `semestr_number` int(2),
  `count_weeks` int(2),
  `ze` double,
  
   PRIMARY KEY (`id`),
   KEY `FKprac` (`id_plan`),
  CONSTRAINT `FKprac` 
  FOREIGN KEY (`id_plan`) 
  REFERENCES `plan` (`id`)  
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

CREATE TABLE `type` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(50),  
  `koff` float,
  
  
   PRIMARY KEY (`id`)

  
   
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;


  CREATE TABLE `semestr` (
  `id` int(10) NOT NULL auto_increment,
  `number` int(10) NOT NULL,  
  `lecture` int(10),
  `laboratory` int(10),
  `practice` int(10),
  `seminar` int(10),
  `id_type` int(10),
  `rgr` int(1),
  `course_work_type` enum('курсовой проект', 'курсовая работа'),
  `id_node` int(10),
  `ze` int(10),
  `cource_work_ze` int(10),
  `cource_work_hours` int(10),
  `id_teacher` int(10),
  `id_faculty` int(10),
  `diplom_hour` int(10),
  `diplom_ze` int(10),
  
     
  PRIMARY KEY (`id`),
  KEY `FKS` (`id_node`),
  CONSTRAINT `FKS` 
  FOREIGN KEY (`id_node`) 
  REFERENCES `node` (`id`),
   KEY `FKtype` (`id_type`),
  CONSTRAINT `FKtype` 
  FOREIGN KEY (`id_type`) 
  REFERENCES `type` (`id`)
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;





CREATE TABLE `weeks_semestr` (
  `id` int(10) NOT NULL auto_increment,
  `number_semestr` int(10),
  `count_weeks` int(10),
  `id_semestr` int(10),
  
  PRIMARY KEY (`id`),   
  KEY `FKweek` (`id_semestr`),
  CONSTRAINT `FKweek` 
  FOREIGN KEY (`id_semestr`) 
  REFERENCES `semestr` (`id`)
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
  `name` varchar(200),
  `id_plan` int(10), 
  `ze` double,
    
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
  `hours` int(2),
  `semester_number` varchar(10),
  
  
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
  `id` int(10) NOT NULL,   
  `id_plan` int(10), 
  `count_students` int(10), 
  
  
   PRIMARY KEY (`id`),
   KEY `FKgr` (`id_plan`),
  CONSTRAINT `FKgr` 
  FOREIGN KEY (`id_plan`) 
  REFERENCES `plan` (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;





INSERT INTO `group_components` VALUES (1,1);
INSERT INTO `group_components` VALUES (2,2);
INSERT INTO `group_components` VALUES (3,3);
INSERT INTO `group_components` VALUES (4,4);

INSERT INTO `speciality` (`name`, `shifr`, `qualification`) VALUES 
('Информационные системы и технологии', '1-40 05 01-01','инженер-программист'),
('Автоматизация технологических процессов и производств (легкая промышленность)', '1-53 01 01-05','инженер по автоматизации');

INSERT INTO `group_units` (`name`, `id_group_components`) VALUES ('Социально-гуманитарный модуль 1', 1);

INSERT INTO `subject` (`name`,`shifr`,`id_unit`) VALUES ('История', 'shifr', 1);
INSERT INTO `subject` (`name`,`shifr`,`id_unit`) VALUES ('Политология', 'shifr', 1);
INSERT INTO `subject` (`name`,`shifr`,`id_unit`) VALUES ('Философия', 'shifr', 1);
INSERT INTO `subject` (`name`,`shifr`,`id_unit`) VALUES ('Экономика', 'shifr', 1);

INSERT INTO `plan` (`id_speciality`,  `set_year_group`, `date_approve`,`count_semesters`,`first_year`,`second_year`, 
                    `registration_number`, `registration_number_standard`, `protocol_number`,`date_protocol`) 
                    VALUES (1, 2013,'2013-06-28', 9, 2013, 2014, 
                    '22д-1-13/раб', 'I 53-1-003/тип', 10,'2013-06-28'); 
                    
INSERT INTO `practice` (`id`,  `id_plan`, `name`, `semestr_number`, `count_weeks`, `ze`) VALUES
					   (1,1,'технологическая',7,3,2.5);
                       
INSERT INTO `fakultativ`(`id`,`id_plan`,`name`, `hours`, `semester_number`) VALUES
                         (1,1,'английский',20,'1,2');
                         
INSERT INTO `certification` (`id`, `name`, `id_plan`, `ze`) VALUES
						    (1,'Государственный экзамен по направлению, специализации.',1, 5.5);
                         
INSERT INTO `node` (`id_subject`, `id_cathedra`, `id_plan`) VALUES (1, 0, 1);

INSERT INTO `type` (`id`, `name`, `koff`) VALUES (1, 'зачет',0.3),(2, 'диф. зачет',0.35),(3, 'экзамен',0.4),(4, 'просмотр',0.4);

INSERT INTO `semestr` (`number`,  `lecture`,   `laboratory`,  `practice`,   `seminar`,  
                      `id_type`,  `rgr`,  `course_work_type`,  `id_node`,  `ze` ,  
                      `cource_work_ze` ,  `cource_work_hours`, `id_teacher`, 
                      `id_faculty`, `diplom_hour`, `diplom_ze`) 
VALUES   
(1, 15, 15, 15, 15, 1, 1, 1, 1, 5, 1, 10, 1, 1, 0, 0),
 (2, 15, 15, 15, 15, 1, 1, 1, 1, 5, 1, 10, 1, 1, 0, 0),
  (3, 15, 15, 15, 15, 1, 1, 1, 1, 5, 1, 10, 1, 1, 0, 0),
   (4, 15, 15, 15, 15, 1, 1, 1, 1, 5, 1, 10, 1, 1, 1, 1);
  
  
INSERT INTO `groups` (`id`,`id_plan`, `count_students`) VALUES (1,1, 20), (2,1, 25);

INSERT INTO `competence` (`code`, `name_competence`) VALUES ('БПК-3', 'Быть способным использовать основные законы электротехники и владеть методами их применения, применять электронные элементы и приборы в системах автоматизации');



