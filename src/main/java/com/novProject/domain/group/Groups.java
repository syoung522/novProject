package com.novProject.domain.group;

import com.novProject.domain.BaseTimeEntity;
import com.novProject.domain.stack.Stack;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Groups extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "groups_id")
    private Long id;

    @Column(name = "groups_name", nullable = false)
    private String name;

    @Column(name = "groups_leader", nullable = false, length = 500)
    private String leader;

    @Column(name = "groups_category", nullable = false, length = 500)
    private String category;

    @Column(name = "groups_startDate", nullable = false)
    private String startDate;

    @Column(name = "groups_endDate", nullable = false)
    private String endDate;

    @OneToMany
    private List<Stack> stack;

    @Builder //lombok
    public Groups(String name, String leader, String category, String startDate, String endDate, List<Stack> stack){
        this.name = name;
        this.leader = leader;
        this.category = category;
        this.startDate = startDate;
        this.endDate = endDate;
        this.stack = stack;
    }
}
