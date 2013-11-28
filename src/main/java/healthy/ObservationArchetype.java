/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package healthy;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import healthy.rim.Observation;
import healthy.rim.Participation;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Yosvany Llerena Rodríguez <yosvanyllr@gmail.com>
 */
@XmlRootElement(name = "ObservationArchetype")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObservationArchetype")
public class ObservationArchetype extends Archetype {

    @XmlElement(name = "context", type = healthy.rim.Observation.class, required = true, nillable = false)
    private healthy.rim.Observation context;

    public ObservationArchetype() { 
    }

    public ObservationArchetype(Archetype archetype) {
        super(archetype.getHeader());
        if (!archetype.getType().equals(ArchetypeType.OBSERVATION)) {
            throw new Error("Archetype is not observation");
        }
        super.setId(archetype.getId());
        super.setBody(archetype.getBody());
        super.setData(archetype.getData());
        super.setMinimumParticipations(archetype.getMinimumParticipations());
    }

    /**
     *
     * @param header
     */
    public ObservationArchetype(ArchetypeHeader header) {
        super(header);
        if (header.getType().equals(ArchetypeType.OBSERVATION)) {
            throw new Error("Archetype is not observation kind");
        }
    }

    /**
     *
     * @param header
     * @param minimumParticipations
     */
    public ObservationArchetype(ArchetypeHeader header, int minimumParticipations) {
        super(header);
        if (header.getType().equals(ArchetypeType.OBSERVATION)) {
            throw new Error("Archetype is not observation kind");
        }
        super.setMinimumParticipations(minimumParticipations);
    }

    /**
     *
     * @param header
     * @param context
     */
    public ObservationArchetype(ArchetypeHeader header, Observation context) {
        super(header);
        if (header.getType().equals(ArchetypeType.OBSERVATION)) {
            throw new Error("Archetype is not observation kind");
        }
        this.context = context;
    }

    /**
     *
     * @return this archetype context
     */
    public Observation getContext() {
        return context;
    }

    /**
     *
     * @param context
     */
    public void setContext(Observation context) {
        this.context = context;
    }

    /**
     *
     *
     * @return unmodifiableSet
     */
    public Set<Participation> getParticipations() {
        return Collections.unmodifiableSet(context.getParticipations());
    }

    /**
     *
     * @param participations
     */
    public void setParticipations(Set<Participation> participations) {
        if (participations.size() < 1 || participations.size() < getMinimumParticipations()) {
            throw new Error("Minimum participations required is " + Integer.toString(getMinimumParticipations()));
        }
        context.getParticipations().addAll(participations);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.context);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ObservationArchetype other = (ObservationArchetype) obj;
        return Objects.equals(this.context, other.context);
    }

    @Override
    public String toString() {
        return "Contex{" + "act=" + context.toString() + '}';
    }
}
