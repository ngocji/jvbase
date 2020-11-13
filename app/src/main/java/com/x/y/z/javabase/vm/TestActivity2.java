package com.x.y.z.javabase.vm;

import android.os.Bundle;

import com.jibase.anotation.ViewInflate;
import com.jibase.utils.Log;
import com.jivbase.ui.vm.BindActivity;
import com.x.y.z.javabase.R;

@ViewInflate(layout = R.layout.activity_main_2, viewModel = Test2ViewModel.class)
public class TestActivity2 extends BindActivity<Test2ViewModel> {
    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        viewModel.text.observe(this, text->{
            Log.e("Load: "+text);
        });


        viewModel.run();
    }

    @Override
    protected void onViewListener() {

    }
}
