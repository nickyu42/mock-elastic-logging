package com.sap.enterprises.server.impl.math;

import java.util.Objects;

/**
 * Wrapper for integer type
 */
public class Integer {
    private int innerInt;

    public Integer(int innerInt) {
        this.innerInt = innerInt;
    }

    public int getInnerInt() {
        return innerInt;
    }

    public void setInnerInt(int innerInt) {
        this.innerInt = innerInt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Integer integer = (Integer) o;
        return innerInt == integer.innerInt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(innerInt);
    }
}
