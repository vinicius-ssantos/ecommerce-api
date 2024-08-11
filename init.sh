#!/bin/bash

# Conceder permissões usando o ID do usuário
chown -R 10001:0 /var/opt/mssql
chmod -R 775 /var/opt/mssql

# Iniciar SQL Server
/opt/mssql/bin/sqlservr
