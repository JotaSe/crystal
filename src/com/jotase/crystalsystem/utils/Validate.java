/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jotase.crystalsystem.utils;

import java.util.Set;
import javax.swing.JOptionPane;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author JotaSe
 */
public class Validate {
    
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    public boolean validate(Object obj) {
        Set<ConstraintViolation<Object>> constraintViolations;
        constraintViolations = validator.validate(obj);
        //System.out.println("Size: " + constraintViolations.size());
        String errores = "";
        for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
            errores += constraintViolation.getMessage() + "\n";
        }

        if (!errores.equals("")) {
            JOptionPane.showMessageDialog(null, errores);
            return false;
        } else {
            return true;
        }
    }
}
