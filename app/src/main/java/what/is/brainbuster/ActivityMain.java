package what.is.brainbuster;


import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ActivityMain extends AppCompatActivity implements StartFrag.OnFragmentInteractionListener {

    private static final String TAG = "ActivityMain";
    private SettingsFrag settingsFrag;
    private StartFrag startFrag;

    private FragmentManager manager;

    @BindView(R.id.main_frame)
    FrameLayout mainFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        ButterKnife.bind(this);

        settingsFrag = new SettingsFrag();
        startFrag = new StartFrag();
        manager = getSupportFragmentManager();

        showFragment(startFrag,"Start Fragment");
    }

    private void showFragment(Fragment fragment, String tag) {
        manager.beginTransaction().replace(R.id.main_frame, fragment, tag).commit();
    }

    @Override
    public void startGame() {
        showFragment(settingsFrag, "Settings Fragment");
    }
}

//    @OnClick(R.id.btn_start)

//    private void loadquestions(List<Objects> body) {
//        int numQuestions = body.size();
//        for(int i = 0; i<=numQuestions; i++){
//            ResultsItem resultsItem = new ResultsItem(body);