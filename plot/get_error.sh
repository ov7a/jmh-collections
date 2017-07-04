#!/bin/bash
set -e -u
set -o pipefail

cat $1 | tr -d '\r' | awk -F',' '{error = $5 > 0? $6/$5 : 0; print $1, $8, error*100"%"}'

