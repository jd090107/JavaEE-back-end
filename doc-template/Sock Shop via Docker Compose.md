**root@APM-HOST:~#** ls

dockprom  microservices-demo  Python-2.7.15  xujincheng



**root@APM-HOST:~#** cd microservices-demo



##### Run/Restart

> **root@APM-HOST:~#** docker-compose -f deploy/docker-compose/docker-compose.yml up -d
>
> 或者
>
> **root@APM-HOST:~#** docker-compose -f deploy/docker-compose/docker-compose.yml -f deploy/docker-compose/docker-compose.logging.yml up -d





##### Cleaning up

>  **root@APM-HOST:~#** docker-compose -f deploy/docker-compose/docker-compose.yml down



