package com.test.max.factor;

import com.test.max.validation.Validatable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Request implements Validatable {

    private Double v2;
    private Integer v3;
    private Integer v4;

    public Double getV2() {
        return v2;
    }

    public void setV2(Double v2) {
        this.v2 = v2;
    }

    public Integer getV3() {
        return v3;
    }

    public void setV3(Integer v3) {
        this.v3 = v3;
    }

    public Integer getV4() {
        return v4;
    }

    public void setV4(Integer v4) {
        this.v4 = v4;
    }

    public boolean isValid() {
        return v2 != null
                && v3 != null
                && v4 != null;
    }
}