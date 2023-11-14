package com.novProject.domain.stack;

import com.novProject.domain.group.Groups;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Getter
@NoArgsConstructor
@Entity
public class Stack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stack_id")
    private Long id;

    @Column(name = "stack_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "groups_id", nullable = false)
    private Groups groups;

    @Builder
    public Stack(Long id, String name, Groups groups) {
        this.id = id;
        this.name = name;
        this.groups = groups;
    }
}
