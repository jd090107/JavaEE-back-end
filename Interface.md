## Interface

### /workload

#### Description

Get the parameters locust needed and run it, display the results on the website.

|                |              |
| -------------- | ------------ |
| Request Method | Post         |
| Authorization  | Not required |

#### Parameters

|    Name    |    Description     | Required |   Schema    |
| :--------: | :----------------: | :------: | :---------: |
| scenarioId | Scenario specified |   Yes    | number(int) |
|  clients   | clients simulated  |   Yes    | number(int) |
| hatchRate  | clients hatched/s  |   Yes    | number(int) |
|  runTime   |   total runtime    |   Yes    | number(int) |
|    host    |    website URL     |   Yes    |   string    |
|  taskName  |     task name      |   Yes    |   string    |

#### Responses

reportId (a unique number for each task)

#### Request Sample

```java
scenarioId = 0;

clients = 10;

hatchRate = 10;

runTime = 10;

host = "http://www.baidu.com";

taskName = "task1";
```



### /history

#### Description

Get a user's all history tasks

|                |              |
| -------------- | ------------ |
| Request Method | Get          |
| Authorization  | Not required |

#### Parameters

nothing

(as for the user account, it's saved in cookies)

#### Responses

```java
[
  {
    "report_id": "string",
    "task_name": "string"
  }
]
```

#### Request Sample

nothing



### /history/task_information

#### Description

Get the the detailed information of a task

|                |              |
| -------------- | ------------ |
| Request Method | Get          |
| Authorization  | Not required |

#### Parameters

|   Name   |           Description            | Required | Schema |
| :------: | :------------------------------: | :------: | :----: |
| reportId | used to specify tasks to display |   Yes    | string |

#### Responses

```java
[
  {
    "averageContentSize": "string",
    "averageResponseTime": "string",
    "dateTime": "2018-12-16T15:36:32.195Z",
    "failures": "string",
    "maxResponseTime": "string",
    "medianResponseTime": "string",
    "minResponseTime": "string",
    "reportId": "string",
    "requestPerSecond": "string",
    "requests": "string",
    "scenarioId": "string"
  }
]
```

#### Request Sample

```java
reportId = 1;
```



### /download

#### Description

Download a csv file which include all the data of a task

|                |              |
| -------------- | ------------ |
| Request Method | Get          |
| Authorization  | Not Required |

#### Parameters

|   Name   |            Description            | Required | Schema |
| :------: | :-------------------------------: | :------: | :----: |
| reportId | used to specify tasks to download |   Yes    | string |

#### Responses

a csv file

#### Request Sample

```java
reportId = 1
```



### /user/login

#### Description

For the user to login the system

|               |              |
| ------------- | ------------ |
| Request       | Post         |
| Authorization | Not required |

#### Parameters

|   Name   |   Description   | Required | Schema |
| :------: | :-------------: | :------: | :----: |
| account  |  user's E'mail  |   Yes    | string |
| password | user's password |   Yes    | string |

#### Responses

```java
//No account exists
{
  "state": 0,
  "msg": "账号不存在",
  "data": null
}

//password is error
{
  "state": 0,
  "msg": "密码错误",
  "data": null
}

//successful
{
  "state": 1,
  "msg": "登录成功",
  "data": {
    "account": "123456@qq.com",
    "company": "Tongji University",
    "company_size": "1000",
    "job": "Student",
    "password": "123456",
    "username": "abcd"
  }
}
```

#### Request Sample

```java
account = "123456@qq.com";
password = "123456";
```



### /user/logup

#### Description

for the user to sign up

|                |              |
| -------------- | ------------ |
| Request Method | Put          |
| Authorization  | Not required |

#### Parameters

|   Name   | Description | Required | Schema |
| :------: | :---------: | :------: | :----: |
| account  |   E'mail    |   Yes    | string |
| password |  password   |   Yes    | string |
| username |  username   |   Yes    | string |

#### Responses

```java
//account is already exist
{
  "state": 0,
  "msg": "账号已被注册",
  "data": null
}

//successful
{
  "state": 1,
  "msg": "注册成功",
  "data": {
    "account": "12345@qq.com",
    "company": null,
    "company_size": null,
    "job": null,
    "password": "12345",
    "username": "abcde"
  }
}
```

#### Request Sample

```java
account = "12345@qq.com";
password = "12345";
username = "abcde";
```



### /user/out

#### Description

for the user to sign out

|                |              |
| -------------- | ------------ |
| Request Method | Get          |
| Authorization  | Not required |

#### Parameters

nothing

#### Responses

```java
{
  "state": 1,
  "msg": "成功",
  "data": null
}
```

#### Request Sample

nothing



### /user/update

#### Description

for the user to modify personal information

|                |              |
| -------------- | ------------ |
| Request Method | Patch        |
| Authorization  | Not required |

#### Parameters

|     Name     |     Description     | Required | Schema |
| :----------: | :-----------------: | :------: | :----: |
|   company    |       company       |   Yes    | string |
| company_size | the size of company |   Yes    | string |
|     job      |         job         |   Yes    | string |
|   username   |      username       |   Yes    | string |

#### Responses

```java
{
  "state": 1,
  "msg": "修改成功",
  "data": {
    "account": "123456@qq.com",
    "company": "Tongji University",
    "company_size": "1000",
    "job": "Student",
    "password": "123456",
    "username": "abcd"
  }
}
```



### /user/update/password

#### Description

for the user to change password

|                |              |
| -------------- | ------------ |
| Request Method | Patch        |
| Authorization  | Not Required |

#### Parameters

|   Name   | Description  | Required | Schema |
| :------: | :----------: | :------: | :----: |
| password | new password |   Yes    | string |

#### Responses

```java
{
  "state": 1,
  "msg": "修改成功",
  "data": {
    "account": "123456@qq.com",
    "company": "Tongji University",
    "company_size": "1000",
    "job": "Student",
    "password": "123456",
    "username": "abcd"
  }
}
```

#### Request Sample

```java
password = "123456";
```



### /user/verification

#### Descrition

for the mail verification

|                |              |
| -------------- | ------------ |
| Request Method | Get          |
| Authorization  | Not required |

#### Parameters

nothing

#### Responses

```java
//successful
{
  "data": "dsa342",
  "msg": "成功",
  "state": 1
}

//fail
{
  "data": null,
  "msg": "失败",
  "state": 0
}
```

