package pe.edu.cibertec.proyectoapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.proyectoapirest.model.db.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, String> {
}
