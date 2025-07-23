package org.primefaces.prime.view;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Logger;

import org.primefaces.prime.domain.Occupation;
import org.primefaces.prime.domain.SchoolProgram;
import org.primefaces.prime.service.OccupationService;

@Named
@ViewScoped
public class CareerView implements Serializable {
    
    private static final Logger logger = Logger.getLogger(CareerView.class.getName());
    
    @Inject
    private OccupationService occupationService;
    
    private Occupation occupation;
    private String onet;
    private boolean careerExists;

    @PostConstruct
    public void init() {
        logger.info("CareerView initialized");
        
        // Get ONET parameter from request, or use default
        String onetParam = FacesContext.getCurrentInstance()
            .getExternalContext()
            .getRequestParameterMap()
            .get("onet");
            
        logger.info("ONET parameter: " + onetParam);
        
        try {
            onet = (onetParam != null) ? onetParam : "11912100"; // Default ONET from JSON
            logger.info("Looking up occupation with ONET: " + onet);
            
            if (occupationService == null) {
                logger.severe("OccupationService is null - CDI injection failed");
                careerExists = false;
                return;
            }
            
            // Load occupation data from JSON
            occupation = occupationService.getOccupation();
            careerExists = (occupation != null);
            logger.info("Occupation loaded: " + careerExists);
            
            if (occupation != null) {
                logger.info("Occupation title: " + occupation.getTitle());
                logger.info("Number of tasks: " + (occupation.getTasks() != null ? occupation.getTasks().size() : 0));
                logger.info("Number of skills: " + (occupation.getSkills() != null ? occupation.getSkills().size() : 0));
            }
        } catch (Exception e) {
            logger.severe("Error loading occupation: " + e.getMessage());
            e.printStackTrace();
            careerExists = false;
        }
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public String getOnet() {
        return onet;
    }

    public void setOnet(String onet) {
        this.onet = onet;
    }

    public boolean isCareerExists() {
        return careerExists;
    }
    
    public String navigateToCareerList() {
        logger.info("Navigating to career list");
        
        // Get the jobId parameter from the request
        String jobId = FacesContext.getCurrentInstance()
            .getExternalContext()
            .getRequestParameterMap()
            .get("jobId");
            
        logger.info("JobId parameter: " + jobId);
        
        try {
            String redirectUrl = "/occupationSearchRevised.xhtml";
            if (jobId != null && !jobId.isEmpty()) {
                redirectUrl += "?jobId=" + jobId;
            }
            FacesContext.getCurrentInstance().getExternalContext().redirect(redirectUrl);
            return null;
        } catch (Exception e) {
            logger.severe("Error redirecting: " + e.getMessage());
            String fallbackUrl = "/occupationSearchRevised.xhtml?faces-redirect=true";
            if (jobId != null && !jobId.isEmpty()) {
                fallbackUrl += "&jobId=" + jobId;
            }
            return fallbackUrl;
        }
    }
    
    public String searchProgram(SchoolProgram program) {
        logger.info("Searching for program: " + (program != null ? program.getName() : "null"));
        
        if (program == null) {
            logger.warning("Program object is null");
            return "/occupationSearchRevised.xhtml?faces-redirect=true";
        }
        
        try {
            // Redirect to the search page with program parameters
            String redirectUrl = "/occupationSearchRevised.xhtml";
            StringBuilder params = new StringBuilder();
            
            if (program.getCip() != null && !program.getCip().isEmpty()) {
                params.append("programCip=").append(program.getCip());
            }
            
            if (program.getName() != null && !program.getName().isEmpty()) {
                if (params.length() > 0) {
                    params.append("&");
                }
                params.append("programName=").append(program.getName());
            }
            
            if (program.getDescription() != null && !program.getDescription().isEmpty()) {
                if (params.length() > 0) {
                    params.append("&");
                }
                params.append("programDescription=").append(program.getDescription());
            }
            
            if (params.length() > 0) {
                redirectUrl += "?" + params.toString();
            }
            
            logger.info("Redirecting to: " + redirectUrl);
            FacesContext.getCurrentInstance().getExternalContext().redirect(redirectUrl);
            return null;
        } catch (Exception e) {
            logger.severe("Error redirecting to search: " + e.getMessage());
            String fallbackUrl = "/occupationSearchRevised.xhtml?faces-redirect=true";
            if (program.getCip() != null && !program.getCip().isEmpty()) {
                fallbackUrl += "&programCip=" + program.getCip();
            }
            if (program.getName() != null && !program.getName().isEmpty()) {
                fallbackUrl += "&programName=" + program.getName();
            }
            if (program.getDescription() != null && !program.getDescription().isEmpty()) {
                fallbackUrl += "&programDescription=" + program.getDescription();
            }
            return fallbackUrl;
        }
    }
} 