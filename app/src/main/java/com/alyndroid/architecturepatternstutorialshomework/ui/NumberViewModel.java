package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alyndroid.architecturepatternstutorialshomework.data.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.data.NumberModel;

public class NumberViewModel extends ViewModel {
   public MutableLiveData<String> mulResult = new MutableLiveData<>();


    public void getNumbersMul() {
        NumberModel numbers = getNumberFromDatabase();
        mulResult.setValue(""+numbers.getFirstNum() * numbers.getSecondNum());
    }

    private NumberModel getNumberFromDatabase() {
        return new DataBase().getNumbers();
    }

}
