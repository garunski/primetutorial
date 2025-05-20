package org.primefaces.service;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import org.primefaces.model.Job;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service class for providing job data and search functionality.
 */
@Named
@ApplicationScoped
public class JobService implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private List<Job> allJobs;
    private List<Job> filteredJobs;
    
    @PostConstruct
    public void init() {
        allJobs = createSampleJobs();
        filteredJobs = new ArrayList<>(allJobs);
    }
    
    /**
     * Creates a list of sample jobs for demonstration purposes.
     */
    private List<Job> createSampleJobs() {
        List<Job> jobs = new ArrayList<>();
        
        // Agriculture, Food and Natural Resources - Food Products and Processing Systems
        jobs.add(new Job("job1", "Food Scientist", "Agriculture | Food Science", "cluster1", "food-processing",
                "Research and develop new food products and improve existing ones. Analyze nutritional content and ensure food safety.",
                "$65,000 - $95,000", "Bachelor's Degree", 
                Arrays.asList("Food Chemistry", "Quality Control", "Laboratory Testing", "Research")));
        
        jobs.add(new Job("job2", "Agricultural Inspector", "Agriculture | Food Safety", "cluster1", "food-processing",
                "Inspect agricultural commodities, processing equipment, and facilities to ensure compliance with regulations and standards.",
                "$45,000 - $70,000", "Associate's Degree", 
                Arrays.asList("Inspection", "Regulation", "Documentation", "Safety Protocols")));
        
        // Agriculture, Food and Natural Resources - Plant Systems
        jobs.add(new Job("job3", "Plant Scientist", "Agriculture | Botany", "cluster1", "plant-systems",
                "Study plant growth, reproduction, and responses to environmental conditions to improve crop yields and sustainability.",
                "$60,000 - $90,000", "Master's Degree", 
                Arrays.asList("Botany", "Research", "Data Analysis", "Field Work")));
        
        jobs.add(new Job("job4", "Greenhouse Manager", "Agriculture | Horticulture", "cluster1", "plant-systems",
                "Oversee greenhouse operations, including plant cultivation, environmental controls, and staff management.",
                "$45,000 - $75,000", "Bachelor's Degree", 
                Arrays.asList("Plant Care", "Climate Control", "Inventory Management", "Staff Supervision")));
        
        // Architecture and Construction - Design/Pre-Construction
        jobs.add(new Job("job5", "Architect", "Architecture | Design", "cluster2", "design-preconstruction",
                "Design buildings and structures, considering aesthetics, functionality, safety, and sustainability.",
                "$70,000 - $120,000", "Master's Degree", 
                Arrays.asList("CAD Software", "Design", "Project Management", "Building Codes")));
        
        jobs.add(new Job("job6", "Civil Engineer", "Engineering | Construction", "cluster2", "design-preconstruction",
                "Design and oversee construction projects, including roads, buildings, airports, tunnels, dams, bridges, and water supply systems.",
                "$75,000 - $110,000", "Bachelor's Degree", 
                Arrays.asList("Structural Analysis", "AutoCAD", "Project Planning", "Mathematics")));
        
        // Architecture and Construction - Construction
        jobs.add(new Job("job7", "Construction Manager", "Construction | Management", "cluster2", "construction",
                "Plan, coordinate, budget, and supervise construction projects from development to completion.",
                "$80,000 - $120,000", "Bachelor's Degree", 
                Arrays.asList("Project Management", "Budgeting", "Contract Administration", "Leadership")));
        
        jobs.add(new Job("job8", "Electrician", "Construction | Electrical", "cluster2", "construction",
                "Install, maintain, and repair electrical wiring, equipment, and fixtures in buildings and other structures.",
                "$50,000 - $90,000", "Technical Certificate", 
                Arrays.asList("Electrical Systems", "Troubleshooting", "Blueprint Reading", "Safety Procedures")));
        
        // Arts, Audio/Video Technology and Communications - Performing Arts
        jobs.add(new Job("job9", "Actor", "Arts | Performance", "cluster3", "performing-arts",
                "Interpret and portray characters to entertain or inform audiences through stage, television, film, radio, or other media.",
                "$30,000 - $150,000", "Some College", 
                Arrays.asList("Performance", "Memorization", "Public Speaking", "Emotional Expression")));
        
        jobs.add(new Job("job10", "Music Director", "Arts | Music", "cluster3", "performing-arts",
                "Direct and conduct musical performances by orchestras, choirs, and other musical groups.",
                "$45,000 - $110,000", "Master's Degree", 
                Arrays.asList("Music Theory", "Conducting", "Leadership", "Performance")));
        
        // Business, Management and Administration - Management
        jobs.add(new Job("job11", "Chief Executive Officer", "Business | Executive Management", "cluster4", "management",
                "Provide overall direction for companies and organizations, formulate policies, and plan business objectives.",
                "$120,000 - $500,000", "Master's Degree", 
                Arrays.asList("Leadership", "Strategic Planning", "Decision Making", "Business Development")));
        
        jobs.add(new Job("job12", "Human Resources Manager", "Business | HR", "cluster4", "human-resources",
                "Plan, direct, and coordinate the administrative functions of an organization, including recruiting, interviewing, and hiring staff.",
                "$70,000 - $120,000", "Bachelor's Degree", 
                Arrays.asList("Recruitment", "Employee Relations", "Benefits Administration", "Conflict Resolution")));
        
        return jobs;
    }
    
    /**
     * Filters jobs based on URL parameters.
     */
    public List<Job> getFilteredJobs() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String clusterParam = params.get("cluster");
        String pathwayParam = params.get("pathway");
        
        if (clusterParam == null && pathwayParam == null) {
            return allJobs;
        }
        
        List<Job> result = allJobs;
        
        if (clusterParam != null) {
            result = result.stream()
                    .filter(job -> job.getCluster().equals(clusterParam))
                    .collect(Collectors.toList());
        }
        
        if (pathwayParam != null) {
            result = result.stream()
                    .filter(job -> job.getPathway().equals(pathwayParam))
                    .collect(Collectors.toList());
        }
        
        return result;
    }
    
    public List<Job> getAllJobs() {
        return allJobs;
    }
}
