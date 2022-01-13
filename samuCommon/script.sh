#!/bin/bash
(trap 'kill 0' SIGINT;
java -jar src/loadbalance/LoadBalance.java 8081 &

echo "Load Balancer PID: $!" &

java -jar stores-service/target/storesservice.jar udp 4000 /127.0.0.1:3000 /127.0.0.1:5000 &

echo "Service 1 PID: $!" &

java -jar stores-service/target/storesservice.jar udp 4001 /127.0.0.1:3000 /127.0.0.1:5000 &

echo "Service 2 PID: $!" &

java -jar proxy/target/proxy.jar udp 5000 /127.0.0.1:6000 /127.0.0.1:6001 &

echo "Proxy PID: $!" &

java -jar stores-database/target/storesdatabase.jar udp 6000 /127.0.0.1:5000 /127.0.0.1:6001 &

echo "Database 1 PID: $!" &

java -jar stores-database/target/storesdatabase.jar udp 6001 /127.0.0.1:5000 /127.0.0.1:6000 &

echo "Database 2 PID: $!" &

wait
)
