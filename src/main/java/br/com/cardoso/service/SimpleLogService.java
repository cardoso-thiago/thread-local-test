package br.com.cardoso.service;

import br.com.cardoso.log.SimpleDynamicLog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SimpleLogService {

    Logger logger = LoggerFactory.getLogger(SimpleLogService.class);
    ObjectMapper objectMapper = new ObjectMapper();

    public void logOne() throws JsonProcessingException {
        SimpleDynamicLog.put("1s", "1s");
        logger.info(objectMapper.writeValueAsString(SimpleDynamicLog.get()));
        SimpleDynamicLog.destroy();
    }

    public void logTwo() throws JsonProcessingException {
        SimpleDynamicLog.put("2s", "2s");
        logger.info(objectMapper.writeValueAsString(SimpleDynamicLog.get()));
        SimpleDynamicLog.destroy();
    }
}
