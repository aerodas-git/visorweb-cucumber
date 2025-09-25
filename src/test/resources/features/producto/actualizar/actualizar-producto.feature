Feature: Gestión Producto 
Scenario Outline: Actualizar Producto 
	Given cargo la página visor web 
	And inicio sesión con el usuario <usuario> y la clave <clave> 
	When cargo la pagina actualizar producto 
	And actualizo el producto <producto> categoria <categoria> y precio <precio> 
	Then el aplicativo muestra el mensaje <mensajeEsperado> 
	
	Examples: 
		| usuario | clave | producto          | categoria |precio | mensajeEsperado |
		|"admin"|"clave"|"Producto actualizado"|"2"|"12.5"|"Se actualizó de manera correcta el Producto"|
		|"admin"|"clave"|""|"3"|"11.4"|"Nombre: Error de validación: se necesita un valor."|
		|"admin"|"clave"|"Producto sin precio"|"4"|""|"Precio: Error de validación: se necesita un valor."|