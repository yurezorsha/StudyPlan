API REST SERVICE STUDY PLAN
===========================
### http://localhost:8080/studyplan

| Сущности    |  Описание |
| ----------| ----------|
| [Certification](#certification)        |  |
| [Competence](#competence)            |  |
| [CreatorStudyProgram](#creatorstudyprogram)   |  |
| [Fakultativ](#fakultativ)           |  |
| [GroupComponent](#groupcomponent)        |  |
| [GroupUnit](#groupunit)             |  |
| [Group](#group)                 |  |
| [Node](#node)                  |  |
| [Plan](#plan)                 |  |
| [Semestr](#semestr)               |  |
| [Speciality](#speciality)            |  |
| [StudyProgram](#studyprogram)          |  |
| [SubCompetence](#subcompetence)         |  |
| [Subject](#subject)               |  |
| [Type](#type)                  |  |
| [WeeksSemestr](#weekssemestr)          |  |



Certification
--------------

| Запрос    | URL                  | Описание |
| :----------:|:--------------------| ---------|
| GET       | /certification/{id}   | Получить Certification по id |
| GET       | /certifications/{id}  | Получить все Certifications по id(Plan)|
| GET       | /certification        | Получить список всех Certifications |
| POST      | /certification        | Добавить Certification |
| DELETE    | /certification/{id}   | Удалить Certification по id |
| PUT       | /certification        | Обновить Certification |

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
    "nameCompetence": "Быть способным использовать основные законы электротехники и владеть методами их применения, применять электронные элементы и приборы в системах автоматизации"
}
```

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
        "id": 1,
        "dateApprove": "2020-08-20",
        "subject": {
            "id": 1,
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
    }
}
```

Fakultativ
--------------

| Запрос    | URL                  | Описание |
| :----------:|:--------------------| ---------|
| GET       | /fakultativ/{id}   | Получить Fakultativ по id |
| GET       | /fakultatives/{id}  | Получить все Fakultatives по id(Plan) |
| GET       | /fakultativ        | Получить список всех Fakultativs |
| POST      | /fakultativ        | Добавить Fakultativ |
| DELETE    | /fakultativ/{id}   | Удалить Fakultativ по id |
| PUT       | /fakultativ        | Обновить Fakultativ |

Формат ответа:
GET localhost:8080/studyplan/fakultativ/1

```javascrip
{
    "id": 1,
    "name": "Факультатив 1",
    "plan": null
}
```

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
        "id": 1,
        "name": "Государственный компонент"
    }
}
```

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
            "id": 1,
            "name": "Социально-гуманитарный модуль 1",
            "groupComponent": {
                "id": 1,
                "name": "Государственный компонент"
            }
        }
    }
 ```

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

Semestr
--------------

| Запрос    | URL                  | Описание |
| :----------:|:--------------------| ---------|
| GET       | /semestr/{id}   | Получить Semestr по id |
| GET       | /semestrs/{id}  | Получить все Semestrs по id(GroupComponent) |
| GET       | /semestr        | Получить список всех Semestrs |
| GET       | /semestr/sum/{id}| Получить кол-во часов всех пар в Semestr с id |
| POST      | /semestr/{id}   | Добавить список Semestrs в Node с id |
| POST      | /semestrs       | Добавить Semestr |
| DELETE    | /semestr/{id}   | Удалить Semestr по id |
| PUT       | /semestr /{id}  | Обновить Semestr в Node с id |

Формат ответа:
GET localhost:8080/studyplan/semestr/1

```javascript
{
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
```

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
        "id": 2,
        "name": "Политология",
        "shifr": "shifr",
        "groupUnit": {
            "id": 1,
            "name": "Социально-гуманитарный модуль 1",
            "groupComponent": {
                "id": 1,
                "name": "Государственный компонент"
            }
        }
    },
    "semestrs": []
}
```

Plan
--------------

| Запрос    | URL                  | Описание |
| :----------:|:--------------------| ---------|
| GET       | /plan/{id}   | Получить Plan по id |
| GET       | /plans/{id}  | Получить все Plan по id(Speciality) |
| GET       | /plan        | Получить список всех Plans |
| GET       | /plan/{id}/data  | Получить учебную нагрузку по id(Plan) за год |
| GET       | /plan/getYear |  |
| POST      | /plan        | Добавить Plan |
| DELETE    | /plan/{id}   | Удалить Plan по id |
| PUT       | /plan        | Обновить Plan |


Получение плана по id
Формат ответа:
GET localhost:8080/studyplan/plan/1

```javascript
{
    "id": 1,
    "set_data_group": 2009,
    "nodes": [],
    "speciality": {
        "id": 1,
        "name": "Информационные системы и технологии",
        "shifr": "1-40 05 01-01"
    }
}

```

Получения нагрузки за определенный год
Формат ответа:
GET localhost:8080/studyplan/plan/1/data/?year=2009

```javascript
[
    [
        {
            "id_teacher": 1,
            "semestr_number": 1,
            "count_lecture": 15,
            "count_laboratory": 15,
            "count_practice": 15,
            "count_seminar": 15,
            "type": "зачет",
            "cource_work_hours": 300,
            "id_group": 1,
            "count_students": 20,
            "id_subject": 4,
            "name_subject": "Экономика",
            "calc_field": 6
        },
        {
            "id_teacher": 1,
            "semestr_number": 1,
            "count_lecture": 15,
            "count_laboratory": 15,
            "count_practice": 15,
            "count_seminar": 15,
            "type": "зачет",
            "cource_work_hours": 0,
            "id_group": 1,
            "count_students": 20,
            "id_subject": 2,
            "name_subject": "Политология",
            "calc_field": 6
        },
        {
            "id_teacher": 1,
            "semestr_number": 2,
            "count_lecture": 15,
            "count_laboratory": 15,
            "count_practice": 15,
            "count_seminar": 15,
            "type": "зачет",
            "cource_work_hours": 0,
            "id_group": 1,
            "count_students": 20,
            "id_subject": 2,
            "name_subject": "Политология",
            "calc_field": 6
        },
        {
            "id_teacher": 1,
            "semestr_number": 1,
            "count_lecture": 15,
            "count_laboratory": 15,
            "count_practice": 15,
            "count_seminar": 15,
            "type": "зачет",
            "cource_work_hours": 300,
            "id_group": 2,
            "count_students": 25,
            "id_subject": 4,
            "name_subject": "Экономика",
            "calc_field": 7.5000005
        },
        {
            "id_teacher": 1,
            "semestr_number": 1,
            "count_lecture": 15,
            "count_laboratory": 15,
            "count_practice": 15,
            "count_seminar": 15,
            "type": "зачет",
            "cource_work_hours": 0,
            "id_group": 2,
            "count_students": 25,
            "id_subject": 2,
            "name_subject": "Политология",
            "calc_field": 7.5000005
        },
        {
            "id_teacher": 1,
            "semestr_number": 2,
            "count_lecture": 15,
            "count_laboratory": 15,
            "count_practice": 15,
            "count_seminar": 15,
            "type": "зачет",
            "cource_work_hours": 0,
            "id_group": 2,
            "count_students": 25,
            "id_subject": 2,
            "name_subject": "Политология",
            "calc_field": 7.5000005
        }
    ],
    [],
    [
        {
            "semestr_number": 2,
            "id_group": 1,
            "count_students": 20,
            "id_subject": 4,
            "name_subject": "Экономика",
            "prac_ze": 1,
            "prac_hour": 1
        },
        {
            "semestr_number": 2,
            "id_group": 2,
            "count_students": 25,
            "id_subject": 4,
            "name_subject": "Экономика",
            "prac_ze": 1,
            "prac_hour": 1
        }
    ]
]
```

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
    "shifr": "1-40 05 01-01"
}
```

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
        "id": 1,
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
}
```

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
        "id": 1,
        "nameCompetence": "Быть способным использовать основные законы электротехники и владеть методами их применения, применять электронные элементы и приборы в системах автоматизации"
    },
    "subject": {
        "id": 1,
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
}

```


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
