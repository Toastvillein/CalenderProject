# CalenderProject
| 기능| Method| URL|Request|Response|상태코드|
| --- | --- | --- | --- | --- | --- |
| 일정생성 | POST | /api/calenders |Request Body {  "name" : "작성자", "todo" : "할일", "password" : 0000 }|"name" : "작성자", "todo" : "할일", "password" : 0000 }|201 CREATED|
| 일정단건조회| GET | /api/calenders/{id}|Path Variable (Long) id|{"id" : 1,"name" : "작성자", "todo" : "할일"}| 200 OK
|일정전체조회|GET|/api/calenders|X|[{"id" : 1,"name" : "작성자", "todo" : "할일"},{"id" : 2,"name" : "작성자", "todo" : "할일"}]|200 OK
| 일정수정| PUT| /api/calenders/{id}|Path Variable (Long) id, Request Body { "name" : "작성자", "todo" : "수정된 할일", "password" : 0000 }|{ "name" : "작성자", "todo" : "수정된 할일", "password" : 0000 }|200 OK
|일정삭제|DELETE|/api/calenders/{id}|Path Variable (Long) id|"msg" : "deleted"|200 OK
