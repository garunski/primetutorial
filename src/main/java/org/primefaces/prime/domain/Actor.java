package org.primefaces.prime.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
    private Long id;
    private String title;
    private String description;
    private List<Skill> skills;
    private List<String> keyAbilities;
} 