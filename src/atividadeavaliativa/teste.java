/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadeavaliativa;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author mathe
 */
public class teste {

    public static void main(String[] args) {
        LocalDate data1 = LocalDate.of(2020, Month.JUNE, 21);
        LocalDate hoje = LocalDate.now();

        long diferencaEmDias = ChronoUnit.DAYS.between(hoje, data1);
        System.out.println("Diferença em dias entre " + hoje + " e " + data1 + " = " + diferencaEmDias);
    }

}
