# Sistema de Gestion de Magos y Hechizos (Taller 3)

Este proyecto es una aplicación de consola desarrollada en Java que simula un entorno interactivo para gestionar magos y sus respectivos repertorios de hechizos elementales. El programa permite organizar a los personajes, calcular su poder y analizar cuáles son los conjuros y magos más poderosos de la academia mediante un sistema dinámico de datos.

---

## Como Funciona el Sistema

El núcleo de la aplicación se encarga de leer la información almacenada en archivos de texto (Magos.txt y Hechizos.txt) al iniciar. El sistema procesa estos datos de forma automática, identificando el elemento de cada hechizo (Agua, Fuego, Planta o Tierra) para construir el universo del juego en la memoria de la computadora.

Al realizar modificaciones en los menús, los datos se sincronizan en tiempo real. Cuando decides salir del programa, el sistema guarda de forma automática todo el progreso y las actualizaciones directamente en los archivos de texto para evitar la pérdida de información.

---

## Mapa de Navegacion de los Menus

La interacción con el programa se realiza mediante menús numéricos simples que dividen las responsabilidades en dos grandes perfiles: Administrador y Analista.

### Menu Principal
Al iniciar el programa, se presentan tres opciones globales:
1. Menu Administrador (Para modificar el universo místico).
2. Menu Analista (Para consultar estadísticas y puntuaciones).
3. Salir (Guarda los datos y cierra la aplicación).

---

### 1. Menu Administrador
Diseñado para la gestión y alteración de los datos básicos. Sus opciones permiten:

* Agregar Mago: Registra un nuevo mago en la academia asegurando que su nombre sea único.
* Modificar Mago: Permite cambiar el nombre de un mago, enseñarle un nuevo hechizo de la lista general o hacer que olvide alguno.
* Eliminar Mago: Remueve a un personaje por completo del sistema.
* Agregar Hechizo: Crea un nuevo conjuro desde cero seleccionando su tipo elemental y configurando sus estadísticas base.
* Modificar Hechizo: Permite editar el nombre, el daño o los efectos especiales de un hechizo. Cualquier cambio aquí actualizará automáticamente a todos los magos que conozcan este hechizo.
* Eliminar Hechizo: Borra el hechizo del catálogo general y lo elimina de la memoria de todos los magos que lo tenían aprendido.

---

### 2. Menu Analista
Diseñado para la observación de estadísticas y la evaluación del poder del reino. Sus opciones permiten:

* Top 10 Mejores Hechizos: Ordena y muestra los 10 conjuros con mayor puntuación de impacto en el sistema.
* Top 3 Mejores Magos: Muestra a los 3 magos más poderosos basándose en la suma total del poder de todos los hechizos que conocen.
* Mostrar todos los Hechizos: Un listado simple con los nombres de todos los conjuros registrados.
* Mostrar todos los Magos: Un listado simple con los nombres de todos los magos de la academia.
* Mostrar Hechizos con Puntuacion: Desglosa cada hechizo junto a la puntuación exacta calculada según su elemento.
* Mostrar Magos con Puntuacion: Muestra el poder acumulado de cada personaje.

---

## Elementos Magicos Disponibles

Cada tipo de hechizo calcula su poder de forma diferente según sus características únicas:

* Agua: Su poder se potencia gracias a su capacidad de curación y a la presión del agua.
* Planta: Incrementa su fuerza según la duración de su stuneo y la cantidad de plantas invocadas.
* Fuego: El daño base se multiplica según el tiempo que dure la quemadura en el objetivo.
* Tierra: Su efectividad se evalúa combinando su fuerza con la mejora de defensa que otorga.

---
