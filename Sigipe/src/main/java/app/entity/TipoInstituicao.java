package app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TipoInstituicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
