package com.digisystem.TestJavaDeveloper.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "person")
public class DataToPerson {
    @Id
    private String id;
    private PersonDetails pessoa;

    public PersonDetails getPessoa() {
        return pessoa;
    }

    public void setPessoa(PersonDetails pessoa) {
        this.pessoa = pessoa;
    }
}
