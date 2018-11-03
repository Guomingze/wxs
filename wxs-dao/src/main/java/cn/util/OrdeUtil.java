package cn.util;

import org.springframework.stereotype.Component;

@Component
public class OrdeUtil {
    private Integer oid;
    private Integer uid;
    private Integer number;
    private String code;

    public Integer getOid() {
        return this.oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return this.uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
