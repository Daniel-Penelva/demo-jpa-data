package com.api.demo_jpa_data.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_PUBLISHER")
public class PublisherModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    // Uma editora publica muitos livros
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)        // está dizendo ao Jackson que este campo deve ser considerado apenas para escrita (desserialização - de json para java) e não para leitura (serialização - de java para json).
    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)    // indica que a propriedade está configurando o carregamento preguiçoso para evitar buscar dados relacionados desnecessariamente, melhorando o desempenho da minha aplicação.
    private Set<BookModel> bookModels = new HashSet<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BookModel> getBookModels() {
        return bookModels;
    }

    public void setBookModels(Set<BookModel> bookModels) {
        this.bookModels = bookModels;
    }
}
