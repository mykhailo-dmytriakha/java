package com.dmytriaha.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Calculation {
    private OperationType operation;
    private Double result;

    public OperationType getOperation() {
        return operation;
    }

    public void setOperation(OperationType operation) {
        this.operation = operation;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
