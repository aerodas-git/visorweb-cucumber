package pe.visorweb.producto.eliminar;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
//import pe.visorweb.driver.VisorDriver;
//import pe.visorweb.driver.VisorDriver.Navegador;
import pe.visorweb.pagina.login.PaginaLogin;
import pe.visorweb.pagina.producto.PaginaEliminarProducto;

public class EliminarProductoStep {

			@Managed
			WebDriver driver;
			PaginaLogin paginaLogin;
			PaginaEliminarProducto paginaEliminarProducto;
			
			@Before
			public void configurarDriver() {
				//comentar driver para Serenity
				//driver = VisorDriver.getDriver(Navegador.CHROME);
				paginaLogin = new PaginaLogin(driver);
				paginaEliminarProducto = new PaginaEliminarProducto(driver);
			}
			
			@After
			public void cerrarDriver() {
				driver.quit();
			}
			
			@Given("cargo la página visor web")
			public void cargarPaginaVisor() {
				paginaLogin.cargarPagina();
			}
			
			@And("inicio sesión con el usuario {string} y la clave {string}")
			public void iniciarSesion(String usuario, String clave) {
				paginaLogin.iniciarSesion(usuario, clave);	
			}
			
			@When("cargo la pagina eliminar producto de la fila {string}")
			public void cargarPaginaEliminarProducto(String fila) {
				paginaEliminarProducto.cargarPagina(fila);
			}
			
			@And("elimino el producto")
			public void eliminarProducto() {
				paginaEliminarProducto.eliminarProducto();
			}
			
			@Then("el aplicativo muestra el mensaje {string}")
			public void verificarRegistro(String mensajeEsperado) {
				Assertions
					.assertThat(paginaEliminarProducto.getMensaje())
					.isEqualTo(mensajeEsperado);
			}
		
}
