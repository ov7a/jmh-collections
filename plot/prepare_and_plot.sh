#!/bin/bash
set -eu
input="build/reports/jmh/results.csv"
packages=`ls src/jmh/java/collections`
output_data_dir='build/plots-data'
output_dir='build/plots'

mkdir -p ${output_data_dir}
mkdir -p ${output_dir}

units=`head -n2 ${input} | tail -n1 | cut -f7 -d, | sed 's/"//g'`

for package in ${packages}
do
    echo "plotting for $package"
    output_data_file="${output_data_dir}/${package}.csv"
    output_file="${output_dir}/${package}.png"
    cat ${input} | grep "$package" | sed "s/\"collections.$package.//" | sed "s/.benchmark\"//" > ${output_data_file}

    chunks_dir="${output_data_dir}/${package}"
    rm -rf ${chunks_dir}
    mkdir -p ${chunks_dir}
    awk -F\, '{print>"'${chunks_dir}'/"$1}' ${output_data_file}

    chunks=`ls ${chunks_dir}`
    gnuplot -e "data='$chunks'; datapath='$chunks_dir';output='$output_file'; title='${package/_/\ }'; ylabel='$units'" plot/plot.gpl
done