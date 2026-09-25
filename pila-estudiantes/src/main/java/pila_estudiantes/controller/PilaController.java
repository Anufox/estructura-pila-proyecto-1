package sis.unifranz.pila.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sis.unifranz.pila.estructura.Pila;
import sis.unifranz.pila.model.Estudiante;

@RestController
@RequestMapping("/api/v1/estudiantes")
public class PilaController {

    private final Pila pila = new Pila();
    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody Estudiante estudiante) {

        try {
            pila.agregar(estudiante);

            return ResponseEntity.ok(
                    "Estudiante agregado correctamente"
            );

        } catch (RuntimeException e) {

            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<Estudiante[]> mostrar() {

        return ResponseEntity.ok(
                pila.mostrar()
        );
    }
    @DeleteMapping
    public ResponseEntity<?> quitar() {

        try {

            Estudiante estudiante = pila.quitar();

            return ResponseEntity.ok(estudiante);

        } catch (RuntimeException e) {

            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }
    @GetMapping("/tamanyo")
    public ResponseEntity<Integer> tamanyo() {

        return ResponseEntity.ok(
                pila.tamanyo()
        );
    }
}