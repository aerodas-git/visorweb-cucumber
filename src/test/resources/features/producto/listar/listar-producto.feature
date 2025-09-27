Feature: Gestión Producto 
Scenario Outline: Listar Producto 
	Given cargo la página visor web
	And inicio sesión con el usuario <usuario> y la clave <clave>
	When cargar la pagina listar producto
	And listar con el filtro <filtro>
	Then el aplicativo muestra el mensaje <mensajeEsperado>
	
	Examples: 
		| usuario | clave | filtro    | mensajeEsperado                      |
		| "admin" |"clave"|"PRUEBA"   |"Existen registros para la consulta"  |
		| "admin" |"clave"|"NO EXISTE"|"No existe registros para la consulta"|