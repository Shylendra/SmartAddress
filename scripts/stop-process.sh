#!/bin/bash

ps -ef | grep smartaddress-web-1.0-SNAPSHOT.jar | grep -v grep | awk '{print $2}' | xargs kill