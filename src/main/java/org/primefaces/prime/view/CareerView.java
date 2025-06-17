package org.primefaces.prime.view;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Logger;

import org.primefaces.prime.domain.Actor;
import org.primefaces.prime.service.ActorService;

@Named
@ViewScoped
public class CareerView implements Serializable {
    
    private static final Logger logger = Logger.getLogger(CareerView.class.getName());
    
    @Inject
    private ActorService actorService;
    
    private Actor actor;
    private Long actorId;

    @PostConstruct
    public void init() {
        logger.info("CareerView initialized");
        
        // For testing, default to ID 1 if no parameter is provided
        String idParam = FacesContext.getCurrentInstance()
            .getExternalContext()
            .getRequestParameterMap()
            .get("id");
            
        logger.info("ID parameter: " + idParam);
        
        try {
            actorId = (idParam != null) ? Long.parseLong(idParam) : 1L;
            logger.info("Looking up actor with ID: " + actorId);
            
            if (actorService == null) {
                logger.severe("ActorService is null - CDI injection failed");
                return;
            }
            
            actor = actorService.findById(actorId);
            logger.info("Actor loaded: " + (actor != null));
            
            if (actor != null && actor.getSkills() != null) {
                logger.info("Number of skills loaded: " + actor.getSkills().size());
            }
        } catch (NumberFormatException e) {
            logger.severe("Invalid ID format: " + idParam);
        } catch (Exception e) {
            logger.severe("Error loading actor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }
} 