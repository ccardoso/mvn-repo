package healthy.rim.type;import javax.xml.bind.annotation.XmlAccessType;import javax.xml.bind.annotation.XmlAccessorType;import javax.xml.bind.annotation.XmlElement;import javax.xml.bind.annotation.XmlRootElement;import javax.xml.bind.annotation.XmlType;/** * An identifier that uniquely identifies a thing or object. Examples are object * identifier for a medical record number, order id, service catalogue item id, * Vehicle Identification Number (VIN), etc. Instance identifiers are defined * based on ISO object identifiers. * * @author Yosvany Llerena Rodríguez <yosvanyllr@gmail.com> * @since 21-Jan-2013 */@XmlRootElement(name = "II")@XmlAccessorType(XmlAccessType.FIELD)@XmlType(name = "II", propOrder = {    "root",    "extension",    "assigningAuthorityName"})public class II extends RimDataType {    @XmlElement(required = true)    private String root = "";    @XmlElement    private String extension = "";    @XmlElement    private String assigningAuthorityName = "";    public II() {    }    public II(String root, String extension, String assigningAuthorityName) {        this.root = root;        this.extension = extension;        this.assigningAuthorityName = assigningAuthorityName;    }    public String getRoot() {        return root;    }    public void setRoot(String root) {        this.root = root;    }    public String getExtension() {        return extension;    }    public void setExtension(String extension) {        this.extension = extension;    }    public String getAssigningAuthorityName() {        return assigningAuthorityName;    }    public void setAssigningAuthorityName(String assigningAuthorityName) {        this.assigningAuthorityName = assigningAuthorityName;    }    @Override    public int hashCode() {        int hash = 7;        hash = 89 * hash + (this.root != null ? this.root.hashCode() : 0);        hash = 89 * hash + (this.extension != null ? this.extension.hashCode() : 0);        hash = 89 * hash + (this.assigningAuthorityName != null ? this.assigningAuthorityName.hashCode() : 0);        return hash;    }    @Override    public boolean equals(Object obj) {        if (obj == null) {            return false;        }        if (getClass() != obj.getClass()) {            return false;        }        final II other = (II) obj;        if ((this.root == null) ? (other.root != null) : !this.root.equals(other.root)) {            return false;        }        if ((this.extension == null) ? (other.extension != null) : !this.extension.equals(other.extension)) {            return false;        }        if ((this.assigningAuthorityName == null) ? (other.assigningAuthorityName != null) : !this.assigningAuthorityName.equals(other.assigningAuthorityName)) {            return false;        }        return true;    }    @Override    public String toString() {        return "II{" + "root=" + root + ", extension=" + extension + ", assigningAuthorityName=" + assigningAuthorityName + '}';    }}