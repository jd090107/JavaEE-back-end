
1. Work Directory
```bash
cd microservices-demo
```

2. Run/Restart
```bash
docker-compose -f deploy/docker-compose/docker-compose.yml up -d
# or
docker-compose -f deploy/docker-compose/docker-compose.yml -f deploy/docker-compose/docker-compose.logging.yml up -d
```
3. Cleaning Up
```bash
docker-compose -f deploy/docker-compose/docker-compose.yml down
```


