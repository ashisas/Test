package com.example.postgresdemo.model;

import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;

@Entity
@Table(name = "encry")
public class EncyptionEntity {

    @Id
    @GeneratedValue(generator = "answer_generator")
    @SequenceGenerator(
            name = "answer_generator",
            sequenceName = "answer_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column(name = "test_encrypt",columnDefinition = "bytea")
   // @ColumnTransformer(read = "decrypt(test_encrypt)",write = "encrypt(?)")
    @ColumnTransformer(
            forColumn="test_encrypt",
            read="pgp_sym_encrypt(test_encrypt::bytea, 'mySecretKey')",
            write="pgp_sym_decrypt(?, 'mySecretKey')")
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
