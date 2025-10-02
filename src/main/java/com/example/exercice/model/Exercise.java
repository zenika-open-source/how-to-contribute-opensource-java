package com.example.exercice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Représente un exercice avec un identifiant, un nom et une description.
 */
@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    /**
     * Constructeur par défaut.
     */
    public Exercise() {
    }

    /**
     * Constructeur pour initialiser un exercice avec un nom et une description.
     *
     * @param name        Le nom de l'exercice.
     * @param description La description de l'exercice.
     */
    public Exercise(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Obtient l'identifiant de l'exercice.
     *
     * @return L'identifiant de l'exercice.
     */
    public Long getId() {
        return id;
    }

    /**
     * Définit l'identifiant de l'exercice.
     *
     * @param id L'identifiant à définir.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtient le nom de l'exercice.
     *
     * @return Le nom de l'exercice.
     */
    public String getName() {
        return name;
    }

    /**
     * Définit le nom de l'exercice.
     *
     * @param name Le nom à définir.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtient la description de l'exercice.
     *
     * @return La description de l'exercice.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Définit la description de l'exercice.
     *
     * @param description La description à définir.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
