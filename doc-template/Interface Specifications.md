
## Interface Specifications （接口规约）

### /workload

#### Description (接口描述)

Get the parameters locust needed and run it, display the results on the console.

| | |
|-|-|
| Request Method | Post |
| Authorization | Not required |

#### Parameters (参数)

| Name | Description | Required | Schema |
|:-:|:-:|:-:|:-|
| scenarioId | scenario specified | Yes | number(int) |
| clients | clients simulated | Yes | number(int) |
| hatchRate | clients hatched / s | Yes | number(int) |
| runTime | total runtime | Yes | number(int) |
| host | website URL | Yes | string |

#### Responses (返回结果)

nothing

#### Request Sample (示例请求)

```

{
  "clients": 10,
  "hatchRate":10,
  "host": "www.baidu.com",
  "runTime": 10,
  "scenarioId": 1
}
```



---