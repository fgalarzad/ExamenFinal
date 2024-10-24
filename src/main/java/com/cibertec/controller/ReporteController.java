package com.cibertec.controller;

import javax.sql.DataSource;
import java.io.OutputStream;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@RestController
public class ReporteController {
	
	private ResourceLoader resourceLoader;
	private DataSource dataSource;

	@GetMapping(value="/reporte")
	public void reportes(HttpServletResponse response) {
		response.setHeader("Content-disposition", "inline;");
		response.setContentType("application/pdf");
		try {
			// carga el jasper
			String ru= resourceLoader.getResource("classpath:static/Waves.jasper").getURI().getPath(); // combinar el jasper con la conexión
			JasperPrint jasperPrint = JasperFillManager.fillReport (ru, null, dataSource.getConnection()); // genera el PDF
			OutputStream outStream = response.getOutputStream();
			// visualiza
			JasperExportManager.exportReportToPdfStream (jasperPrint, outStream);
			} catch (Exception e) {
			e.printStackTrace();
			}
}
	}
