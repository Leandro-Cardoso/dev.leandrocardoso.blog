package dev.leandrocardoso.blog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(
            nullable = false,
            unique = true
    )
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Post> posts;

}
