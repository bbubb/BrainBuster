package what.is.brainbuster;


import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import what.is.brainbuster.pojo.ResultsItem;
import what.is.brainbuster.pojo.TriviaResponse;
import what.is.brainbuster.retrofit.OpenTriviaApiService;
import what.is.brainbuster.retrofit.RetrofitClientInstance;


public class ActivityMain extends AppCompatActivity {

    private static final String TAG = "ActivityMain";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        ButterKnife.bind(this);

        StartFrag startFrag = new StartFrag();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_frame, startFrag, "Start Fragment")
                .commit();
    }
}

//    @OnClick(R.id.btn_start)

//    private void loadquestions(List<Objects> body) {
//        int numQuestions = body.size();
//        for(int i = 0; i<=numQuestions; i++){
//            ResultsItem resultsItem = new ResultsItem(body);