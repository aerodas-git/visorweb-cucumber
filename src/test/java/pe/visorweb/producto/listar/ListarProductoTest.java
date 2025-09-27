package pe.visorweb.producto.listar;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import io.cucumber.core.options.Constants;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/producto/listar")
@ConfigurationParameter(
	key = Constants.GLUE_PROPERTY_NAME,
	value = "pe.visorweb.producto.listar")
@ConfigurationParameter(
	key = Constants.PLUGIN_PROPERTY_NAME,
	value = "io.cucumber.core.plugin.SerenityReporterParallel,pretty")
public class ListarProductoTest {

}
