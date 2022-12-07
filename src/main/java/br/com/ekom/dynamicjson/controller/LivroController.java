package br.com.ekom.dynamicjson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.ekom.dynamicjson.dto.OpenLibraryResponseDTO;
import br.com.ekom.dynamicjson.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {
	@Autowired
	private LivroService livroService;
	
	@GetMapping("/{isbn}")
	public ResponseEntity<OpenLibraryResponseDTO> consultaLivroApiExterna(@PathVariable String isbn) throws JsonMappingException, JsonProcessingException {
		OpenLibraryResponseDTO openLibraryResponseDTO = livroService.consultaLivroApiExterna(isbn);
		if(openLibraryResponseDTO != null)
			return new ResponseEntity<>(openLibraryResponseDTO, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

}