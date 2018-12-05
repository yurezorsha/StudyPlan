
UPDATE group_units
SET    id_group_components = NULL;

delete from group_components;

INSERT INTO `group_components` 
(`id`,`name`) 
VALUES 
(1,1),
(2,2),
(3,3),
(4,4);
       
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
       id_cathedra = NULL,
       id_plan = NULL;
       
UPDATE semestr
SET    id_type = NULL,
       id_teacher=NULL,
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

INSERT INTO `plan` 
(`id`,`id_speciality`, `set_data_group`) 
VALUES (1, 1, 2009);



       
       



INSERT INTO `node` 
(`id`,`id_subject`, `id_cathedra`, `id_plan`) 
VALUES 
(1,1, 1, 1),
(2,2, 1, 1);
       

       
INSERT INTO `type` 
(`id`, `name`, `koff`) 
VALUES 
(1, 'зачет',0.3),
(2, 'диф. зачет',0.35),
(3, 'экзамен',0.4),
(4, 'просмотр',0.4);
       

INSERT INTO `semestr` 
(`id`,`number`,  `lecture`,   `laboratory`,  `practice`,   `seminar`,  `id_type`,  
`rgr`,  `course_work_type`,  `id_node`,  `ze` ,  `cource_work_ze` ,  `cource_work_hours`, 
`id_teacher`, `id_faculty`, `diplom_hour`, `diplom_ze`, `prac_hour`, `prac_ze` ) 
VALUES   
(1,1, 15, 15, 15, 15, 1, 1, 1, 1, 5, 1, 10, 1, 1, 0, 0, 0, 0);

















