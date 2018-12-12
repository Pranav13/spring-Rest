package com.wiredbrain.friends.util;

public class FieldErrorMessage {
    private String dield;
    private String message;

    public FieldErrorMessage(String dield, String message) {
        this.dield = dield;
        this.message = message;
    }

    public String getDield() {
        return dield;
    }

    public void setDield(String dield) {
        this.dield = dield;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
