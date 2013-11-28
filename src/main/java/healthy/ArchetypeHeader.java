/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package healthy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Yosvany Llerena Rodríguez <yosvanyllr@gmail.com>
 * @since 18-Jul-2013
 */
@XmlRootElement(name = "ArchetypeHeader")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArchetypeHeader")
public class ArchetypeHeader implements Serializable {

    private static final long serialVersionUID = 20130121009924L;
    @XmlElement(name = "type", required = true, nillable = false)
    private ArchetypeType type = ArchetypeType.OBSERVATION;
    @XmlElement(name = "name")
    private String name ="";
    @XmlElement(name = "author")
    private String author=""; 
    @XmlElement(name = "detail")
    private List<HeaderDetails> details = new ArrayList(0);

    /**
     * Default constructor
     */
    public ArchetypeHeader() { 
    }

    /**
     * Typed Constructor
     *
     * @param type Archetype Type (OBSERVATION, INSTRUCTION, EVALUATION)
     */
    public ArchetypeHeader(ArchetypeType type) {
        this.type = type;
    }

    /**
     *
     * @param type Archetype type
     * @param name Archetype name
     * @param author Archetype author
     */
    public ArchetypeHeader(ArchetypeType type, String name, String author) {
        this.type = type;
        this.name = name;
        this.author = author;
    }

    /**
     *
     * @param type Archetype type
     * @param name Archetype name
     * @param author Archetype author
     * @param details A list of Archetype details for each language
     */
    public ArchetypeHeader(ArchetypeType type, String name, String author, List<HeaderDetails> details) {
        this.type = type;
        this.name = name;
        this.author = author;
        this.details = new ArrayList(details);
    }

    /**
     *
     * @return archetype type
     */
    public ArchetypeType getType() {
        return type;
    }

    /**
     *
     * @return Archetype name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return Archetype author
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @return Header details list
     */
    public List<HeaderDetails> getDetails() {
        return details;
    }

    /**
     *
     * @param details
     */
    public void setDetails(List<HeaderDetails> details) {
        this.details = new ArrayList(details);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.author);
        hash = 97 * hash + Objects.hashCode(this.details);
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
        final ArchetypeHeader other = (ArchetypeHeader) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        return Objects.equals(this.details, other.details);
    }

    @Override
    public String toString() {
        return "ArchetypeHeader{" + "name=" + name + ", author=" + author + ", details=" + details + '}';
    }
}
