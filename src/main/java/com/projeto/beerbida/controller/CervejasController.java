package com.projeto.beerbida.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CervejasController {
	/*para configurar o URL para cair dentro desse método
	 * vamos usar o RequestMapping()
	 */
	@RequestMapping("/cervejas/novo")
	public String novo(){
		return "cerveja/CadastroCerveja";
	}

}
