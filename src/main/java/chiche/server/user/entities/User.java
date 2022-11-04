package chiche.server.user.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Setter @Getter
public class User {

    // Por Hacer:
    // - Verifica que el nombre de la tabla esté generado correctamente
    // - Añade los atributos necesarios, recuerda que debe ser en inglés

    // No hace falta generar Getter y Setter

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
