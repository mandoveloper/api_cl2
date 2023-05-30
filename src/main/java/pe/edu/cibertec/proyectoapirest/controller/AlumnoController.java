package pe.edu.cibertec.proyectoapirest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.proyectoapirest.model.db.Alumno;
import pe.edu.cibertec.proyectoapirest.services.AlumnoService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "api/v1/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoServices;

    @GetMapping("")
    public ResponseEntity<List<Alumno>> listarAlumnos(){
        List<Alumno> alumnoList = new ArrayList<>();

        alumnoServices.listarAlumnos().forEach(alumnoList::add);

        if(alumnoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(alumnoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obtenerAlumnoxId(@PathVariable("id") String id){
        return new ResponseEntity<>(alumnoServices.buscarAlumnoxId(id).get(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Alumno> crearAlumno(@RequestBody Alumno alumno){
        Alumno newAlumno = new Alumno();
        newAlumno.setIdalumno(alumno.getIdalumno());
        newAlumno.setApealumno(alumno.getApealumno());
        newAlumno.setNomalumno(alumno.getNomalumno());
        newAlumno.setIdesp(alumno.getIdesp());
        newAlumno.setProce(alumno.getProce());
        return new ResponseEntity<>(alumnoServices.registrar(newAlumno), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizarAlumno(
            @PathVariable("id") String id,
            @RequestBody Alumno alumno
    ){
        Alumno updateAlumno = alumnoServices.buscarAlumnoxId(id).get();
        updateAlumno.setApealumno(alumno.getApealumno());
        updateAlumno.setNomalumno(alumno.getNomalumno());
        updateAlumno.setIdesp(alumno.getIdesp());
        updateAlumno.setProce(alumno.getProce());
        return new ResponseEntity<>(alumnoServices.registrar(updateAlumno), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAlumno(@PathVariable("id") String id){

        return new ResponseEntity<>(alumnoServices.eliminarxId(id), HttpStatus.OK);
    }

}
