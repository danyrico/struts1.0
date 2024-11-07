package com.dare.dado;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class DiceController {

    private final Random random = new Random();
    int turno = 0;
    
    List<Integer> historial = new ArrayList<>();

    //http://localhost:8080/tirar
    @GetMapping("/tirar")
    public int tirar() {
    	turno = turno + 1;
    	int resultado = random.nextInt(6) + 1;
    	historial.add(resultado);
        return resultado; 
    }
  
    @GetMapping("/historial")
    public List<Integer> historial() {
        return historial;  
    }
    
    @GetMapping("/turno")
    public int turno() {
        return turno;  
    }

    @GetMapping("/crear-partida")
    public int crearPartida() {
    	int id = 111;
    	turno = 0;
    	historial.clear();
        return id; 
    }
}
