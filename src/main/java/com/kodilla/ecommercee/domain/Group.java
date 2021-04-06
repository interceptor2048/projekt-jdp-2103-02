package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PRODUCTS_GROUPS")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "GROUP_ID", unique = true)
    private Long groupId;

    @NotNull
    @Column(name = "GROUP_NAME")
    private String groupName;

    @OneToMany (
            targetEntity = Product.class,
            mappedBy = "productGroup",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Product> productList;


    public Group(@NotNull Long groupId, @NotNull String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }
}
