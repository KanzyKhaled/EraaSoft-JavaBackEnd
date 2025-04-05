package Ewallet.service.impl;

import Ewallet.service.DataValidation;

public class DataValidationImpl implements DataValidation {
    @Override
    public boolean validateUserName(String userName) {
        // TODO check if username size >= 3 and first char is upper return true
        // else return false
        if(userName != null && userName.length() >= 3 && Character.isUpperCase(userName.charAt(0))) {
            return true;
        }
        return false;
    }

    @Override
    public boolean validatePassword(String password) {
        // TODO check if password size >= 6 and must contain number , char upper, char lower and special char return true
        if (password == null || password.length() < 6) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if (!Character.isLetterOrDigit(ch)) hasSpecial = true;
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;

    }
}