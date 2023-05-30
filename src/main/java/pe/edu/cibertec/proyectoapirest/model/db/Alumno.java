package pe.edu.cibertec.proyectoapirest.model.db;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    private String idalumno;

    @Column(name = "apealumno")
    private String apealumno;

    @Column(name = "nomalumno")
    private String nomalumno;

    @Column(name = "idesp")
    private String idesp;

    @Column(name = "proce")
    private String proce;

}
