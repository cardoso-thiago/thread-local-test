package br.com.cardoso.controller;

import br.com.cardoso.log.ThreadLocalDynamicLog;
import br.com.cardoso.service.ThreadLocalLogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/threadLocal")
public class ThreadLocalController {

    private final ThreadLocalLogService threadLocalLogService;

    public ThreadLocalController(ThreadLocalLogService threadLocalLogService) {
        this.threadLocalLogService = threadLocalLogService;
    }

    @GetMapping("/1")
    public String one() throws JsonProcessingException {
        ThreadLocalDynamicLog.put("1c", "1c");
        threadLocalLogService.logOne();
        return "ok";
    }

    @GetMapping("/2")
    public String two() throws JsonProcessingException {
        ThreadLocalDynamicLog.put("2c", "2c");
        threadLocalLogService.logTwo();
        return "ok";
    }
}