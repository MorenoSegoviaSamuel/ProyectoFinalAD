package org.api.miprimeraapirest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "constructors")
public class Constructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "constructorid")
    private Long constructorId;

    @Column(name = "constructorref", unique = true)
    private String constructorRef;

    @Column(unique = true, name = "name")
    private String name;

    private String nationality;
    private String url;
    

    @OneToMany(mappedBy = "constructor" , cascade = CascadeType.ALL)
    @JsonIgnoreProperties("constructor")
    private List<Driver> drivers;

    public Constructor(long l, String aaa, String constructorAaa, String nationalityAaa, String urlAaa) {
    }

    public Constructor(Long o, String ccc, String constructorCcc, String nationalityCcc, String urlCcc) {
    }
}