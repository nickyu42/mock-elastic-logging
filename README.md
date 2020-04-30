# Elastic stack mock logging

Service that creates mock logs  
Currently has a mock project in Java, multiple source options will be added later

## Instructions elastic stack 

Start Elasticsearch, Filebeat, Logstash and Kibana  
`docker-compose up -d`

Stop and remove the services  
`docker-compose down`

## To run elastic stack + mock java project

Start the services  
`docker-compose -f docker-compose.yml -f docker-compose.java.yml up -d`

Stop and remove the services  
`docker-compose down --remove-orphans`