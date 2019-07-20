package com.dti.codechallenge.server.viewmodel;

public class ApiResponseViewModel {
    public ApiResponseViewModel(boolean success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
    }

    private boolean success;
    private String errorMessage;

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
