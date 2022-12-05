package br.unitins.abamanager.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.unitins.abamanager.model.Atividade;
import br.unitins.abamanager.repository.AtividadeRepository;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class AtividadeReportService {

	@Autowired
	private AtividadeRepository atividadeRepository;

	public String exportReport(String reportFormat, @PathVariable("idPaciente") Long id, RedirectAttributes redirect) throws FileNotFoundException, JRException {
		String path = "C:\\Users\\fabio\\Downloads";
		
		Sort sort = Sort.by("id").descending();
		List<Atividade> atividades = atividadeRepository.findAllByPaciente(id, sort);

		// carregar arquivo e compilar
		File file = ResourceUtils.getFile("classpath:atividadesreport.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(atividades);

		Map<String, Object> parametros = new HashMap<>();
		parametros.put("Relatorio gerado por: ", "ABAManager");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, dataSource);

//		if (reportFormat.equalsIgnoreCase("html")) {
//			JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\atividades.html");
//		}
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\atividades.pdf");
		}

		redirect.addFlashAttribute("message", "Download efetuado com sucesso");
		
		return "redirect:/atividades/{idPaciente}";
	}

}
