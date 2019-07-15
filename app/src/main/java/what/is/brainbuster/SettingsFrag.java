package what.is.brainbuster;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import what.is.brainbuster.Category.CategoryAdapter;
import what.is.brainbuster.Category.CategoryImageAssets;

public class SettingsFrag extends Fragment implements CategoryAdapter.OnCategorySelection {
    private Unbinder unbinder;
    private OnFragmentInteractionListener listener;
    String numOfQuestions, category, difficulty, jsonSettings;
    GameSettings gameSettings;
    MaterialButton btnSelected;
    ActivityMain activityMain;
    @BindView(R.id.dm_numOfQuestions)
    Spinner dmNumofQuestions;
    @BindView(R.id.btg_difficulty)
    MaterialButtonToggleGroup btgDifficulty;
    @BindView(R.id.rv_category)
    RecyclerView recyclerViewCategory;

    @Override
    public void categorySelected(String categoryQuery) {
        gameSettings.setCategory(categoryQuery);
    }

    interface OnFragmentInteractionListener {
        void startGameQuestions();
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement onViewSelection");
        }
    }


    @OnClick(R.id.btn_startGame)
    public void startGameClicked() {
        ActivityMain activityMain = new ActivityMain();
        Bundle gameSettingsBundle = new Bundle();
        gameSettings.setNumberOfQuestions(dmNumofQuestions.getSelectedItem().toString());
        gameSettings.getDifficulty();
        btgDifficulty.addOnButtonCheckedListener((group, checkedId, isChecked) ->
                gameSettings.setDifficulty(getText(checkedId).toString().toLowerCase()));
        jsonSettings = new Gson().toJson(gameSettings);
        gameSettingsBundle.putString("Game Settings", jsonSettings);

        activityMain.getQuestions(gameSettingsBundle);
        listener.startGameQuestions();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.settings_layout, container, false);
        unbinder = ButterKnife.bind(this, v);
        CategoryAdapter categoryAdapter = new CategoryAdapter(CategoryImageAssets.getCategoryList());
        recyclerViewCategory.setHasFixedSize(true);
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(recyclerViewCategory.getContext()));
        recyclerViewCategory.setAdapter(categoryAdapter);
        return v;

    }
}
