@echo off
@echo Bienvenido al ejercicio dos de java de TDC
@echo iniciando configuraciones...

@echo validando maven...


@echo maven valido, compilando...

call mvn clean package

echo app compilada correctamente, iniciando app...
java -jar target\actividadDosTDC-3.4.3.jar

pause
