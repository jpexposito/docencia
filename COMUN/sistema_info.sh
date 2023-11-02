#!/bin/bash

# Obtener información
hostname=$(hostname)
cpu_info=$(sudo cat /proc/cpuinfo | grep -m 1 "model name" | awk -F: '{print $2}' | sed 's/^ *//')
placa_nombre=$(sudo dmidecode -t 2 | grep "Manufacturer: " | awk -F: '{print $2}' | sed 's/^ *//')
placa_info=$(sudo dmidecode -t 2 | grep "Product Name" | awk -F: '{print $2}' | sed 's/^ *//')
ram_info=$(free -h | grep "Mem:" | awk '{print $2}')
disco_info=$(df -h --total | grep "total" | awk '{print $2}')
mac_info=$(ip link show | grep "link/ether" | awk '{print $2}')
ip_info=$(ip a | grep "inet " | awk '{print $2}' | grep 10 | grep './/')
bios_info=$(sudo dmidecode -t bios | grep "Version" | awk -F: '{print $2}' | sed 's/^ *//')
boot_info=$(sudo dmidecode -t baseboard | grep "Boot-up State" | awk -F: '{print $2}' | sed 's/^ *//')

# Crear un archivo CSV
nombre_fichero="$hostname"_info.csv
echo "Hostname,CPU,MARCA PLACA,RAM,DISCO,MAC,IP,BIOS,BOOT" > "$nombre_fichero"
echo "$hostname,$cpu_info, $placa_nombre $placa_info,$ram_info,$disco_info,$mac_info,$ip_info,$bios_info,$boot_info" >> "$nombre_fichero"

echo "La información se ha guardado en " echo "$nombre_fichero"
