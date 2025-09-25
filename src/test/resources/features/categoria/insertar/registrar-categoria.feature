Feature: Gestión Categoría 
Scenario Outline: Registrar Categoría 
	Given cargo la página visor web 
	And inicio sesión con el usuario <usuario> y la clave <clave> 
	When cargo la página registrar categoría 
	And registro la categoría <categoria> 
	Then el aplicativo muestra el mensaje <mensajeEsperado> 
	
	Examples: 
		| usuario| clave   | categoria | mensajeEsperado |
		|"admin" | "clave" | "CELULAR" | "Se guardó de manera correcta la Categoría" |
		|"admin" | "clave" | ""        | "Nombre: Error de validación: se necesita un valor." |
		|"admin" | "clave" | "TABLET"  | "Se guardó de manera correcta la Categoría" |
		
		
		
