package com.digisystem.TestJavaDeveloper.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "pessoa")
public class DataToPersonUpdate {
    private int typeKeyToUpdate = 0; // type = 0 (id) or type = 1 (nome)
    private String keyToUpdate;
    private PersonDetails pessoa;

    public PersonDetails getPessoa() {
        return pessoa;
    }

    public void setPessoa(PersonDetails pessoa) {
        this.pessoa = pessoa;
    }

    public int getTypeKeyToUpdate() {
        return typeKeyToUpdate;
    }

    public String getKeyToUpdate() {
        return keyToUpdate;
    }

}
