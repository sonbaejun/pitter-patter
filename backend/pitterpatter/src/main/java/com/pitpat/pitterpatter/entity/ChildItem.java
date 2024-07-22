package com.pitpat.pitterpatter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class ChildItem {

    @Id
    @GeneratedValue
    @Column(name = "child_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private Child child;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private boolean is_on;

    public ChildItem(Child child, Item item, boolean is_on) {
        this.child = child;
        this.item = item;
        this.is_on = is_on;
    }
}
