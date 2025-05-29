package org.primefaces.service;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
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
                "$65,000 - $95,000", "College Degree Required (4+ Years)",
                Arrays.asList("Food Chemistry", "Quality Control", "Laboratory Testing", "Research"),
                "Wy0qhA_QeZA")); // YouTube video ID for Food Scientist career

        jobs.add(new Job("job2", "Agricultural Inspector", "Agriculture | Food Safety", "cluster1", "food-processing",
                "Inspect agricultural commodities, processing equipment, and facilities to ensure compliance with regulations and standards.",
                "$45,000 - $70,000", "Moderate Training (1-2 Years)",
                Arrays.asList("Inspection", "Regulation", "Documentation", "Safety Protocols")));

        // Agriculture, Food and Natural Resources - Plant Systems
        jobs.add(new Job("job3", "Plant Scientist", "Agriculture | Botany", "cluster1", "plant-systems",
                "Study plant growth, reproduction, and responses to environmental conditions to improve crop yields and sustainability.",
                "$60,000 - $90,000", "Advanced Degree Required (6+ Years)",
                Arrays.asList("Botany", "Research", "Data Analysis", "Field Work")));

        jobs.add(new Job("job4", "Greenhouse Manager", "Agriculture | Horticulture", "cluster1", "plant-systems",
                "Oversee greenhouse operations, including plant cultivation, environmental controls, and staff management.",
                "$45,000 - $75,000", "College Degree Required (4+ Years)",
                Arrays.asList("Plant Care", "Climate Control", "Inventory Management", "Staff Supervision")));

        // Architecture and Construction - Design/Pre-Construction
        jobs.add(new Job("job5", "Architect", "Architecture | Design", "cluster2", "design-preconstruction",
                "Design buildings and structures, considering aesthetics, functionality, safety, and sustainability.",
                "$70,000 - $120,000", "Advanced Degree Required (6+ Years)",
                Arrays.asList("CAD Software", "Design", "Project Management", "Building Codes"),
                "QygAMzzVLrY")); // YouTube video ID for Architect career

        jobs.add(new Job("job6", "Civil Engineer", "Engineering | Construction", "cluster2", "design-preconstruction",
                "Design and oversee construction projects, including roads, buildings, airports, tunnels, dams, bridges, and water supply systems.",
                "$75,000 - $110,000", "College Degree Required (4+ Years)",
                Arrays.asList("Structural Analysis", "AutoCAD", "Project Planning", "Mathematics")));

        // Architecture and Construction - Construction
        jobs.add(new Job("job7", "Construction Manager", "Construction | Management", "cluster2", "construction",
                "Plan, coordinate, budget, and supervise construction projects from development to completion.",
                "$80,000 - $120,000", "College Degree Required (4+ Years)",
                Arrays.asList("Project Management", "Budgeting", "Contract Administration", "Leadership")));

        jobs.add(new Job("job8", "Electrician", "Construction | Electrical", "cluster2", "construction",
                "Install, maintain, and repair electrical wiring, equipment, and fixtures in buildings and other structures.",
                "$50,000 - $90,000", "Moderate Training (1-2 Years)",
                Arrays.asList("Electrical Systems", "Troubleshooting", "Blueprint Reading", "Safety Procedures")));

        // Arts, Audio/Video Technology and Communications - Performing Arts
        jobs.add(new Job("job9", "Actor", "Arts | Performance", "cluster3", "performing-arts",
                "Interpret and portray characters to entertain or inform audiences through stage, television, film, radio, or other media.",
                "$30,000 - $150,000", "Moderate Training (1-2 Years)",
                Arrays.asList("Performance", "Memorization", "Public Speaking", "Emotional Expression"),
                "j_ntNNw_hn8")); // YouTube video ID for Actor career

        jobs.add(new Job("job10", "Music Director", "Arts | Music", "cluster3", "performing-arts",
                "Direct and conduct musical performances by orchestras, choirs, and other musical groups.",
                "$45,000 - $110,000", "Advanced Degree Required (6+ Years)",
                Arrays.asList("Music Theory", "Conducting", "Leadership", "Performance")));

        // Business, Management and Administration - Management
        jobs.add(new Job("job11", "Chief Executive Officer", "Business | Executive Management", "cluster4", "management",
                "Provide overall direction for companies and organizations, formulate policies, and plan business objectives.",
                "$120,000 - $500,000", "Advanced Degree Required (6+ Years)",
                Arrays.asList("Leadership", "Strategic Planning", "Decision Making", "Business Development")));

        jobs.add(new Job("job12", "Human Resources Manager", "Business | HR", "cluster4", "human-resources",
                "Plan, direct, and coordinate the administrative functions of an organization, including recruiting, interviewing, and hiring staff.",
                "$70,000 - $120,000", "College Degree Required (4+ Years)",
                Arrays.asList("Recruitment", "Employee Relations", "Benefits Administration", "Conflict Resolution")));

        // Additional jobs to showcase all preparation levels
        jobs.add(new Job("job13", "Dishwasher", "Food Service | Kitchen", "cluster5", "food-service",
                "Clean dishes, kitchen utensils, and equipment in restaurants and other food service establishments.",
                "$20,000 - $25,000", "No Experience Required - Start Right Away",
                Arrays.asList("Physical Stamina", "Attention to Detail", "Time Management")));

        jobs.add(new Job("job14", "Retail Salesperson", "Sales | Customer Service", "cluster6", "retail",
                "Sell merchandise to customers in retail establishments, assist with product selection and provide customer service.",
                "$25,000 - $35,000", "Short-Term Training (Few Months)",
                Arrays.asList("Customer Service", "Product Knowledge", "Communication", "Sales Techniques")));

        jobs.add(new Job("job15", "Security Guard", "Protective Services | Security", "cluster7", "security",
                "Monitor premises to prevent theft, violence, or infractions of rules and maintain order.",
                "$28,000 - $40,000", "Short-Term Training (Few Months)",
                Arrays.asList("Observation", "Communication", "Physical Fitness", "Report Writing")));

        return jobs;
    }

    /**
     * Filters jobs based on URL parameters.
     */
    public List<Job> getFilteredJobs() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String clusterParam = params.get("cluster");
        String pathwayParam = params.get("pathway");
        String educationParam = params.get("education");

        // Education cluster filters
        boolean artsHumanities = "true".equals(params.get("artsHumanities"));
        boolean businessInfoSystems = "true".equals(params.get("businessInfoSystems"));
        boolean engineeringTech = "true".equals(params.get("engineeringTech"));
        boolean healthServices = "true".equals(params.get("healthServices"));

        // STEM discipline filters
        boolean architectureEngineering = "true".equals(params.get("architectureEngineering"));
        boolean computerMathematical = "true".equals(params.get("computerMathematical"));
        boolean healthcarePractitioners = "true".equals(params.get("healthcarePractitioners"));
        boolean lifeSocialScience = "true".equals(params.get("lifeSocialScience"));

        // Check if any filters are applied
        boolean hasFilters = clusterParam != null || pathwayParam != null ||
                            (educationParam != null && !educationParam.isEmpty()) ||
                            artsHumanities || businessInfoSystems || engineeringTech || healthServices ||
                            architectureEngineering || computerMathematical ||
                            healthcarePractitioners || lifeSocialScience;

        if (!hasFilters) {
            return allJobs;
        }

        List<Job> result = allJobs;

        // Apply career cluster filter
        if (clusterParam != null) {
            result = result.stream()
                    .filter(job -> job.getCluster().equals(clusterParam))
                    .collect(Collectors.toList());
        }

        // Apply career pathway filter
        if (pathwayParam != null) {
            result = result.stream()
                    .filter(job -> job.getPathway().equals(pathwayParam))
                    .collect(Collectors.toList());
        }

        // Apply education level filter
        if (educationParam != null && !educationParam.isEmpty()) {
            result = result.stream()
                    .filter(job -> {
                        String education = job.getEducationRequired().toLowerCase();
                        switch (educationParam) {
                            case "jobzone1":
                                return education.contains("no experience required") || education.contains("start right away");
                            case "jobzone2":
                                return education.contains("short-term training") || education.contains("few months");
                            case "jobzone3":
                                return education.contains("moderate training") || education.contains("1-2 years");
                            case "jobzone4":
                                return education.contains("college degree required") || education.contains("4+ years");
                            case "jobzone5":
                                return education.contains("advanced degree required") || education.contains("6+ years");
                            // Keep backward compatibility with old values
                            case "highschool":
                                return education.contains("high school") || education.contains("no experience required") || education.contains("short-term training");
                            case "somecollege":
                                return education.contains("some college") || education.contains("moderate training");
                            case "associates":
                                return education.contains("associate") || education.contains("moderate training");
                            case "bachelors":
                                return education.contains("bachelor") || education.contains("college degree required");
                            case "masters":
                                return education.contains("master") || education.contains("advanced degree required");
                            case "doctoral":
                                return education.contains("doctoral") || education.contains("phd") || education.contains("advanced degree required");
                            default:
                                return true;
                        }
                    })
                    .collect(Collectors.toList());
        }

        // Apply education cluster filters
        if (artsHumanities || businessInfoSystems || engineeringTech || healthServices) {
            result = result.stream()
                    .filter(job -> {
                        String category = job.getCategory().toLowerCase();
                        if (artsHumanities && (category.contains("art") || category.contains("humanities"))) {
                            return true;
                        }
                        if (businessInfoSystems && (category.contains("business") || category.contains("information"))) {
                            return true;
                        }
                        if (engineeringTech && (category.contains("engineering") || category.contains("technology"))) {
                            return true;
                        }
                        if (healthServices && category.contains("health")) {
                            return true;
                        }
                        return !(artsHumanities || businessInfoSystems || engineeringTech || healthServices);
                    })
                    .collect(Collectors.toList());
        }

        // Apply STEM discipline filters
        if (architectureEngineering || computerMathematical || healthcarePractitioners || lifeSocialScience) {
            result = result.stream()
                    .filter(job -> {
                        String category = job.getCategory().toLowerCase();
                        List<String> skills = job.getSkills();
                        String skillsStr = skills != null ? String.join(" ", skills).toLowerCase() : "";

                        if (architectureEngineering && (category.contains("architecture") || category.contains("engineering"))) {
                            return true;
                        }
                        if (computerMathematical && (category.contains("computer") || category.contains("math"))) {
                            return true;
                        }
                        if (healthcarePractitioners && (category.contains("healthcare") || skillsStr.contains("healthcare"))) {
                            return true;
                        }
                        if (lifeSocialScience && (category.contains("science") || skillsStr.contains("research"))) {
                            return true;
                        }
                        return !(architectureEngineering || computerMathematical || healthcarePractitioners || lifeSocialScience);
                    })
                    .collect(Collectors.toList());
        }

        return result;
    }

    public List<Job> getAllJobs() {
        return allJobs;
    }
}
