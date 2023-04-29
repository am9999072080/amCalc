package pro.sky.amCalc.controller;


import org.springframework.web.bind.annotation.*;
import pro.sky.amCalc.service.CalculatorService;



@RestController
@RequestMapping("calculator")
public class CalculatorController {

    private final CalculatorService service;


    public CalculatorController(CalculatorService service) {
        this.service = service;
    }


    @GetMapping
    public String greeting() {
        return "<b>Добро пожаловать в калькулятор</b>";
    }

    @GetMapping(path = "plus")
    public String plus(@RequestParam double num1,
                       @RequestParam double num2) {
        double result = service.plus(num1, num2);
        return String.format("<b>результат: %.1f + %.1f = %.1f</b>", num1, num2, result);
    }

    @GetMapping(path = "minus")
    public String minus(@RequestParam double num1,
                        @RequestParam double num2) {
        double result = service.minus(num1, num2);
        return String.format("<b>результат: %.1f - %.1f = %.1f</b>", num1, num2, result);
    }

    @GetMapping(path = "multiply")
    public String multiply(@RequestParam double num1,
                           @RequestParam double num2) {
        double result = service.multiply(num1, num2);
        return String.format("<b>результат: %.1f * %.1f = %.1f</b>", num1, num2, result);
    }

    @GetMapping(path = "divide")
    public String divide(@RequestParam double num1,
                         @RequestParam double num2) {
        double result = service.divide(num1, num2);
        return String.format("<b>результат: %.1f / %.1f = %.1f</b>", num1, num2, result);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public String errorNotification(RuntimeException e) {
        return e.getMessage();


    }

}