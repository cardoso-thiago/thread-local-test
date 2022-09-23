package br.com.cardoso.controller;

import br.com.cardoso.log.SimpleDynamicLog;
import br.com.cardoso.service.SimpleLogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simple")
public class SimpleController {

    private final SimpleLogService simpleLogService;

    public SimpleController(SimpleLogService simpleLogService) {
        this.simpleLogService = simpleLogService;
    }

    @GetMapping("/1")
    public String one() throws JsonProcessingException {
        SimpleDynamicLog.put("1c", "1c");
        simpleLogService.logOne();
        return "ok";
    }

    @GetMapping("/2")
    public String two() throws JsonProcessingException {
        SimpleDynamicLog.put("2c", "2c");
        simpleLogService.logTwo();
        return "ok";
    }
}
