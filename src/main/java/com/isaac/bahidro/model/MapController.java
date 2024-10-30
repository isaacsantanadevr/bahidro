package com.isaac.bahidro.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {

    // Mapeamento HTTP GET para a rota "/map". Quando essa URL for acessada,
    // o metodo 'showMap' sera chamado e ele retorna o nome da pagina a ser renderizada.
    @GetMapping("/map")
    public String showMap() {
        // Retorna a string "map", que corresponde ao nome do arquivo HTML (map.html)
        // que sera renderizado pelo Thymeleaf no frontend.
        return "map";
    }
}
