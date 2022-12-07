package br.com.ekom.dynamicjson.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.ekom.dynamicjson.dto.OpenLibraryResponseDTO;

@Service
public class LivroService {
	Logger logger = LoggerFactory.getLogger(LivroService.class);
	public OpenLibraryResponseDTO consultaLivroApiExterna(String isbn) throws JsonMappingException, JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://openlibrary.org/api/books?bibkeys=ISBN:"+isbn+"&jscmd=details&format=json";

        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        
        Map<String, OpenLibraryResponseDTO> deserialize = 
        		new ObjectMapper().readValue(response.getBody(), new TypeReference<Map<String, OpenLibraryResponseDTO>>() {});

        logger.info("Open Library Response: " + deserialize);
        
        OpenLibraryResponseDTO openLibraryResponseDTO = deserialize.get("ISBN:"+isbn);

        return openLibraryResponseDTO;
    }
}
