#!/bin/bash
mkdir -p /logs
chown postgres:postgres /logs
postgres -c logging_collector=on -c log_destination=stderr -c log_directory=/logs

set -e

PGPASSWORD=postgres
psql -U postgres -d postgres -f $(dirname "$0")/initdb.sql
