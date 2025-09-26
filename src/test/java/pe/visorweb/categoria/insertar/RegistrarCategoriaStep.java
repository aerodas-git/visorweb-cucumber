package pe.visorweb.categoria.insertar;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import pe.visorweb.driver.VisorDriver;
import pe.visorweb.driver.VisorDriver.Navegador;
import pe.visorweb.pagina.categoria.PaginaRegistrarCategoria;
import pe.visorweb.pagina.login.PaginaLogin;

public class RegistrarCategoriaStep {

	@Managed
	WebDriver driver;
	PaginaLogin paginaLogin;
	PaginaRegistrarCategoria paginaRegistrarCategoria;
	
	@Before
	public void configurarDriver() {
		// se comenta para usar el driver de serenity
		//driver = VisorDriver.getDriver(Navegador.CHROME);
		paginaLogin = new PaginaLogin(driver);
		paginaRegistrarCategoria = new PaginaRegistrarCategoria(driver);
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
	
	@When("cargo la página registrar categoría")
	public void cargarPaginaRegistrarCategoria() {
		paginaRegistrarCategoria.cargarPagina();
	}
	
	@And("registro la categoría {string}")
	public void registrarCategoria(String categoria) {
		paginaRegistrarCategoria.guardar(categoria);
	}
	
	@Then("el aplicativo muestra el mensaje {string}")
	public void verificarRegistro(String mensajeEsperado) {
		
		Assertions
			.assertThat(paginaRegistrarCategoria.getMensaje())
					.isEqualTo(mensajeEsperado);
		//System.out.println("Verificar el mensaje: " + mensajeEsperado);
		//System.out.println("----------------------------");
	}
	
	
}
