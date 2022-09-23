package br.com.cardoso.service;

import br.com.cardoso.log.ThreadLocalDynamicLog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ThreadLocalLogService {

    Logger logger = LoggerFactory.getLogger(ThreadLocalLogService.class);
    ObjectMapper objectMapper = new ObjectMapper();

    public void logOne() throws JsonProcessingException {
        ThreadLocalDynamicLog.put("1s", "1s");
        logger.info(objectMapper.writeValueAsString(ThreadLocalDynamicLog.get()));
        ThreadLocalDynamicLog.destroy();
    }

    public void logTwo() throws JsonProcessingException {
        ThreadLocalDynamicLog.put("2s", "2s");
        logger.info(objectMapper.writeValueAsString(ThreadLocalDynamicLog.get()));
        ThreadLocalDynamicLog.destroy();
    }
}
