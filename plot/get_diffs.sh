#!/bin/bash
set -e -u
set -o pipefail

function extract {
    cat $1 | tr -d '\r' | awk -F ',' '{print $8, $5}' | sort -n
}

join <(extract $1) <(extract $2) | awk '{min = $2<$3?$2:$3; print ($2-$3)*100/min"%"}'

