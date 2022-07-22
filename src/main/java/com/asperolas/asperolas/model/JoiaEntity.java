package com.asperolas.asperolas.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class JoiaEntity {

    @Id
    @GeneratedValue
    @Column(updatable = false, unique = true, nullable = false)
    private long id;

    @Column(nullable = false)
    private String material;

    @Column(nullable = false)
    private Double peso;

    @Column(nullable = false)
    private Integer quilates;
}
