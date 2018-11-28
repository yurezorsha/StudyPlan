UPDATE semestr
SET    id_type = NULL;

delete from type;
INSERT INTO `type` 
(`id`, `name`, `koff`) 
VALUES 
(1, 'зачет',0.3),
(2, 'диф. зачет',0.35),
(3, 'экзамен',0.4),
(4, 'просмотр',0.4);