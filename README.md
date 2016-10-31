#Pruebas automatizadas con Selenium y Java

###Dependencias:

 - JDK 1.7 o mayor
 - Maven2


###Instalación:

Luego de instalar las dependencias y de clonar el repositorio es necesario instalar las dependencias, para ello se debe ejecutar el siguiente comando:

    mvn install

El programa sólo descargará los archivos necesarios. Así que puedes tomarte un café o un té mientras.

Una vez que termina de instalar las dependencias, Maven ejecutará todas las pruebas por sí mismo.

###Ejecución

Para ejecutar todas pruebas es necesario ejecutar el siguiente comando:

    nvm test

###Directorio de Test

Dentro de la carpeta `test/java` se pueden crear directorio para agrupar los test.

Si bien este es un ejemplo básico, se puede ver la utilización de sentencias `@before`y `@after`.

Si se desea perfeccionar las pruebas es necesario aplicar el patrón **PageObject**.

