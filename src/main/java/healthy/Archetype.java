/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package healthy;

import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This is a "base" Archetype container, it contains a header or archetype
 * formal definition, a description document wish contains the translations of
 * the body part and the body itself who defines the data content.
 *
 * @author Yosvany Llerena Rodríguez <yosvanyllr@gmail.com>
 */
@XmlRootElement(name = "Archetype")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Archetype")
public class Archetype implements Serializable {

    protected static final long serialVersionUID = 20130121009924L;
    protected static final Logger logger = Logger.getLogger(Archetype.class.getName());
    @XmlElement(name = "id", required = true, nillable = false)
    protected long id;
    @XmlElement(name = "header", type = ArchetypeHeader.class, required = true, nillable = false)
    protected ArchetypeHeader header;
    @XmlElement(name = "body", required = true, nillable = false) 
    protected String body ="";
    @XmlElement(name = "data") 
    protected String data ="";
    @XmlElement(name = "minimumParticipations", required = true, nillable = false)
    protected int minimumParticipations;

    /**
     * Default Constructor
     */
    public Archetype() { 
        this.minimumParticipations = 1;
    }

    /**
     * Constructor
     *
     * @param header this attribute is mandatory you must provide the header
     * information before do anything else with it.
     */
    public Archetype(ArchetypeHeader header) {
        if (header == null) {
            throw new NullPointerException("There is not content on header variable");
        }
        this.header = header; 
        this.minimumParticipations = 1;
    }

    /**
     * Do get this archetype type (OBSERVATION, INSTRUCTION, EVALUATION) if null
     * is returned then this instance do not have header definition and this
     * object is malformed (wont work like that)
     *
     * @return an ArchetypeType enumerator
     */
    public ArchetypeType getType() {
        if (header != null) {
            return header.getType();
        } else {
            return null;
        }
    }

    /**
     * Set minimum participation see {@link healthy.rim.Participation}
     *
     * @param minimumParticipations minimum participation id to be match
     */
    public void setMinimumParticipations(int minimumParticipations) {
        if (minimumParticipations < 1) {
            throw new Error("Minimum participations must be atleast one 1!");
        }
        this.minimumParticipations = minimumParticipations;
    }

    /**
     * Returns the actual minimum participations expected
     *
     * @return an integer
     */
    public int getMinimumParticipations() {
        return minimumParticipations;
    }

    /**
     * This archetype unique identifier
     *
     * @return long value
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return an ArchetypeHeader
     */
    public ArchetypeHeader getHeader() {
        return header;
    }

    /**
     * A DOM4J Document
     *
     * @return Document
     */
    public String getBody() {
        return body;
    }

    /**
     *
     * @param body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     *
     * @return xml Document (dom4j object)
     */
    public String getData() {
        return data;
    }

    /**
     *
     * @param data w3c xml Document
     */
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 79 * hash + (this.header == null ? 0 : this.header.hashCode());
        hash = 79 * hash + (this.body == null ? 0 : this.body.hashCode());
        hash = 79 * hash + (this.data == null ? 0 : this.data.hashCode());
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
        final Archetype other = (Archetype) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.header, other.header)) {
            return false;
        }
        if (!Objects.equals(this.body, other.body)) {
            return false;
        }
        return Objects.equals(this.data, other.data);
    }

    @Override
    public String toString() {
        return "Archetype{" + "id=" + id + "-" + header.getType().toString() + '}';
    }
}
