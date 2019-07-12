package what.is.brainbuster;


import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Objects;

import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import what.is.brainbuster.retrofit.OpenTriviaApiService;
import what.is.brainbuster.retrofit.RetrofitClientInstance;


public class ActivityMain extends AppCompatActivity {

    private static final String TAG = "ActivityMain";
    QuestionsFrag questionsFrag;


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

    @OnClick(R.id.btn_start)
    public void startClicked() {
        QuestionsFrag questionsFrag = new QuestionsFrag();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_frame, questionsFrag, "Questions Fragment")
                .commit();
    }

    public void retrofitRequest(int numOfQquestions, int category, String difficulty, String typeOfQuestions) {

        OpenTriviaApiService openTriviaApiService = RetrofitClientInstance.getRetrofit().create(OpenTriviaApiService.class);

        Call<List<Objects>> triviaCall = openTriviaApiService.loadTriviaApi(numOfQquestions, category, difficulty, typeOfQuestions);

        triviaCall.enqueue(new Callback<List<Objects>>() {
            @Override
            public void onResponse(Call<List<Objects>> call, Response<List<Objects>> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: Success");
                    questionsFrag(response.body());
                } else {
                    Log.d(TAG, "onResponse: Failure");
                }
            }

            @Override
            public void onFailure(Call<List<Objects>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }
}
