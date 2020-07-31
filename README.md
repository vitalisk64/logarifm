# logarifm

### Расчет логарифма
curl http://<ip>:8080/logarithm/log -H "Content-Type: application/json" -d '{"argument":2}

### Сборка и запуск docker
docker run -p 9880:9880 -v $(pwd)/fluent:/fluentd/etc -e FLUENTD_CONF=fluentd.conf fluent/fluentd:v1.6-debian-1
docker build --tag logarithm .
docker run -d -p 8080:8080 -p 8081:8081 logarithm

### Проверка Readiness (во время "запуска" HTTP 500)
/actuator/started на порту 8081





