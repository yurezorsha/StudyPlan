UPDATE group_units
SET    id_group_components = NULL;

delete from group_components;

UPDATE subject 
SET    id_unit = NULL;

delete from group_units;  

UPDATE node
SET    id_subject = NULL;

UPDATE sub_competence
SET    id_subject = NULL;

UPDATE study_programm
SET    id_subject = NULL;

delete from subject;

UPDATE fakultativ
SET    id_plan = NULL;

UPDATE certification
SET    id_plan = NULL;

UPDATE groups
SET    id_plan= NULL;

UPDATE node
SET    id_subject = NULL,
       id_plan = NULL;

UPDATE semestr
SET    id_type = NULL,
       id_node=NULL;
       
UPDATE weeks_semestr
SET    id_semestr = NULL;

delete from type;
delete from semestr;
delete from node;

UPDATE plan
SET    id_speciality = NULL;

delete from plan;

delete from speciality;

delete from groups;

UPDATE sub_competence
SET    id_competence = NULL;

delete from competence;

UPDATE sub_competence
SET    id_subject = NULL;

delete from sub_competence;

UPDATE creator_study_programm
SET id_study_programm=NULL;

delete from study_programm;

delete from creator_study_programm;





