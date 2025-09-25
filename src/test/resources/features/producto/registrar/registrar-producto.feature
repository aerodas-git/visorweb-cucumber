Feature: Gestión Producto
Scenario Outline: Registrar Producto 
	Given cargo la página visor web 
	And inicio sesión con el usuario <usuario> y la clave <clave> 
	When cargo la pagina registrar producto 
	And registro el producto <producto> categoria <categoria> y precio <precio>
	Then el aplicativo muestra el mensaje <mensajeEsperado>
	
	Examples: 
		| usuario | clave | producto          | categoria |precio | mensajeEsperado |
		| "admin" |"clave"|"Producto taller 3"|"2"        |"12.5"|"Se guardó de manera correcta el Producto" |
		| "admin" |"clave"|""                 |"3"        |"11.4"|"Nombre: Error de validación: se necesita un valor." |
		| "admin" |"clave"|"taller 3"         |"2"        |"82.1"|"Se guardó de manera correcta el Producto" |
		| "admin" |"clave"|"Producto sin precio"|"3"      |""    |"Precio: Error de validación: se necesita un valor." |
		
