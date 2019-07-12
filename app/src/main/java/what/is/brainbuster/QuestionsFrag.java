package what.is.brainbuster;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import what.is.brainbuster.pojo.ResultsItem;
import what.is.brainbuster.pojo.TriviaResponse;
import what.is.brainbuster.retrofit.OpenTriviaApiService;
import what.is.brainbuster.retrofit.RetrofitClientInstance;

public class QuestionsFrag extends Fragment {
    Unbinder unbinder;
    private static final String TAG = "QuestionsFrag";
    ArrayList<String> answers;
    String question, correctAnswer, questionNumber;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.tv_A)
    TextView tvA;
    @BindView(R.id.tv_B)
    TextView tvB;
    @BindView(R.id.tv_C)
    TextView tvC;
    @BindView(R.id.tv_D)
    TextView tvD;
    @BindView(R.id.tv_correct)
    TextView tvCorrect;
    @BindView(R.id.tv_wrong)
    TextView tvWrong;
    @BindView(R.id.btn_A)
    MaterialButton btnA;
    @BindView(R.id.btn_B)
    MaterialButton btnB;
    @BindView(R.id.btn_C)
    MaterialButton btnC;
    @BindView(R.id.btn_D)
    MaterialButton btnD;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.questions_layout, container, false);
        unbinder = ButterKnife.bind(this, v);

        retrofitRequest(1, 9, "easy", "multiple");
        return v;
    }

    public void retrofitRequest(int numOfQquestions, int category, String difficulty, String typeOfQuestions) {

        OpenTriviaApiService openTriviaApiService = RetrofitClientInstance.getRetrofit().create(OpenTriviaApiService.class);

        Call<TriviaResponse> triviaCall = openTriviaApiService.loadTriviaApi(numOfQquestions, category, difficulty, typeOfQuestions);

        triviaCall.enqueue(new Callback<TriviaResponse>() {
            @Override
            public void onResponse(Call<TriviaResponse> call, Response<TriviaResponse> response) {

                Log.d(TAG, "onResponse: Success");
                answers = new ArrayList<String>();
                question = "";
                correctAnswer = "";

                ResultsItem resultsItem = response.body().getResults().get(0);

                answers.addAll(resultsItem.getIncorrectAnswers());
                answers.add(resultsItem.getCorrectAnswer());
                correctAnswer = resultsItem.getCorrectAnswer();
                Collections.shuffle(answers);
                tvA.setText(answers.get(0));
                tvB.setText(answers.get(1));
                tvC.setText(answers.get(2));
                tvD.setText(answers.get(3));
                question = resultsItem.getQuestion();
                tvQuestion.setText(question);
            }

            @Override
            public void onFailure(Call<TriviaResponse> call, Throwable t) {

            }
        });
    }

    @OnClick({R.id.btn_A, R.id.btn_B, R.id.btn_C, R.id.btn_D})
    public void checkAnswer(MaterialButton v) {
        String btnText;
        switch (v.getId()) {
            case R.id.btn_A:
                btnText = (String) answers.get(0);
                if (btnText == correctAnswer) {
                    tvCorrect.setVisibility(View.VISIBLE);
                } else {
                    tvWrong.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.btn_B:
                btnText = answers.get(1);
                if (btnText == correctAnswer) {
                    tvCorrect.setVisibility(View.VISIBLE);
                } else {
                    tvWrong.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.btn_C:
                btnText = answers.get(2);
                if (btnText == correctAnswer) {
                    tvCorrect.setVisibility(View.VISIBLE);
                } else {
                    tvWrong.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.btn_D:
                btnText = answers.get(3);
                if (btnText == correctAnswer) {
                    tvCorrect.setVisibility(View.VISIBLE);
                } else {
                    tvWrong.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        unbinder.unbind();
    }
}
