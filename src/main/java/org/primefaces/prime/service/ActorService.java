package org.primefaces.prime.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.primefaces.prime.domain.Actor;
import org.primefaces.prime.domain.Skill;

@Named
@ApplicationScoped
public class ActorService {
    private final Map<Long, Actor> actors = new HashMap<>();

    public ActorService() {
        // Initialize with sample data
        List<Skill> actorSkills = Arrays.asList(
            new Skill("Reading Comprehension", 
                     "Understanding written sentences and paragraphs in work-related documents",
                     3.88, 3.88),
            new Skill("Speaking",
                     "Talking to others to convey information effectively",
                     3.88, 4.00),
            new Skill("Active Listening",
                     "Giving full attention to what other people are saying, taking time to understand the points being made",
                     3.75, 3.62),
            new Skill("Social Perceptiveness",
                     "Being aware of others' reactions and understanding why they react as they do",
                     3.75, 3.75),
            new Skill("Writing",
                     "Communicating effectively in writing as appropriate for the needs of the audience",
                     2.88, 3.38)
        );

        List<String> actorAbilities = Arrays.asList(
            "Oral Expression", "Oral Comprehension", "Memorization",
            "Speech Clarity", "Written Comprehension", "Originality",
            "Problem Sensitivity", "Fluency of Ideas"
        );

        Actor actor = new Actor(1L, "Actor", 
            "Actors entertain and communicate with people through their interpretation of dramatic roles.",
            actorSkills, actorAbilities);
        
        actors.put(actor.getId(), actor);
    }

    public Actor findById(Long id) {
        return actors.get(id);
    }
} 