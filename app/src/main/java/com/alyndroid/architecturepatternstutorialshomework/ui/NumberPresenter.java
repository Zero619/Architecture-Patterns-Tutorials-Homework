package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.data.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.data.NumberModel;

public class NumberPresenter {
    private NumberListener listener;

    public NumberPresenter(NumberListener listener) {
        this.listener = listener;
    }

    private NumberModel getNumberFromDatabase() {
        return new DataBase().getNumbers();
    }

    public void getNumbersDiv() {

        NumberModel numbers = getNumberFromDatabase();
        listener.onGetNumbersDiv(numbers.getFirstNum() / numbers.getSecondNum());
    }

    interface NumberListener {
        public void onGetNumbersDiv(int result);
    }

}
