package com.isaac.bahidro.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bacias")
public class Bacia {

    // Campo que serve como identificador unico da bacia no MongoDB
    @Id
    private String id;

    // Nome da bacia
    private String nome;

    // Campos para armazenar os dados GeoJSON de contorno, drenagem e leito da bacia
    private String contornoGeoJson;
    private String drenagemGeoJson;
    private String leitoGeoJson;

    // Campo para armazenar os dados CSV adicionais sobre a bacia
    private String csvData;

    // Construtor padrao sem parametros, necessario para o funcionamento correto do framework
    public Bacia() {}

    // Construtor com parametros para facilitar a criacao de objetos Bacia
    public Bacia(String nome, String contornoGeoJson, String drenagemGeoJson, String leitoGeoJson, String csvData) {
        this.nome = nome;
        this.contornoGeoJson = contornoGeoJson;
        this.drenagemGeoJson = drenagemGeoJson;
        this.leitoGeoJson = leitoGeoJson;
        this.csvData = csvData;
    }

    // Metodos getters e setters para acessar e modificar os valores dos campos

    // Retorna o ID da bacia
    public String getId() {
        return id;
    }

    // Define o ID da bacia
    public void setId(String id) {
        this.id = id;
    }

    // Retorna o nome da bacia
    public String getNome() {
        return nome;
    }

    // Define o nome da bacia
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Retorna o contorno GeoJSON da bacia
    public String getContornoGeoJson() {
        return contornoGeoJson;
    }

    // Define o contorno GeoJSON da bacia
    public void setContornoGeoJson(String contornoGeoJson) {
        this.contornoGeoJson = contornoGeoJson;
    }

    // Retorna os dados de drenagem GeoJSON da bacia
    public String getDrenagemGeoJson() {
        return drenagemGeoJson;
    }

    // Define os dados de drenagem GeoJSON da bacia
    public void setDrenagemGeoJson(String drenagemGeoJson) {
        this.drenagemGeoJson = drenagemGeoJson;
    }

    // Retorna os dados do leito GeoJSON da bacia
    public String getLeitoGeoJson() {
        return leitoGeoJson;
    }

    // Define os dados do leito GeoJSON da bacia
    public void setLeitoGeoJson(String leitoGeoJson) {
        this.leitoGeoJson = leitoGeoJson;
    }

    // Retorna os dados CSV da bacia
    public String getCsvData() {
        return csvData;
    }

    // Define os dados CSV da bacia
    public void setCsvData(String csvData) {
        this.csvData = csvData;
    }
}
