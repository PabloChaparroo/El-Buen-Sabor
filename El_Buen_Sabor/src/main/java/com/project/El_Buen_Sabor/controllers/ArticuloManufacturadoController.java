package com.project.El_Buen_Sabor.controllers;

import com.project.El_Buen_Sabor.entities.ArticuloManufacturado;
import com.project.El_Buen_Sabor.services.ArticuloManufacturadoService.ArticuloManufacturadoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")//permite el acceso desde distintos clientes
@RequestMapping(path = "api/v1/articuloManufacturados")
public class ArticuloManufacturadoController extends  BaseControllerImpl<ArticuloManufacturado, ArticuloManufacturadoServiceImpl> {

    @GetMapping("/search")
    public ResponseEntity<?> buscarPorFiltro(@RequestParam String filtro) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorFiltro(filtro));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/rankingArticulos")
    public ResponseEntity<?> RankingArticuloManufacturado(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) {
        try {
            List<Object[]> clientes = servicio.RankingArticuloManufacturado(fechaInicio, fechaFin);
            return ResponseEntity.status(HttpStatus.OK).body(clientes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }


}
