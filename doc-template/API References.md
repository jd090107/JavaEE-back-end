# API References



### 输入压测信息



* 接口功能

  > 从页面获取locust所需要的信息



* URL

  >http://localhost:2449/



* 支持格式

  > JSON



* HTTP请求

  > POST



* 请求参数

  | 参数   | 必选 | 类型   | 说明                                        |
  | ------ | ---- | ------ | ------------------------------------------- |
  | clents | true | string | 设置虚拟用户数                              |
  | rate   | true | string | 每秒启动的虚拟用户数                        |
  | time   | true | string | 运行时间单位，单位默认是s,可指定小时h,分钟m |
  | task   | true | string | 场景描述，用于判断py文件的名称得以进行其他操作        |


* 接口返回

  | 类型   | 说明          |
  | ------ | ------------- |
  | string | 成功/错误说明 |


