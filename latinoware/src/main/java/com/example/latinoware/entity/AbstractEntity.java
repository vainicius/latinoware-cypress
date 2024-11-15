package com.example.latinoware.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
public class AbstractEntity {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Getter @Setter
    @Column(name = "dtCadastro", nullable = false)
    private LocalDateTime cadastro;

    @Getter @Setter
    @Column(name = "dtEdicao")
    private LocalDateTime edicao;

    @Getter @Setter
    @Column(name = "isAtivo", nullable = false)
    private boolean ativo;

@PrePersist
    private void prePersist(){
    this.cadastro = LocalDateTime.now();
    }
@PreUpdate
    private void preUpdate(){
    this.edicao = LocalDateTime.now();
    }

}
