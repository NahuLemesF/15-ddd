package com.twilightimperium.expansioncommand.domain.faction.entities;

import com.twilightimperium.expansioncommand.domain.faction.values.ConqueredFactionId;
import com.twilightimperium.expansioncommand.domain.faction.values.Name;
import com.twilightimperium.expansioncommand.domain.faction.values.Percentage;
import com.twilightimperium.shared.domain.generic.Entity;

public class ConqueredFaction extends Entity<ConqueredFactionId> {
    private Name name;
    private Percentage percentage;

    public ConqueredFaction(Name name, Percentage percentage) {
        super(new ConqueredFactionId());
        this.name = name;
        this.percentage = percentage;
    }

    public ConqueredFaction(ConqueredFactionId identity, Name name, Percentage percentage) {
        super(identity);
        this.name = name;
        this.percentage = percentage;
    }

    public void updatePercentage(int conqueredSystems) {
        int increase = conqueredSystems * 10;

        int newPercentage = Math.min(100, Math.max(0, this.percentage.getValue() + increase));
        this.percentage = Percentage.of(newPercentage);
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Percentage getPercentage() {
        return percentage;
    }

    public void setPercentage(Percentage percentage) {
        this.percentage = percentage;
    }
}
