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
       id_cathedra = NULL,
       id_plan = NULL;

UPDATE semestr
SET    id_type = NULL,
       id_teacher=NULL,
       id_node=NULL;
       
UPDATE weeks_semestr
SET    id_semestr = NULL;

delete from type;
delete from semestr;
delete from node;

UPDATE plan
SET    id_speciality = NULL;

delete from plan;





