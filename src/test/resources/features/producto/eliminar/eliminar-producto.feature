Feature: Gestión Producto 
Scenario Outline: Eliminar Producto 
	Given cargo la página visor web
	And inicio sesión con el usuario <usuario> y la clave <clave>
	When cargo la pagina eliminar producto de la fila <fila>
	And elimino el producto
	Then el aplicativo muestra el mensaje <mensajeEsperado>
	
	Examples: 
		| usuario | clave | fila | mensajeEsperado                           |
		| "admin" |"clave"|"3"   |"Se eliminó de manera correcta el Producto"|
		| "admin" |"clave"|""    |"No ha seleccionado un Producto"           |