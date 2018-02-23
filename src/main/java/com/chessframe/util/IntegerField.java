package com.chessframe.util;

import javafx.beans.NamedArg;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

// helper text field subclass which restricts text input to a given range of natural int numbers
// and exposes the current numeric int value of the edit box as a value property.

/**
 * The IntegerField is a TextField which only allows numbers as the input.
 *
 * @link https://stackoverflow.com/questions/7555564/what-is-the-recommended-way-to-make-a-numeric-textfield-in-javafx
 */
public class IntegerField extends TextField {
    final private IntegerProperty value;
    final private int minValue;
    final private int maxValue;

    /**
     * Constructor of the integer field.
     *
     * @param minValue the minimum value that can be entered
     * @param maxValue the maximum value that can be entered
     * @param value    the initial value of the text field
     */
    public IntegerField(@NamedArg("minValue") int minValue,
                        @NamedArg("maxValue") int maxValue,
                        @NamedArg("value") int value) {
        if (minValue > maxValue)
            throw new IllegalArgumentException(
                    "IntField min value " + minValue + " greater than max value " + maxValue
            );
        if (maxValue < minValue)
            throw new IllegalArgumentException(
                    "IntField max value " + minValue + " less than min value " + maxValue
            );
        if (!((minValue <= value) && (value <= maxValue)))
            throw new IllegalArgumentException(
                    "IntField value " + value + " not between " + minValue + " and " + maxValue
            );

        // initialize the field values.
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.value = new SimpleIntegerProperty(value);
        setText(value + "");

        final IntegerField intField = this;

        // make sure the value property is clamped to the required range
        // and update the field's text to be in sync with the value.
        this.value.addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                intField.setText("");
            } else {
                if (newValue.intValue() < intField.minValue) {
                    this.value.setValue(intField.minValue);
                    return;
                }

                if (newValue.intValue() > intField.maxValue) {
                    this.value.setValue(intField.maxValue);
                    return;
                }

                if (!(newValue.intValue() == 0 && (textProperty().get() == null || "".equals(textProperty().get())))) {
                    intField.setText(newValue.toString());
                }
            }
        });

        // restrict key input to numerals.
        this.addEventFilter(KeyEvent.KEY_TYPED, e -> {
            if (!"0123456789".contains(e.getCharacter())) {
                e.consume();
            }
        });

        // ensure any entered values lie inside the required range.
        this.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null || "".equals(newValue)) {
                this.value.setValue(0);
                return;
            }

            final int intValue = Integer.parseInt(newValue);

            if (intField.minValue > intValue || intValue > intField.maxValue) {
                textProperty().setValue(oldValue);
            }

            this.value.set(Integer.parseInt(textProperty().get()));
        });
    }


    /**
     * Getter for the current value entered in the box
     *
     * @return the currently entered value
     */
    public int getValue() {
        return value.getValue();
    }

    /**
     * Setter for the current value
     *
     * @param newValue the new value
     */
    public void setValue(int newValue) {
        value.setValue(newValue);
    }

    /**
     * Getter for the value property
     *
     * @return the value property
     */
    public IntegerProperty valueProperty() {
        return value;
    }
}