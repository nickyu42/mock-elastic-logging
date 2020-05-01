# Elastic stack mock logging

Service that creates mock logs  
Currently has a mock project in Java, multiple source options will be added later

Included services
- `elasticsearch` on port 9200
- `filebeat`
- `logstash`
- `kibana` on port 5601
- `java_log_gen`
 
## Instructions elastic stack 

Start Elasticsearch, Filebeat, Logstash and Kibana  
```shell script
docker-compose up -d
```

Stop and remove the services  
```shell script
docker-compose down
```

## Instructions elastic stack + mock java project

It is recommended to only run the java project for a short period,
as it does not stop producing logs.  

The logs are parsed by Logstash by default,
but it is possible to just output the raw log messages directly to Elasticsearch
by using `docker-compose.java_raw.yml` instead of `docker-compose.java.yml`

Start Elasticsearch, Filebeat, Logstash, Kibana and java_log_gen  
```shell script
docker-compose -f docker-compose.yml -f docker-compose.java.yml up -d
```

Start Elasticsearch, Filebeat, Kibana and java_log_gen  
```shell script
docker-compose -f docker-compose.yml -f docker-compose.java_raw.yml up -d
```

Stop and remove the services  
```shell script
docker-compose down --remove-orphans
```

Stop `java_log_gen`
```shell script
docker container stop java_log_gen
```

## Retrieving example logs

Logstash sends all output to the `logs` index in Elasticsearch  
The full output format is specified in `mappping.json`  

Retrieving a single log with cURL can be done as:
```shell script
curl -XPOST "http://localhost:9200/logs/_search?pretty" \
     -H 'Content-Type: application/json' \
     -d '{ "query": { "match_all": {} }, "size": 1}'
```

Example result:
```json
{
  "took" : 0,
  "timed_out" : false,
  "_shards" : {
    "total" : 1,
    "successful" : 1,
    "skipped" : 0,
    "failed" : 0
  },
  "hits" : {
    "total" : {
      "value" : 10000,
      "relation" : "gte"
    },
    "max_score" : 1.0,
    "hits" : [
      {
        "_index" : "logs",
        "_type" : "_doc",
        "_id" : "Fjxdz3EBL8oM2sfVedt6",
        "_score" : 1.0,
        "_source" : {
          "log4j_message" : "Move service successful",
          "@version" : "1",
          "message" : "[04 30 11:33:32] INFO com.sap.enterprises.server.impl.TransportationService:37 - Move service successful",
          "log4j_level" : "INFO",
          "received_at" : "2020-05-01T08:32:18.324Z",
          "log4j_file" : "com.sap.enterprises.server.impl.TransportationService",
          "ecs" : {
            "version" : "1.4.0"
          },
          "log" : {
            "file" : {
              "path" : "/var/log/mock/sap.log"
            },
            "offset" : 698007
          },
          "fields" : {
            "service" : "log4j"
          },
          "tags" : [
            "beats_input_codec_plain_applied",
            "_dateparsefailure"
          ],
          "agent" : {
            "version" : "7.6.2",
            "hostname" : "e6bcc5f205c8",
            "type" : "filebeat",
            "id" : "c7636920-45a1-4855-8819-a8adfeffe154",
            "ephemeral_id" : "b3f2836f-0f68-4db5-a0aa-3d8e2b4f43be"
          },
          "log4j_line" : "37",
          "host" : {
            "name" : "e6bcc5f205c8"
          },
          "received_from" : "{\"name\":\"e6bcc5f205c8\"}",
          "input" : {
            "type" : "log"
          },
          "@timestamp" : "2020-05-01T08:32:18.324Z",
          "log4j_timestamp" : "[04 30 11:33:32]"
        }
      }
    ]
  }
}
```