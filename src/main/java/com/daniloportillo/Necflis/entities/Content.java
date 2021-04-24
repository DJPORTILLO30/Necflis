package com.daniloportillo.Necflis.entities;



import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contenido")
public class Content {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "resumen")
    private String summary;

    @Column(name = "categoria")
    private Long idCategory;

    @Column(name = "genero")
    private Long idGenre;


    @Column(name = "fecha")

    private Date dateCreated;


    public Content() {
    }

    public Content(Long id, String name, String summary, Long idCategory, Long idGenre, Date dateCreated) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.idCategory = idCategory;
        this.idGenre = idGenre;
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }


    public Long getIdCategory() {

        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public Long getIdGenre() {

        return idGenre;
    }

    public void setIdGenre(Long idGenre) {
        this.idGenre = idGenre;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(@DateTimeFormat(pattern = "yyyy.MM.ddd")  Date dateCreated) {
        this.dateCreated = dateCreated;
    }


}
