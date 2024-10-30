package com.isaac.bahidro.controller;

import com.isaac.bahidro.model.Bacia;
import com.isaac.bahidro.repository.BaciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class BaciaController {

    // Aqui, deixo o Spring cuidar de injetar o repositorio automaticamente
    @Autowired
    private BaciaRepository baciaRepository;

    // Defino um logger para eu poder registrar mensagens de log
    private static final Logger logger = LoggerFactory.getLogger(BaciaController.class);

    // Esse metodo POST serve para adicionar uma nova bacia
    // Recebo os arquivos e o nome da bacia como parametros
    @PostMapping("/bacias/add")
    public String addBacia(
        @RequestParam("nome") String nome,
        @RequestParam("contornoGeoJson") MultipartFile contornoGeoJson,
        @RequestParam("drenagemGeoJson") MultipartFile drenagemGeoJson,
        @RequestParam("leitoGeoJson") MultipartFile leitoGeoJson,
        @RequestParam("csvData") MultipartFile csvData) {
    
        // Crio um novo objeto Bacia
        Bacia bacia = new Bacia();
        bacia.setNome(nome); // Atribuo o nome da bacia ao objeto
    
        try {
            // Verifico se os arquivos não estão vazios antes de convertê-los para string
            if (!contornoGeoJson.isEmpty()) {
                String contornoJson = new String(contornoGeoJson.getBytes());
                bacia.setContornoGeoJson(contornoJson);
            }

            if (!drenagemGeoJson.isEmpty()) {
                String drenagemJson = new String(drenagemGeoJson.getBytes());
                bacia.setDrenagemGeoJson(drenagemJson);
            }

            if (!leitoGeoJson.isEmpty()) {
                String leitoJson = new String(leitoGeoJson.getBytes());
                bacia.setLeitoGeoJson(leitoJson);
            }

            if (!csvData.isEmpty()) {
                String csvConteudo = new String(csvData.getBytes());
                bacia.setCsvData(csvConteudo);
            }

            // Salvo a bacia no banco de dados usando o repositório
            baciaRepository.save(bacia);
            logger.info("Bacia '{}' salva com sucesso.", bacia.getNome());
    
        } catch (Exception e) {
            // Caso algo dê errado, registro o erro no log e retorno uma pagina de erro
            logger.error("Erro ao processar os dados da bacia: ", e);
            return "error"; // Redireciono para uma pagina de erro
        }
    
        // Se tudo der certo, redireciono o usuario para a pagina principal
        return "redirect:/map";
    }

    // Esse metodo GET devolve todas as bacias cadastradas em formato JSON
    @GetMapping("/bacias/geojson")
    @ResponseBody
    public List<Bacia> getBaciasAsGeoJson() {
        // Simplesmente recupero todas as bacias do banco e retorno como lista
        return baciaRepository.findAll();
    }
}
