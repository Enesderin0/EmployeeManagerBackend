package com.EmployeeManager.EmployeeManager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    private String type;

    @Column(name = "image")
    @Lob
    private byte[] file;

    public Image(String name, String type, byte[] file) {
        this.name = name;
        this.type = type;
        this.file = file;
    }


}
