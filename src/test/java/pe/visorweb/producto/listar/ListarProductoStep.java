package pe.visorweb.producto.listar;

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
import pe.visorweb.pagina.producto.PaginaListarProducto;

public class ListarProductoStep {

	@Managed
	WebDriver driver;
	PaginaLogin paginaLogin;
	PaginaListarProducto paginaListarProducto;
	
	@Before
	public void configurarDriver() {
		//comentar driver para Serenity
		//driver = VisorDriver.getDriver(Navegador.CHROME);
		paginaLogin = new PaginaLogin(driver);
		paginaListarProducto = new 	PaginaListarProducto(driver);
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
	
	@When("cargar la pagina listar producto")
	public void cargarPaginaListarProducto() {
		paginaListarProducto.cargarPagina();
	}
	
	@And("listar con el filtro {string}")
	public void listarProducto(String filtro) {
		paginaListarProducto.listar(filtro);
	}
	
	@Then("el aplicativo muestra el mensaje {string}")
	public void verificarRegistro(String mensajeEsperado) {
		Assertions
			.assertThat(paginaListarProducto.getMensaje())
			.isEqualTo(mensajeEsperado);
	}
	
	
}
