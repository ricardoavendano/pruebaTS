# PruebaTS
Ricardo Avendaño Casas

Para ejecutar el proyecto se deben realizar los siguientes pasos
1. descargar fuente de github: git clone https://github.com/ricardoavendano/pruebaTS.git
2. ir al directorio donde se encuentra el fuente y crear jar: mvn clean install (se crea la carpeta target)
3. ir al directorio donde se encuentra el fuente y dirigirse a la carpeta target; por linea de comandos ejecutar jar: java -jar prueba-0.0.1-SNAPSHOT.jar
4. La aplicacion ya se encuentra desplegada localmente en la url (http://localhost:8080)
5. Ingreso a la BD H2
	url: http://localhost:8080/prueba/h2-console/login.jsp
	JDBC URL: jdbc:h2:mem:prueba
	User name: prueba
	Password: prueba
	
	Tablas: EMPLEADO, ACTIVIDAD
7. Uso de Swagger
	http://localhost:8080/prueba/swagger-ui.html#/
8. Descargar prueba front 
	https://github.com/ricardoavendano/pruebaTS_front.git
