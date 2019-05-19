
UPDATE group_units
SET    id_group_components = NULL;

delete from group_components;

INSERT INTO `group_components` 
(`id`,`name`) 
VALUES 
(1,1),
(2,2),
(3,3);
       
UPDATE subject 
SET    id_unit = NULL;

delete from group_units;      
       
INSERT INTO `group_units` 
(`id`,`name`, `id_group_components`) 
VALUES 
(1,'Социально-гуманитарный модуль 1', 1);

UPDATE node
SET    id_subject = NULL;

UPDATE sub_competence
SET    id_subject = NULL;

UPDATE study_programm
SET    id_subject = NULL;

delete from subject;

INSERT INTO `subject` 
(`id`,`name`,`shifr`,`id_unit`) 
VALUES 
(1,'История', 'Ист', 1),
(2,'Политология', 'Полит', 1),  
(3,'Философия', 'Фил', 1),
(4,'Экономика', 'Эк', 1);

UPDATE node
SET    id_subject = NULL,
       id_plan = NULL;
       
UPDATE semestr
SET    id_type = NULL,

       id_node=NULL;
       
UPDATE weeks_semestr
SET    id_semestr = NULL;

delete from type;
delete from node;
delete from semestr;

UPDATE fakultativ
SET    id_plan = NULL;

UPDATE groups
SET    id_plan= NULL;

UPDATE certification
SET    id_plan = NULL;

UPDATE plan
SET    id_speciality = NULL;

delete from plan;
      
INSERT INTO `type` 
(`id`, `name`, `koff`) 
VALUES 
(1, 'зачет',0.3),
(2, 'диф. зачет',0.35),
(3, 'экзамен',0.4),
(4, 'просмотр',0.4);

delete from speciality;

INSERT INTO `speciality` 
(`id`, `name`, `shifr`) 
VALUES 
(1, 'Информационные системы и технологии','1-40 05 01-01'),
(2, 'Автоматизация технологических процессов и производств (легкая промышленность)','1-53 01 01-05');

INSERT INTO `plan` 
(`id`,`id_speciality`, `set_year_group`,`count_semesters`, `first_year`,`second_year`, `date_approve`,
`date_protocol`,`protocol_number`,`file_name`,`registration_number`,`registration_number_standard`)
VALUES (1, 1, 2009,8,2009,2010,'2009-07-08','2009-07-08',123,null,12414,14124);

INSERT INTO `node` 
(`id`,`id_subject`, `id_cathedra`, `id_plan`) 
VALUES 
(1,1, 1, 1),
(2,2, 1, 1);

INSERT INTO `semestr` 
(`id`,`number`,  `lecture`,   `laboratory`,  `practice`,   `seminar`,  `id_type`,  
`rgr`,  `course_work_type`,  `id_node`,  `ze` ,  `cource_work_ze` ,  `cource_work_hours`, 
`id_teacher`, `id_faculty`, `diplom_hour`, `diplom_ze` )
VALUES   
(1,1, 15, 15, 15, 15, 1, 1, 1, 1, 5, 1, 10, 1, 1, 0, 0);

delete from groups;

INSERT INTO `groups`
(`id`, `id_plan`,`count_students`)
VALUES
(1,1,20);

UPDATE sub_competence
SET    id_competence = NULL;

UPDATE sub_competence
SET    id_subject = NULL;

delete from sub_competence;

delete from competence;

INSERT INTO `competence` (`id`,`code`, `name_competence`) VALUES (1,'БПК-3', 'Быть способным использовать 
                                                                       основные законы электротехники 
                                                                       и владеть методами их применения, 
																	   применять электронные элементы 
																	   и приборы в системах автоматизации');
																	   
																	   
INSERT INTO `sub_competence` (`id`,`id_competence`, `id_subject`) VALUES (1,1,1);

UPDATE creator_study_programm
SET id_study_programm=NULL;

delete from study_programm;

INSERT INTO `study_programm` (`id`,`id_subject`, `date_approve`) VALUES (1,1,'2010-10-05');
delete from creator_study_programm;

INSERT INTO `creator_study_programm` (`id`,`id_teacher`, `id_study_programm`) VALUES (1,1,1),(2,2,1);























