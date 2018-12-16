# MySQL
```mysql
CREATE TABLE `locust_result` (
  `scenario_id` int(11) DEFAULT NULL,
  `requests` int(11) DEFAULT NULL,
  `failures` int(11) DEFAULT NULL,
  `median_response_time` int(11) DEFAULT NULL,
  `average_response_time` int(11) DEFAULT NULL,
  `min_response_time` int(11) DEFAULT NULL,
  `max_response_time` int(11) DEFAULT NULL,
  `average_content_size` int(11) DEFAULT NULL,
  `request_per_second` int(11) DEFAULT NULL,
  `date_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

# Deploy
```bash
scp -r locust-files root@192.168.199.20:/home  
scp target/locust-runner-1.0.0.jar root@192.168.199.20:/home

nohup java -jar locust-runner-1.0.0.jar &
```