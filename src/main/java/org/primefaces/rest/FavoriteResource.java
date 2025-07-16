package org.primefaces.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Simple REST resource for handling favorites
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FavoriteResource implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // Simple session storage for favorites
    private Set<String> favorites = new HashSet<>();

    /**
     * Add a job to favorites
     */
    @POST
    @Path("/add/{jobId}")
    public Response addFavorite(@PathParam("jobId") String jobId) {
        try {
            if (jobId == null || jobId.trim().isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity(createErrorResponse("Job ID is required"))
                    .build();
            }

            favorites.add(jobId);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("jobId", jobId);
            response.put("message", "Added to favorites");

            return Response.ok(response).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(createErrorResponse("Error adding to favorites: " + e.getMessage()))
                .build();
        }
    }

    /**
     * Remove a job from favorites
     */
    @DELETE
    @Path("/remove/{jobId}")
    public Response removeFavorite(@PathParam("jobId") String jobId) {
        try {
            if (jobId == null || jobId.trim().isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity(createErrorResponse("Job ID is required"))
                    .build();
            }

            favorites.remove(jobId);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("jobId", jobId);
            response.put("message", "Removed from favorites");

            return Response.ok(response).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(createErrorResponse("Error removing from favorites: " + e.getMessage()))
                .build();
        }
    }

    /**
     * Check if a job is in favorites
     */
    public boolean isFavorite(String jobId) {
        return jobId != null && favorites.contains(jobId);
    }

    /**
     * Get all favorite job IDs
     */
    public Set<String> getFavorites() {
        return new HashSet<>(favorites);
    }

    /**
     * Create error response
     */
    private Map<String, Object> createErrorResponse(String message) {
        Map<String, Object> error = new HashMap<>();
        error.put("success", false);
        error.put("error", message);
        return error;
    }
} 