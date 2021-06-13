package com.example.model;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.UUID;
@MappedSuperclass
public class BaseEntity {
    @Id
    private Long id;
    private String uuid = UUID.randomUUID().toString();
    @Version
    private long version;
    public BaseEntity() {
    }
    public BaseEntity(Long id, String uuid, long version) {
        this.id = id;
        this.uuid = uuid;
        this.version = version;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public long getVersion() {
        return version;
    }
    public void setVersion(long version) {
        this.version = version;
    }
}