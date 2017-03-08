package kanglg.auth.entity;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Created by kanglg on 2017/3/7.
 */
@Entity
@Table(name = "spring_session_attributes", schema = "webapp", catalog = "")
@IdClass(SpringSessionAttributesPK.class)
public class SpringSessionAttributes {
    private String sessionId;
    private String attributeName;
    private byte[] attributeBytes;

    @Id
    @Column(name = "SESSION_ID")
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Id
    @Column(name = "ATTRIBUTE_NAME")
    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    @Basic
    @Column(name = "ATTRIBUTE_BYTES")
    public byte[] getAttributeBytes() {
        return attributeBytes;
    }

    public void setAttributeBytes(byte[] attributeBytes) {
        this.attributeBytes = attributeBytes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpringSessionAttributes that = (SpringSessionAttributes) o;

        if (sessionId != null ? !sessionId.equals(that.sessionId) : that.sessionId != null) return false;
        if (attributeName != null ? !attributeName.equals(that.attributeName) : that.attributeName != null)
            return false;
        if (!Arrays.equals(attributeBytes, that.attributeBytes)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sessionId != null ? sessionId.hashCode() : 0;
        result = 31 * result + (attributeName != null ? attributeName.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(attributeBytes);
        return result;
    }
}
