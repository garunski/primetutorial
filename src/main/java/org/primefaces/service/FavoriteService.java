package org.primefaces.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Service class for managing job favorites.
 */
@Named
@ApplicationScoped
public class FavoriteService implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // In-memory storage for favorites (in a real app, this would be in a database)
    private Set<String> favoriteJobIds = new HashSet<>();

    /**
     * Adds a job to favorites
     * @param jobId The job ID to add to favorites
     */
    public void addToFavorites(String jobId) {
        if (jobId != null && !jobId.trim().isEmpty()) {
            favoriteJobIds.add(jobId);
        }
    }

    /**
     * Removes a job from favorites
     * @param jobId The job ID to remove from favorites
     */
    public void removeFromFavorites(String jobId) {
        if (jobId != null) {
            favoriteJobIds.remove(jobId);
        }
    }

    /**
     * Checks if a job is in favorites
     * @param jobId The job ID to check
     * @return true if the job is in favorites, false otherwise
     */
    public boolean isFavorite(String jobId) {
        return jobId != null && favoriteJobIds.contains(jobId);
    }

    /**
     * Toggles the favorite status of a job
     * @param jobId The job ID to toggle
     */
    public void toggleFavorite(String jobId) {
        if (jobId != null && !jobId.trim().isEmpty()) {
            if (isFavorite(jobId)) {
                removeFromFavorites(jobId);
            } else {
                addToFavorites(jobId);
            }
        }
    }

    /**
     * Gets all favorite job IDs
     * @return Set of favorite job IDs
     */
    public Set<String> getFavoriteJobIds() {
        return new HashSet<>(favoriteJobIds);
    }

    /**
     * Gets the count of favorite jobs
     * @return Number of favorite jobs
     */
    public int getFavoriteCount() {
        return favoriteJobIds.size();
    }
} 