# Trabajo Practico 4

Consiste en implementar un servicio web API que permita a la
gente dibujar en un lienzo vacío. Este servicio sigue un 
protocolo muy específico. Se debe presentar el práctico
hasta el martes 10 de octubre de 2023.

## Funciones

* El panel principal de la aplicación es un conjunto de tabs
* Cada tab corresponde a una sesión que un usuario ha abierto
* El nombre del tab corresponde al nombre de la sesión
* Cuando se muestra el tab entonces se dibuja la LISTA de 
comandos que se ha pedido ejecutar para esa sesión.
* El cliente no usa la aplicación principal sino que utiliza 
su navegador o una aplicación como Postman.
* El cliente tiene una lista de comandos que puede pasar a la
aplicación que siguen un protocolo bien específico.
* EL programa implementa todas las funciones indicadas en el 
protocolo.

## Protocolo

El protocolo que debe cumplir esta web API es el siguiente:

* GET /sesiones
Devuelve la lista de sesiones que están en el servidor.
* GET /s{id}
Devuelve el id de la sesion como titulo y la lista de comandos
posible para la aplicación.
* GET /s{id}/linea/{x1}/{y1}/{x2}/{y2}
Dibuja una linea desde x1,y1 hasta x2,y2 en la sesión id.
* GET /s{id}/circulo/{x}/{y}/{r}
Dibuja un circulo en la sesión id con centro (x,y) y radio r.
* GET /s{id}/rectangulo/{x1}/{y1}/{x2}/{y2}
Dibuja un rectangulo en la sesión id con esquina superior
izquierda (x1,y1) y esquina inferior derecha (x2,y2).
* GET /s{id}/comandos
Devuelve una lista de comandos que se ejecutaron en esta
sesión.
* GET /s{id}/limpiar
Limpia la sesión id.
* GET /s{id}/imagen
Devuelve un PNG con la imagen de la sesión id.

## Obligatorios

* El práctico debe implementar Observer.
* El práctico debe implementar Logs.
* Todas las listas que se utilicen deben ser ListaGenerica o 
ListaDoble.
* Utilizar expresiones regulares para testear la validez de
los comandos.
