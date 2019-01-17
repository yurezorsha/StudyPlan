API REST SERVICE STUDY PLAN
===========================
### http://localhost:8080/studyplan
Система Study Plan осущетвляет создание, хранение, редактирование учебных планов для университета.
А также формирование учебной нагрузки за определенный период веремени.
Система состоит из связанных таблиц. Работа с таблицами осуществляется посредством использования 
соответствующих API. API для работы с системой Study Plan представлены в таблице.

| Разделы    |  Описание |
| ----------| ----------|
| [Certification](#certification)        | api для работы с аттестациями  |
| [Competence](#competence)            | api для работы со справочником компетенциями  |
| [CreatorStudyProgram](#creatorstudyprogram)   | api для работы с создателями учебной программы  |
| [Fakultativ](#fakultativ)           | api для работы с факультативами |
| [GroupComponent](#groupcomponent)        | api для работы с групповыми компонентами |
| [GroupUnit](#groupunit)             | api для работы с группами модулей |
| [Group](#group)                 | api для работы с группами  |
| [Node](#node)                  | api для работы с записями плана |
| [Plan](#plan)                 | api для работы с планами |
| [Practice](#practice)                 | api для работы с практиками |
| [Semestr](#semestr)               | api для работы с семестрами  |
| [Speciality](#speciality)            | api для работы со специальностями  |
| [StudyProgram](#studyprogram)          | api для работы с учебной программой |
| [SubCompetence](#subcompetence)         | api для работы со списоком компетенций для дисцилины  |
| [Subject](#subject)               |api для работы со справочником дисциплин  |
| [Type](#type)                  |api для работы со справочником оценки знаний  |
| [WeeksSemestr](#weekssemestr)          | api для работы с неделями в семестре  |
| [Errors](#errors)          | ошибки, которые могут возникнуть при работе |



Certification
--------------

| Запрос    | URL                  | Описание |
| :----------:|:--------------------| ---------|
| GET       | /certification/{id}   | Получить Certification по id|
| GET       | /certifications/{id}  | Получить все Certifications по id(Plan)|
| POST      | /certifications/{id}  | Добавить список Certifications по id(Plan)|
| DELETE    | /certification/{id}   | Удалить Certification по id|
| PUT       | /certifications/{id}  | Обновить список Certifications по id(Plan)|

Формат ответа:
GET localhost:8080/studyplan/certification/1
```javascript

{
    "id": 1,
    "name": "Государственный экзамен по направлению, специализации.",
    "ze": 5.5
}
```
| Поле    | Описание |
| :----------:|:--------------------|
| id       |  Идентификатор аттестации|
| name       |  Название аттестации|
| ze       |  Количество зачетных единиц по семестру|



Competence
--------------

| Запрос    | URL                  | Описание |
| :----------:|:--------------------| ---------|
| GET       | /competence/{id}   | Получить Competence по id |
| GET       | /competence        | Получить список всех Competences |
| POST      | /competence        | Добавить Competence |
| DELETE    | /competence/{id}   | Удалить Competence по id |
| PUT       | /competence        | Обновить Competence |

Формат ответа:
GET localhost:8080/studyplan/competence/1

```javascript

{
    "id": 1,
    "code": "БПК-3",
    "nameCompetence": "Быть способным использовать основные законы электротехники и владеть методами их применения, применять электронные элементы и приборы в системах автоматизации"
}
```
| Поле    | Описание |
| :----------:|:--------------------|
| id       |  Идентификатор компетенции|
| code       |  Код компетенции|
| nameCompetence       |  Содержание компетенции|


CreatorStudyProgram
--------------

| Запрос    | URL                  | Описание |
| :----------:|:--------------------| ---------|
| GET       | /creatorstudyprogram/{id}   | Получить CreatorStudyProgram по id |
| GET       | /creatorstudyprograms/{id}  | Получить все CreatorStudyPrograms по id(StudyProgram) |
| GET       | /creatorstudyprogram        | Получить список всех CreatorStudyPrograms |
| POST      | /creatorstudyprogram        | Добавить CreatorStudyProgram |
| DELETE    | /creatorstudyprogram/{id}   | Удалить CreatorStudyProgram по id |
| PUT       | /creatorstudyprogram        | Обновить CreatorStudyProgram |

Формат ответа:
GET localhost:8080/studyplan/creatorstudyprogram/1

```javascript
{
    "id": 1,
    "idTeacher": 1,
    "studyProgramm": {
       
    }
}
```
| Поле    | Описание |
| :----------:|:--------------------|
| id       |  Идентификатор создателя учебной программы|
| idTeacher       |  Идентификатор преподавателя|
| studyProgramm       |  Ссылка на учебную программу|


Fakultativ
--------------

| Запрос    | URL                  | Описание |
| :----------:|:--------------------| ---------|
| GET       | /fakultativ/{id}   | Получить Fakultativ по id |
| GET       | /fakultatives/{id} | Получить все Fakultatives по id(Plan) |
| POST      | /fakultatives/{id} | Добавить список Fakultatives по id(Plan)|
| DELETE    | /fakultativ/{id}   | Удалить Fakultativ по id |
| PUT       | /fakultatives/{id} | Обновить список Fakultatives по id(Plan) |

Формат ответа:
GET localhost:8080/studyplan/fakultativ/1

```javascript
{
    "id": 1,
    "name": "английский",
    "hours": 20,
    "semesterNumber": 1
}
```
| Поле    | Описание |
| :----------:|:--------------------|
| id       | Идентификатор факультатива|
| name       |  Название факультатива|
| hours       |  Количесиво часов факультатива|
| semesterNumber       |  Номер семестра, в котором есть факультатив|


GroupComponent
--------------

| Запрос    | URL                  | Описание |
| :----------:|:--------------------| ---------|
| GET       | /groupcomponent/{id}   | Получить GroupComponent по id |
| GET       | /groupcomponent        | Получить список всех GroupComponents |
| POST      | /groupcomponent        | Добавить GroupComponent |
| DELETE    | /groupcomponent/{id}   | Удалить GroupComponent по id |
| PUT       | /groupcomponent        | Обновить GroupComponent |

Формат ответа:
GET localhost:8080/studyplan/groupcomponent/1

```javascript
{
    "id": 1,
    "name": "Государственный компонент"
}
```
| Поле    | Описание |
| :----------:|:--------------------|
| id       | Идентификатор государственного компонента|
| name       |  Название государственного компонента|



GroupUnit
--------------

| Запрос    | URL                  | Описание |
| ----------|:--------------------:| ---------|
| GET       | /groupunit/{id}   | Получить GroupUnit по id |
| GET       | /groupunits/{id}  | Получить все GroupUnits по id(GroupComponent) |
| GET       | /groupunit        | Получить список всех GroupUnits |
| POST      | /groupunit        | Добавить GroupUnit |
| DELETE    | /groupunit/{id}   | Удалить GroupUnit по id |
| PUT       | /groupunit        | Обновить GroupUnit |

Формат ответа:
GET localhost:8080/studyplan/groupunit/1

```javascript
{
    "id": 1,
    "name": "Социально-гуманитарный модуль 1",
    "groupComponent": {
       
    }
}
```
| Поле    | Описание |
| :----------:|:--------------------|
| id       | Идентификатор группы модулей|
| name       |  Название группы модулей|
| groupComponent      |  Ссылка на групповой компонент|



Subject
--------------

| Запрос    | URL                  | Описание |
| :----------:|:--------------------| ---------|
| GET       | /subject/{id}   | Получить Subject по id |
| GET       | /subjects/{id}  | Получить все Subjects по id(GroupUnit) |
| GET       | /subject        | Получить список всех Subject |
| POST      | /subject        | Добавить Subject |
| DELETE    | /subject/{id}   | Удалить Subject по id |
| PUT       | /subject        | Обновить Subject |

Формат ответа:
GET localhost:8080/studyplan/subject/1

```javascript
{
        "id": 1,
        "name": "История",
        "shifr": "shifr",
        "groupUnit": {
            
        }
    }
 ```
 | Поле    | Описание |
| :----------:|:--------------------|
| id       | Идентификатор предмета|
| name       |  Наименование предмета|
| shifr      |  Шифр предмета|
| groupUnit      |  Ссылка на группу модулей|
 

Group
--------------

| Запрос    | URL                  | Описание |
| :----------:|:--------------------| ---------|
| GET       | /group/{id}   | Получить Group по id |
| GET       | /groups/{id}  | Получить все Groups по id(Plan) |
| GET       | /group        | Получить список всех Groups |
| POST      | /group        | Добавить Group |
| DELETE    | /group/{id}   | Удалить Group по id |
| PUT       | /group        | Обновить Group |

Формат ответа:
GET localhost:8080/studyplan/group/3

```javascript
{
    "id": 3,
    "plan": null,
    "count_students": 26
}
```
 | Поле    | Описание |
| :----------:|:--------------------|
| id       | Идентификатор группы|
| plan       |  Ссылка на план|
| count_students      |  Количество студентов в группе|




Type
--------------

| Запрос    | URL                  | Описание |
| :----------:|:--------------------| ---------|
| GET       | /type/{id}   | Получить Type по id |
| GET       | /type        | Получить список всех Types |
| POST      | /type        | Добавить Type |
| DELETE    | /type/{id}   | Удалить Type по id |
| PUT       | /type        | Обновить Type |

Формат ответа:
GET localhost:8080/studyplan/type/1

```javascript
{
    "id": 1,
    "name": "зачет",
    "koff": 0.3
}
```
 | Поле    | Описание |
| :----------:|:--------------------|
| id       | Идентификатор типа|
| name       |  Наименование типа|
| koff      |  Коэффициент за тип|



Semestr
--------------

| Запрос    | URL                  | Описание |
| :----------:|:--------------------| ---------|
| GET       | /semestr/{id}   | Получить Semestr по id |
| GET       | /semesters/{id}  | Получить все Semestrs по id(Node) |
| GET       | /semestr/sum/{id}| Получить кол-во часов всех пар в Semestr с id |
| POST      | /semesters/{id}   | Добавить список Semestrs в Node с id |
| DELETE    | /semestr/{id}   | Удалить Semestr по id |
| PUT       | /semesters /{id}  | Обновить Semestr в Node с id |

Формат ответа:
GET localhost:8080/studyplan/semestr/1

```javascript
{
    "id": 1,
    "courceWorkHours": 10,
    "courceWorkZe": 1,
    "courseWorkType": "курсовой проект",
    "idFaculty": 1,
    "idTeacher": 1,
    "laboratory": 15,
    "lecture": 15,
    "number": 1,
    "practice": 15,
    "rgr": 1,
    "seminar": 15,
    "type": {
       
    },
    "ze": 5,
    "diplomHour": 0,
    "diplomZe": 0
}
```
 | Поле    | Описание |
| :----------:|:--------------------|
| id       | Идентификатор семестра|
| courceWorkHours       |  Количество часов по курсовой работе|
| courceWorkZe      |  Количество зачетных единиц по курсовой работе|
| courseWorkType       | Тип курсовой работы(курсовая работа или курсовой проект)|
| idFaculty       |  Идентификатор факультета|
| idTeacher      |  Идентификатор преподавателя|
| laboratory       |  Количество лабораторных часов|
| lecture      |  Количество лекционных часов|
| number       |  Номер семестра|
| practice      |  Количество практических часов|
| rgr       | Количество расчетно-графических работ|
| seminar      |  Коэффициент за тип|
| type       | Ссылка на тип оценки знаний|
| ze      |  Количество зачетных единиц по семестру|
| diplomHour       | Количество часов диплома|
| diplomZe       | Количество зачетных единиц диплома|



Node
--------------

| Запрос    | URL                  | Описание |
| :----------:|:--------------------| ---------|
| GET       | /node/{id}   | Получить Node по id |
| GET       | /nodes/{id}  | Получить все Nodes по id(Plan) |
| GET       | /node        | Получить список всех Nodes |
| POST      | /node/{id}   | Добавить Node в Plan с id |
| DELETE    | /node/{id}   | Удалить Node по id |
| PUT       | /node/{id}   | Обновить Node в Plan с id |

Получение записи по id
Формат ответа:
GET localhost:8080/studyplan/node/2

```javascript
{
    "id": 2,
    "idCathedra": 0,
    "subject": {
       
    },
    "semestrs": []
}
```
 | Поле    | Описание |
| :----------:|:--------------------|
| id       | Идентификатор записи|
| idCathedra       |  Идентификатор кафедры|
| subject      | Ссылка на предмет|
| semestrs       | Массив семестров для предмета|



Plan
--------------

| Запрос    | URL                  | Описание |
| :----------:|:--------------------| ---------|
| GET       | /plan/{id}   | Получить Plan по id |
| GET       | /plans/{id}  | Получить все Plan по id(Speciality) |
| GET       | /plan        | Получить список всех Plans |
| GET       | /plan/{id}/data  | Получить учебную нагрузку по id(Plan) за год |
| GET       | /plan/file/{id}  | Скачать doc-файл Plan по id|
| POST      | /plan/file/{id} | Загрузить doc-файл Plan по id|
| POST      | /plan        | Добавить Plan |
| DELETE    | /plan/{id}   | Удалить Plan по id |
| PUT       | /plan        | Обновить Plan |


Получение плана по id
Формат ответа:
GET localhost:8080/studyplan/plan/1

```javascript
{
    "id": 1,
    "setYearGroup": 2013,
    "dateApprove": "2013-06-28",
    "countSemesters": 9,
    "firstYear": 2013,
    "secondYear": 2014,
    "registrationNumber": "22д-1-13/раб",
    "registrationNumberStandard": "I 53-1-003/тип",
    "protocolNumber": 10,
    "dateProtocol": "2013-06-28",
    "practices": [
       
    ],
    "certifications": [
        
    ],
    "fakultativs": [
       
    ],
    "nodes": [
        
    ],
    "speciality": {
       
    }
}

```

 | Поле    | Описание |
| :----------:|:--------------------|
| id       | Идентификатор плана|
| setYearGroup       |  Год создания плана для групп|
| dateApprove      |  Дата утверждения плана|
| countSemesters       | Количество семестров|
| firstYear       | Год начала действия плана|
| secondYear       |  Год конца действия плана|
| registrationNumber      |  Регистрационный номер плана|
| registrationNumberStandard       | Регистрационный номер типового плана|
| protocolNumber       | Номер протокола утверждения плана|
| dateProtocol       |  Дата протокола утверждения плана|
| practices      |  Ссылка на практику|
| certifications       | Ссылка на аттестацию|
| fakultativs      |  Ссылка на факультатив|
| nodes       | Массив записей|
| speciality       | Ссылка на специальность|



Получения нагрузки за определенный год
Формат ответа:
GET localhost:8080/studyplan/plan/1/data/?year=2014

```javascript
{
    "loadSubjects": [
        {
            "idTeacher": 1,
            "semestrNumber": 3,
            "countLecture": 15,
            "countLaboratory": 15,
            "countPractice": 15,
            "countSeminar": 15,
            "type": "зачет",
            "courceWorkHours": 10,
            "idGroup": 1,
            "countStudents": 20,
            "idSubject": 1,
            "nameSubject": "История",
            "calcField": 6
        },
        {
            "idTeacher": 1,
            "semestrNumber": 3,
            "countLecture": 15,
            "countLaboratory": 15,
            "countPractice": 15,
            "countSeminar": 15,
            "type": "зачет",
            "courceWorkHours": 10,
            "idGroup": 2,
            "countStudents": 25,
            "idSubject": 1,
            "nameSubject": "История",
            "calcField": 7.5000005
        }
    ],
    "loadDiploma": [
        {
            "semestrNumber": 4,
            "idGroup": 1,
            "countStudents": 20,
            "idSubject": 1,
            "nameSubject": "История",
            "diplomZe": 1,
            "diplomHour": 1
        },
        {
            "semestrNumber": 4,
            "idGroup": 2,
            "countStudents": 25,
            "idSubject": 1,
            "nameSubject": "История",
            "diplomZe": 1,
            "diplomHour": 1
        }
    ],
    "loadPractice": [
        {
            "semestrNumber": 2,
            "idGroup": 1,
            "countStudents": 20,
            "idSubject": 4,
            "nameSubject": "Экономика",
            "pracZe": 1,
            "pracHour": 1
        }
    ]
}
```

loadSubjects – нагрузка по предметам

| Поле    | Описание |
| :----------:|:--------------------|
| idTeacher       | Идентификатор преподавателя|
| semestrNumber       |  Номер семестра|
| countLecture      |  Количество часов лекций|
| countLaboratory       | Количество часов лабораторных работ|
| countPractice       | Количество часов практических работ|
| countSeminar       |  Количество часов семинаров|
| type      |  Тип оценки знаний|
| courceWorkHours       | Количество часов курсовой|
| idGroup       | Идентификатор учебной группы|
| countStudents       |  Количество студентов группы|
| idSubject      |  Идентификатор предмета|
| nameSubject       | Наименование предмета|
| calcField      |  Расчетное поле (количество студентов/сумма часов)|

loadDiploma – нагрузка по диплому

| Поле    | Описание |
| :----------:|:--------------------|
| semestrNumber       |  Номер семестра|
| idGroup      |  Количество часов лекций|
| countStudents       |  Количество студентов группы|
| idSubject      |  Идентификатор предмета|
| nameSubject       | Наименование предмета|
| diplomZe      |  Количество зачетных единиц диплома|
| diplomHour      |  Количество часов диплома|

loadPractice – нагрузка по практике

| Поле    | Описание |
| :----------:|:--------------------|
| semestrNumber       |  Номер семестра|
| idGroup      |  Количество часов лекций|
| countStudents       |  Количество студентов группы|
| idSubject      |  Идентификатор предмета|
| nameSubject       | Наименование предмета|
| pracZe      |  Количество зачетных единиц практики|
| pracHour      |  Количество часов практики|



Practice
--------------

| Запрос    | URL                  | Описание |
| :----------:|:--------------------| ---------|
| GET       | /practice/{id}    | Получить Practice по id |
| GET       | /practices/{id}   | Получить список всех Practices по id(Plan)|
| POST      | /practices/{id}   | Добавить список Practices по id(Plan) |
| DELETE    | /practice/{id}   | Удалить Practice по id |
| PUT       | /practices/{id}     | Обновить список Practices по id(Plan) |

Формат ответа:
GET localhost:8080/studyplan/practice/1

```javascript
{
    "id": 1,
    "name": "технологическая",
    "semestrNumber": 7,
    "countWeeks": 3,
    "ze": 2.5
}
```
| Поле    | Описание |
| :----------:|:--------------------|
| id       |  Идентификатор практики|
| name      |  Наименование практики |
| semestrNumber       |  Номер семестра, в котором есть практика|
| idSubject      |  Идентификатор предмета|
| countWeeks       | Продолжительность практики в неделях|
| ze      |  Количество зачетных единиц практики|




Speciality
--------------

| Запрос    | URL                  | Описание |
| :----------:|:--------------------| ---------|
| GET       | /speciality/{id}   | Получить Speciality по id |
| GET       | /speciality        | Получить список всех Specialities |
| POST      | /speciality        | Добавить Speciality |
| DELETE    | /speciality/{id}   | Удалить Speciality по id |
| PUT       | /speciality        | Обновить Speciality |

Формат ответа:
GET localhost:8080/studyplan/speciality/1

```javascript
{
    "id": 1,
    "name": "Информационные системы и технологии",
    "shifr": "1-40 05 01-01",
    "qualification": "инженер-программист"
}
```
| Поле    | Описание |
| :----------:|:--------------------|
| id       |  Идентификатор специальности|
| name      |  Наименование специальности |
| shifr       |  Шифр специальности|
| qualification      |  Квалификация специалиста|




StudyProgram
--------------

| Запрос    | URL                  | Описание |
| :----------:|:--------------------| ---------|
| GET       | /studyprogram/{id}   | Получить StudyProgram по id |
| GET       | /studyprograms/{id}  | Получить все StudyPrograms по id(Subject) |
| GET       | /studyprogram        | Получить список всех StudyPrograms |
| POST      | /studyprogram        | Добавить StudyProgram |
| DELETE    | /studyprogram/{id}   | Удалить StudyProgram по id |
| PUT       | /studyprogram        | Обновить StudyProgram |

Формат ответа:
GET localhost:8080/studyplan/studyprogram/1

```javascript

{
    "id": 1,
    "dateApprove": "2020-08-20",
    "subject": {
       
    }
}
```
| Поле    | Описание |
| :----------:|:--------------------|
| id       |  Идентификатор учебной программы|
| dateApprove      |  Дата утверждения учебной программы |
| subject       |  Ссылка на предмет |



SubCompetence
--------------

| Запрос    | URL                  | Описание |
| :----------:|:--------------------| ---------|
| GET       | /subcompetence/{id}   | Получить SubCompetence по id |
| GET       | /subcompetences/{id}  | Получить все SubCompetences по id(Subject) |
| GET       | /subcompetence        | Получить список всех SubCompetences |
| POST      | /subcompetence        | Добавить SubCompetence |
| DELETE    | /subcompetence/{id}   | Удалить SubCompetence по id |
| PUT       | /subcompetence        | Обновить SubCompetence |

Формат ответа:
GET localhost:8080/studyplan/subcompetence/1

```javascript
{
    "id": 1,
    "competence": {
        
    },
    "subject": {
       
    }
}

```
| Поле    | Описание |
| :----------:|:--------------------|
| id       |  Идентификатор под-компетенции|
| competence      |  Ссылка на компетенцию |
| subject       |  Ссылка на предмет|



WeeksSemestr
--------------

| Запрос    | URL                  | Описание |
| :----------:|:--------------------| ---------|
| GET       | /weekssemestr/{id}   | Получить WeeksSemestr по id |
| GET       | /weekssemestrs/{id}  | Получить все WeeksSemestrs по id(Plan) |
| GET       | /weekssemestr        | Получить список всех WeeksSemestrs |
| POST      | /weekssemestr        | Добавить WeeksSemestr |
| DELETE    | /weekssemestr/{id}   | Удалить WeeksSemestr по id |
| PUT       | /weekssemestr        | Обновить WeeksSemestr |

Формат ответа:
GET localhost:8080/studyplan/weekssemestr/1

```javascript
{
    "id": 1,
    "countWeeks": 10,
    "numberSemestr": 1,
    "semestr": {
        "id": 1,
        "courceWorkHours": 300,
        "courceWorkZe": 1,
        "courseWorkType": "курсовой проект",
        "idFaculty": 1,
        "idTeacher": 1,
        "laboratory": 15,
        "lecture": 15,
        "number": 1,
        "practice": 15,
        "rgr": 1,
        "seminar": 15,
        "type": {
            "id": 1,
            "name": "зачет",
            "koff": 0.3
        },
        "ze": 5,
        "prac_hour": 0,
        "prac_ze": 0,
        "diplom_hour": 0,
        "diplom_ze": 0
    }
}

```
| Поле    | Описание |
| :----------:|:--------------------|
| id       |  Идентификатор недели в семестре|
| countWeeks      | Количество недель в семестре |
| numberSemestr       |  Номер семестра|
| semestr       |  Ссылка на семестр|


Errors
-------------

| Ошибка    | Код                  | Описание |
| :----------:|:--------------------| ---------|
| Not Found      | 404 | При попытке изменения или удаления несуществующей записи |
| Conflict       | 409 | При создании существующей записи|
| Internal Server Error       | 500 | При загрузке файла, превышающего размер 20Mb|

Формат ответа: DELETE http://localhost:8080/studyplan/subject/15

```javascript
{
    "timestamp": "2018-11-17T15:07:21.167+0000",
    "status": 404,
    "error": "Not Found",
    "message": "Subject with Id:15 wasn't found!",
    "path": "/studyplan/subject/15"
}
```


Формат ответа: POST http://localhost:8080/studyplan/subject

Тело запроса: 

```javascript
{
        "name": "История",
        "shifr": "shifr",
        "groupUnit": {
            "id": 1,
            "name": "Социально-гуманитарный модуль 1",
            "groupComponent": {
                "id": 1,
                "name": "Государственный компонент"
            }
        }
    }
```
Тело ответа:

```javascript
{
    "timestamp": "2018-11-17T15:11:09.466+0000",
    "status": 409,
    "error": "Conflict",
    "message": "Subject with name: История already exists!",
    "path": "/studyplan/subject"
}
```

Формат ответа: POST http://localhost:8080/studyplan/plan/file/1

```javascript
{
    "timestamp": "2019-01-17T13:37:30.109+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Maximum upload size exceeded; nested exception is java.lang.IllegalStateException: org.apache.tomcat.util.http.fileupload.FileUploadBase$FileSizeLimitExceededException: The field file exceeds its maximum permitted size of 1048576 bytes.",
    "path": "/studyplan/plan/file/1"
}
```

Формат ответа: POST http://localhost:8080/studyplan/plan/file/22

```javascript
{
    "timestamp": "2019-01-17T13:52:32.305+0000",
    "status": 404,
    "error": "Not Found",
    "message": "Plan with Id: 22 wasn't found!",
    "path": "/studyplan/plan/file/22"
}
```
Формат ответа: POST http://localhost:8080/studyplan/plan/file/1
```javascript
{
    "timestamp": "2019-01-17T14:04:04.579+0000",
    "status": 409,
    "error": "Conflict",
    "message": "File: Untitled Diagram 1.png does not MS Word file!",
    "path": "/studyplan/plan/file/1"
}
```

