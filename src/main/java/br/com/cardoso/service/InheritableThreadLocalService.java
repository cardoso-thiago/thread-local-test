package br.com.cardoso.service;

import br.com.cardoso.log.InheritableThreadLocalDynamicLog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class InheritableThreadLocalService {

    Logger logger = LoggerFactory.getLogger(InheritableThreadLocalService.class);
    ObjectMapper objectMapper = new ObjectMapper();

    public void logOne() throws JsonProcessingException {
        InheritableThreadLocalDynamicLog.put("1s", "1s");
        logger.info(objectMapper.writeValueAsString(InheritableThreadLocalDynamicLog.get()));
        InheritableThreadLocalDynamicLog.destroy();
    }

    public void logTwo() throws JsonProcessingException {
        InheritableThreadLocalDynamicLog.put("2s", "2s");
        logger.info(objectMapper.writeValueAsString(InheritableThreadLocalDynamicLog.get()));
        InheritableThreadLocalDynamicLog.destroy();
    }
}
