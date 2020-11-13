package com.x.y.z.javabase.vm;

import com.jibase.livedata.ILiveData;
import com.jibase.ui.BaseViewModel;

public class Test2ViewModel extends BaseViewModel {
    public ILiveData<String> text = new ILiveData<>();

    public void run(){
        text.post("AAAAAAAAAAAAAAAAAAAAÂ");
    }
}
