package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.data.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.data.NumberModel;
import com.alyndroid.architecturepatternstutorialshomework.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity{

    NumberPresenter numberPresenter;
    NumberViewModel numberViewModel;
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        /**
         * MVC Architecture pattern
         */
        binding.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBase dataBase = new DataBase();
                NumberModel numbers = dataBase.getNumbers();
                int n1 = numbers.getFirstNum();
                int n2 = numbers.getSecondNum();
                int sum = n1 + n2;
                binding.plusResultTextView.setText("" + sum);
            }
        });


        /**
         * MVP Architecture pattern
         */
        numberPresenter = new NumberPresenter(new NumberPresenter.NumberListener() {
            @Override
            public void onGetNumbersDiv(int result) {
                binding.divResultTextView.setText("" + result);
            }
        });
        binding.divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPresenter.getNumbersDiv();
            }
        });


        /**
         * MVVM Architecture pattern
         */
        numberViewModel = new ViewModelProvider(this).get(NumberViewModel.class);
        binding.setViewModel(numberViewModel);
        binding.setLifecycleOwner(this);

        //replaced with @{} expression
        /*
        numberViewModel.mulResult.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer result) {
                binding.mulResultTextView.setText("" + result);
            }
        });

         */

        //replaced with onClick with @{()->} expression
        /*
        binding.mulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberViewModel.getNumbersMul();
            }
        });
         */

    }
}
