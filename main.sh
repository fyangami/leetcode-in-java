#!/bin/bash

print_color() {
    echo -n -e "\033[36m$1\033[0m"
}

usage() {
    echo "usage: "
    echo "[*] ./main.sh problemNo"
    echo "[*]   example: ./main.sh 1"
    echo "[!] Java file name format: Q_[problemNo].java"
    echo "[!] The file name must be equal to The Class name"
    exit 0
}

#######################################
# main
if [ $# != 1 ]; then
    usage
fi
SOURCE_FILE="Q_$1.java"
CLASS_FILE="Q_$1.class"
echo "============================"
echo "[*] Executing leetcode problem: No.$1"
echo "[*] Java file: $SOURCE_FILE"

SOURCE_PATH=`find -name $SOURCE_FILE`
if [ ! $SOURCE_PATH ]; then
    echo "[!] File ${SOURCE_FILE} not found!"
    echo "[!] Please check your type and Java file"
    echo "============================"
    exit 0
fi
javac $SOURCE_PATH -d .
echo "[*] Class file: $CLASS_FILE"
CLASS_PATH=`find -name $CLASS_FILE`
print_color "[*] Result: "
echo -n -e " "
java Q_$1
echo ""
rm $CLASS_FILE

BEGIN=`date "+%s.%3N"`



END=`date "+%s.%3N"`
EXECUTION=`echo $END - $BEGIN | bc`
if [ `echo ${EXECUTION} | cut -c 1` = '.' ]; then
    USAGE="0${EXECUTION}"
fi
echo -n "[*] Using time: "
print_color $EXECUTION
echo "ms"
echo "============================"

# end main
#######################################
