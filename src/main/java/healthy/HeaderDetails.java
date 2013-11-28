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
@XmlRootElement(name = "HeaderDetails")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeaderDetails")
public class HeaderDetails implements Serializable {

    private static final long serialVersionUID = 20130121009924L;
    @XmlElement(name = "language", required = true, nillable = false)
    private String language;
    @XmlElement(name = "use")
    private String use;
    @XmlElement(name = "misUse")
    private String misUse;
    @XmlElement(name = "conceptName")
    private String conceptName;
    @XmlElement(name = "purpose")
    private String purpose; 
    @XmlElement(name = "keyword")
    private List<String> keywords = new ArrayList<>(0);

    public HeaderDetails() {
    }

    /**
     *
     * @param language An spoken language (en, en-UK, en-US for English; pt,
     * pt-PT for Portuguese; es, es-ES for spanish)
     * @param use when to use this archetype
     * @param misUse when you should not used this archetype.
     * @param conceptName a short description for this archetype.
     * @param purpose A full description for this archetype describing the
     * purpose and meaning.
     */
    public HeaderDetails(String language, String use, String misUse, String conceptName, String purpose) {
        this.language = language;
        this.use = use;
        this.misUse = misUse;
        this.conceptName = conceptName;
        this.purpose = purpose;
    }

    /**
     *
     * @param language
     * @param use
     * @param misUse
     * @param conceptName
     * @param purpose
     * @param keywords
     */
    public HeaderDetails(String language, String use, String misUse, String conceptName, String purpose,
            List<String> keywords) {
        this.language = language;
        this.use = use;
        this.misUse = misUse;
        this.conceptName = conceptName;
        this.purpose = purpose;
        this.keywords = new ArrayList(keywords);
    }

    /**
     *
     * @return the actual language
     */
    public String getLanguage() {
        return language;
    }

    /**
     *
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     *
     * @return when use
     */
    public String getUse() {
        return use;
    }

    /**
     *
     * @param use
     */
    public void setUse(String use) {
        this.use = use;
    }

    /**
     *
     * @return when not to use
     */
    public String getMisUse() {
        return misUse;
    }

    /**
     *
     * @param misUse
     */
    public void setMisUse(String misUse) {
        this.misUse = misUse;
    }

    /**
     *
     * @return short description
     */
    public String getConceptName() {
        return conceptName;
    }

    /**
     *
     * @param conceptName
     */
    public void setConceptName(String conceptName) {
        this.conceptName = conceptName;
    }

    /**
     *
     * @return a purpose
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     *
     * @param purpose
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    /**
     *
     * @return Header key word for current details language
     */
    public List<String> getKeywords() {
        return keywords;
    }

    /**
     *
     * @param keywords
     */
    public void setKeywords(List<String> keywords) {
        this.keywords = new ArrayList(keywords);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.language);
        hash = 29 * hash + Objects.hashCode(this.use);
        hash = 29 * hash + Objects.hashCode(this.misUse);
        hash = 29 * hash + Objects.hashCode(this.conceptName);
        hash = 29 * hash + Objects.hashCode(this.purpose);
        hash = 29 * hash + Objects.hashCode(this.keywords);
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
        final HeaderDetails other = (HeaderDetails) obj;
        if (!Objects.equals(this.language, other.language)) {
            return false;
        }
        if (!Objects.equals(this.use, other.use)) {
            return false;
        }
        if (!Objects.equals(this.misUse, other.misUse)) {
            return false;
        }
        if (!Objects.equals(this.conceptName, other.conceptName)) {
            return false;
        }
        if (!Objects.equals(this.purpose, other.purpose)) {
            return false;
        }
        return Objects.equals(this.keywords, other.keywords);
    }

    @Override
    public String toString() {
        return "HeaderDetails{" + "language=" + language + ", use=" + use + ", misUse=" + misUse + ", conceptName=" + conceptName + ", purpose=" + purpose + ", keywords=" + keywords + '}';
    }
}
