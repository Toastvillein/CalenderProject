# 일정 관리 앱 프로젝트
![header](https://capsule-render.vercel.app/api?type=cylinder&color=FFA500&height=300&section=header&text=CALENDER%20PROJECT&fontSize=70)

## 🤔 개요
-    이 앱은 간단한 일정관리 웹 어플리케이션을 구현한 프로젝트입니다. 생성시 기입하는 id와 password를 통해 수정,삭제가 가능하며 원한다면 email 같은 추가 정보도 기입 가능합니다.

## 🌳 개발환경
- 언어 : ![Static Badge](https://img.shields.io/badge/Java-red?style=flat-square)

- JDK : ![Static Badge](https://img.shields.io/badge/JDK-17-yellow?style=flat-square)

- 프레임워크 : ![Static Badge](https://img.shields.io/badge/SpringBoot-%23FFFF00?logo=springboot)

- DB : ![Static Badge](https://img.shields.io/badge/MySql-%23FFFFFF?style=flat&logo=mysql)

## ⏱️ 개발기간
 - 2025-03-24~ 2025-03-25(2일)

## 🛠 기능 엿보기   

1. [📅 ERD  ](#-ERD)
2. [📋 API 명세서](#-API-명세서)
3. [❓ 클래스 설명](#-클래스-설명)
4. [🛠 기능 요약](#-기능-요약)
5. [✅ 디렉토리 구조](#-디렉토리-구조)

   

 # 📅 ERD 
 
![calender](https://github.com/user-attachments/assets/81a7a6da-9d7b-442b-8d04-c0975edfa06f)


 # 📋 API 명세서

| 기능 | Method| URL|Request|Response|상태코드|
| --- | --- | --- | --- | --- | --- |
| 일정생성 | POST | /api/calenders |Request Body {  "name" : "작성자", "todo" : "할일", "password" : 0000 }|"name" : "작성자", "todo" : "할일", "password" : 0000 }|201 CREATED|
| 일정단건조회| GET | /api/calenders/{id}|Path Variable (Long) id|{"id" : 1,"name" : "작성자", "todo" : "할일","password" : 0000}| 200 OK
|일정전체조회|GET|/api/calenders|X|[{"id" : 1,"name" : "작성자", "todo" : "할일","password" : 0000},{"id" : 2,"name" : "작성자", "todo" : "할일","password" : 0000}]|200 OK
| 일정수정| PUT| /api/calenders/{id}/{password}|Path Variable (Long) id,(Integer) password, Request Body { "name" : "작성자", "todo" : "수정된 할일", "password" : 0000 }|{ "name" : "작성자", "todo" : "수정된 할일", "password" : 0000 }|200 OK
|일정삭제|DELETE|/api/calenders/{id}/{password}|Path Variable (Long) id,(Integer) password|"msg" : "deleted"|200 OK
|추가정보 기입|PUT|/api/calenders/{id}/{password}|Path Variable (Long) id,(Integer) password, Request Body { "email" : "이메일" }|{"id" : 1,"name" : "작성자", "todo" : "할일","password" : 0000, "email" : "이메일"}|200 OK

 # ❓ 클래스 설명
## 1. Calender.class
- 해당 프로젝트 내 필요한 모든 필드(속성)를 정의하고 관리하고 있는 클래스입니다.

## 2. CalController.class
- 클라이언트로 부터 들어온 요청을 받아 알맞는 핸들러에 넘겨주는 클래스 입니다.

- @RestController

- @RequestMapping

## 3. CalRequestDto.class
- 클라이언트로 부터 들어올 수 있는 DATA TRANSFER OBJECT(DTO) 필드를 정의하고 있는 클래스입니다.

## 4. CalResponseDto.class
- 클라이언트에게 반환하는 DATA TRANSFER OBJECT(DTO) 필드를 정의하고 있는 클래스입니다.

## 5. CalService.interface
- 해당 프로젝트의 비지니스 로직이 정의되어 있는 인터페이스입니다.
## 6. CalServiceImpl.class
- 위 인터페이스를 구현하고 있는 클래스입니다. 비지니스 로직 기능들이 포함되어 있습니다.

- @Service
## 7. CalRepository.interface
 - 해당 프로젝트의 DB에 데이터를 저장,수정,조회하는 역할을 하는 인터페이스 입니다.
## 8. CalRepositoryImpl.class
- 위 인터페이스를 구현한 클래스입니다. 

- @Repository
## 9. exceptionHandler.class
- 예외처리용 핸들러가 정의 되어있는 클래스입니다. 모든 예외 상황을 감시하며, 특정 예외에는 CustomException으로 메세징과 동시에 처리 가능하도록 합니다.

- @ControllerAdvice
## 10. CustomException.class
- 위의 CustomException을 정의하고 있는 클래스 입니다. RuntimeException을 상속 받고 있습니다.
 # 🛠 기능 요약
일정 생성 : 클라이언트로부터 받아온 '이름' , '비밀번호' , '내용'을 바탕으로 id를 자동 생성 후 부여해주며, 생성 시간을 저장하여 DB에 일정을 저장합니다.

일정 확인 : 클라이언트로부터 'id' , '비밀번호'를 입력받아 알맞으면 해당 일정 내용을 반환합니다.

모든 일정 확인 : 클라이언트에게 모든 일정 내용을 리스트(List)화 하여 반환합니다.

일정 수정 : 클라이언트로부터 'id' , '비밀번호', '수정내용'을 입력받아 알맞으면 해당 일정 내용을 수정하여 반환합니다.

일정 삭제 : 클라이언트로부터 'id' , '비밀번호'를 입력받아 알맞으면 해당 일정 내용을 삭제합니다.

사용자 정보 추가 기입 : 라이언트로부터 'id' , '비밀번호', '이메일'를 입력받아 알맞으면 작성자 정보에 이메일을 추가 저장하여 반환합니다.

 # ✅ 디렉토리 구조
```java
C:.
│  .gitattributes
│  .gitignore
│  build.gradle
│  gradlew
│  gradlew.bat
│  HELP.md
│  README.md
│  settings.gradle
│
├─.gradle
│  │  file-system.probe
│  │
│  ├─8.13
│  │  │  gc.properties
│  │  │
│  │  ├─checksums
│  │  │      checksums.lock
│  │  │
│  │  ├─executionHistory
│  │  │      executionHistory.bin
│  │  │      executionHistory.lock
│  │  │
│  │  ├─expanded
│  │  ├─fileChanges
│  │  │      last-build.bin
│  │  │
│  │  ├─fileHashes
│  │  │      fileHashes.bin
│  │  │      fileHashes.lock
│  │  │      resourceHashesCache.bin
│  │  │
│  │  └─vcsMetadata
│  ├─buildOutputCleanup
│  │      buildOutputCleanup.lock
│  │      cache.properties
│  │      outputFiles.bin
│  │
│  └─vcs-1
│          gc.properties
│
├─.idea
│  │  .gitignore
│  │  compiler.xml
│  │  dataSources.local.xml
│  │  dataSources.xml
│  │  gradle.xml
│  │  misc.xml
│  │  sqldialects.xml
│  │  vcs.xml
│  │  workspace.xml
│  │
│  ├─dataSources
│  │  │  7c70e273-687d-451a-8abe-a02ad58bbde4.xml
│  │  │
│  │  └─7c70e273-687d-451a-8abe-a02ad58bbde4
│  │      └─storage_v2
│  │          └─_src_
│  │              └─schema
│  │                      calender.uvte9Q.meta
│  │                      information_schema.FNRwLQ.meta
│  │                      mysql.osA4Bg.meta
│  │                      performance_schema.kIw0nw.meta
│  │                      sys.zb4BAA.meta
│  │
│  └─inspectionProfiles
│          Project_Default.xml
│
├─build
│  ├─classes
│  │  └─java
│  │      └─main
│  │          └─com
│  │              └─example
│  │                  └─calenderproject
│  │                      │  CalenderProjectApplication.class
│  │                      │
│  │                      ├─controller
│  │                      │      CalController.class
│  │                      │
│  │                      ├─domain
│  │                      │      Calender.class
│  │                      │
│  │                      ├─dto
│  │                      │      CalRequestDto.class
│  │                      │      CalResponseDto.class
│  │                      │
│  │                      ├─excption
│  │                      │      CustomException.class
│  │                      │      exceptionHandler.class
│  │                      │
│  │                      ├─repository
│  │                      │      CalRepository.class
│  │                      │      CalRepositoryImpl$1.class
│  │                      │      CalRepositoryImpl$2.class
│  │                      │      CalRepositoryImpl.class
│  │                      │
│  │                      └─service
│  │                              CalService.class
│  │                              CalServiceImpl.class
│  │
│  ├─generated
│  │  └─sources
│  │      ├─annotationProcessor
│  │      │  └─java
│  │      │      └─main
│  │      └─headers
│  │          └─java
│  │              └─main
│  ├─reports
│  │  └─problems
│  │          problems-report.html
│  │
│  ├─resources
│  │  └─main
│  │      │  application.properties
│  │      │
│  │      ├─static
│  │      └─templates
│  └─tmp
│      └─compileJava
│          │  previous-compilation-data.bin
│          │
│          └─compileTransaction
│              ├─backup-dir
│              └─stash-dir
│                      CalController.class.uniqueId0
│
├─gradle
│  └─wrapper
│          gradle-wrapper.jar
│          gradle-wrapper.properties
│
└─src
    ├─main
    │  ├─java
    │  │  └─com
    │  │      └─example
    │  │          └─calenderproject
    │  │              │  CalenderProjectApplication.java
    │  │              │
    │  │              ├─controller
    │  │              │      CalController.java
    │  │              │
    │  │              ├─domain
    │  │              │      Calender.java
    │  │              │
    │  │              ├─dto
    │  │              │      CalRequestDto.java
    │  │              │      CalResponseDto.java
    │  │              │
    │  │              ├─excption
    │  │              │      CustomException.java
    │  │              │      exceptionHandler.java
    │  │              │
    │  │              ├─repository
    │  │              │      CalRepository.java
    │  │              │      CalRepositoryImpl.java
    │  │              │
    │  │              └─service
    │  │                      CalService.java
    │  │                      CalServiceImpl.java
    │  │
    │  └─resources
    │      │  application.properties
    │      │
    │      ├─static
    │      └─templates
    └─test
        └─java
            └─com
                └─example
                    └─calenderproject
                            CalenderProjectApplicationTests.java
```
