package com.projeto.beerbida.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projeto.beerbida.model.Cerveja;

@Controller
public class CervejasController {
	/*para configurar o URL para cair dentro desse método
	 * vamos usar o RequestMapping()
	 */
	@RequestMapping("/cervejas/novo")
	public String novo(){
		return "cerveja/CadastroCerveja";
	}
	//o spring já cria o objeto com os parâmetros que queremos.
	//por isso é importante ter o construtor padrão
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(Cerveja cerveja){
		System.out.println("Cerveja cadastrada com sucesso!");
		System.out.println("SKU: " + cerveja.getSku());
		System.out.println("NOME: " + cerveja.getNome());
		return "cerveja/CadastroCerveja";
		
	}

}
