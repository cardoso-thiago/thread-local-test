package br.com.cardoso.controller;

import br.com.cardoso.log.InheritableThreadLocalDynamicLog;
import br.com.cardoso.service.InheritableThreadLocalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/iThreadLocal")
public class InheritableThreadLocalController {

    private final InheritableThreadLocalService inheritableThreadLocalService;

    public InheritableThreadLocalController(InheritableThreadLocalService inheritableThreadLocalService) {
        this.inheritableThreadLocalService = inheritableThreadLocalService;
    }

    @GetMapping("/1")
    public String one() throws JsonProcessingException {
        InheritableThreadLocalDynamicLog.put("1c", "1c");
        inheritableThreadLocalService.logOne();
        return "ok";
    }

    @GetMapping("/2")
    public String two() throws JsonProcessingException {
        InheritableThreadLocalDynamicLog.put("2c", "2c");
        inheritableThreadLocalService.logTwo();
        return "ok";
    }
}
