package com.x.y.z.javabase.vm;

import android.content.Intent;
import android.os.Bundle;

import com.jibase.anotation.ViewInflate;
import com.jibase.utils.Log;
import com.jivbase.ui.vm.BindActivity;
import com.x.y.z.javabase.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

@ViewInflate(layout = R.layout.activty_main_1, viewModel = TestViewModel.class)
public class TestActivity1 extends BindActivity<TestViewModel> {
    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        viewModel.check.observe(this, check->{
            Log.e("load: "+check);
        });

        viewModel.check.post(true);
    }

    @Override
    protected void onViewListener() {

    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        startActivity(new Intent(this, TestActivity2.class));
    }
}
