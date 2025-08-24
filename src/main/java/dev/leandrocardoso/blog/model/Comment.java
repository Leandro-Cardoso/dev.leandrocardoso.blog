package dev.leandrocardoso.blog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_comments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String message;

    @OneToMany(
            mappedBy = "comment",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Reply> replies;

}
