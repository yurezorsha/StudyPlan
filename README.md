API REST SERVICE STUDY PLAN
===========================
### http://localhost:8080/studyplan

| Сущности    |  Описание |
| ----------| ----------|
| Certification         |  |
| Competence            |  |
| CreatorStudyProgram   |  |
| Fakultativ            |  |
| GroupComponent        |  |
| GroupUnit             |  |
| Group                 |  |
| Node                  |  |
| Plan                  |  |
| Semestr               |  |
| Speciality            |  |
| StudyProgram          |  |
| SubCompetence         |  |
| Subject               |  |
| Type                  |  |
| WeeksSemestr          |  |



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

GroupComponent
--------------

| Запрос    | URL                  | Описание |
| :----------:|:--------------------| ---------|
| GET       | /groupcomponent/{id}   | Получить GroupComponent по id |
| GET       | /groupcomponent        | Получить список всех GroupComponents |
| POST      | /groupcomponent        | Добавить GroupComponent |
| DELETE    | /groupcomponent/{id}   | Удалить GroupComponent по id |
| PUT       | /groupcomponent        | Обновить GroupComponent |

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

Speciality
--------------

| Запрос    | URL                  | Описание |
| :----------:|:--------------------| ---------|
| GET       | /speciality/{id}   | Получить Speciality по id |
| GET       | /speciality        | Получить список всех Specialities |
| POST      | /speciality        | Добавить Speciality |
| DELETE    | /speciality/{id}   | Удалить Speciality по id |
| PUT       | /speciality        | Обновить Speciality |

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

Type
--------------

| Запрос    | URL                  | Описание |
| :----------:|:--------------------| ---------|
| GET       | /type/{id}   | Получить Type по id |
| GET       | /type        | Получить список всех Types |
| POST      | /type        | Добавить Type |
| DELETE    | /type/{id}   | Удалить Type по id |
| PUT       | /type        | Обновить Type |

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
