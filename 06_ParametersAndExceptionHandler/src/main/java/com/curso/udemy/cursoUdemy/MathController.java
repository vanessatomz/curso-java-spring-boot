package com.curso.udemy.cursoUdemy;

import com.curso.udemy.cursoUdemy.exceptions.UnsupportedMathOperationExcept;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne")String numberOne,
                      @PathVariable(value = "numberTwo")String numberTwo)throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationExcept("Por favor digite um valor númerico!");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private boolean isNumeric(String a){
        if(a == null) return false;

        String number = a.replaceAll(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+"); //true ou false
    }

    private Double convertToDouble(String x){
        if(x == null) return 0D;

        String number = x.replaceAll(",",".");
        if(isNumeric(number)) return Double.parseDouble(number);

        return 0D;
    }
}

