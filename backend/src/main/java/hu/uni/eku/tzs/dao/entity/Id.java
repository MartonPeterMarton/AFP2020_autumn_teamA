package hu.uni.eku.tzs.dao.entity;

import lombok.*;
import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Id {

<<<<<<< Updated upstream
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
=======
>>>>>>> Stashed changes
    @Column
    private int id;
}
