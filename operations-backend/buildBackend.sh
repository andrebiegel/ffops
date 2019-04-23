#!/usr/bin/env bash
mvn clean package && docker build -t abiegel/operations-backend:0.0.1-SNAPSHOT -f dockerfile .
