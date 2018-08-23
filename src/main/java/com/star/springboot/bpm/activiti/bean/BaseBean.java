package com.star.springboot.bpm.activiti.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class BaseBean {

    public BaseBean(){}

    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this, new String[0]);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, new String[0]);
    }
}
