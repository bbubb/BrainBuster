package what.is.brainbuster;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.BindView;
import butterknife.Unbinder;

public class StartFrag extends Fragment {
    Unbinder unbinder;
    SettingsFrag settingsFrag;

    //use for categoryfrag
//    CategoryFrag categoryFrag;
//    String category;
//    RecyclerView recyclerViewCategory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.start_layout, container, false);
        unbinder = ButterKnife.bind(this, v);
        return v;
    }

    @OnClick(R.id.btn_start)
    public void startClicked() {
        SettingsFrag settingsFrag = new SettingsFrag();
        getFragmentManager()
                .beginTransaction()
                .add(R.id.settings_frame, settingsFrag, "Settings Fragment")
                .addToBackStack("category").commit();
        CategoryFrag categoryFrag = new CategoryFrag();
        getFragmentManager()
                .beginTransaction()
                .add(R.id.rv_category, categoryFrag, "Category Fragment")
                .addToBackStack("settings").commit();
//        mainFrame.setVisibility(View.GONE);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        unbinder.unbind();
    }
}
