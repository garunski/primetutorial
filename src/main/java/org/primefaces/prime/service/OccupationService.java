package org.primefaces.prime.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.primefaces.prime.domain.Occupation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

@Named
@ApplicationScoped
public class OccupationService {
    
    private static final Logger logger = Logger.getLogger(OccupationService.class.getName());
    private Occupation occupation;
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    public OccupationService() {
        loadOccupationData();
    }
    
    private void loadOccupationData() {
        try {
            logger.info("Loading occupation data from JSON file");
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("occupation.json");
            
            if (inputStream == null) {
                logger.severe("occupation.json file not found in classpath");
                return;
            }
            
            occupation = objectMapper.readValue(inputStream, Occupation.class);
            logger.info("Successfully loaded occupation: " + occupation.getTitle());

            if (occupation.getHasVideoFlag()) {
                occupation.setVideoUrl("https://www.youtube.com/embed/yd3MvZEdQi4");
            }
            
        } catch (IOException e) {
            logger.severe("Error loading occupation data: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public Occupation getOccupation() {
        return occupation;
    }
    
    public Occupation findByOnet(String onet) {
        if (occupation != null && occupation.getOnet().equals(onet)) {
            return occupation;
        }
        return null;
    }
    
    public boolean hasOccupationData() {
        return occupation != null;
    }
} 