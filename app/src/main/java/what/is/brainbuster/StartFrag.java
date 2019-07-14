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
    @BindView(R.id.main_frame)
    FrameLayout mainFrame;

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
                .replace(R.id.main_frame, settingsFrag, "Settings Fragment")
                .commit();
        mainFrame.setVisibility(View.GONE);



        //use for categoryFrag
//        getFragmentManager()
//                .beginTransaction()
//                .replace(R.id.rv_category, categoryFrag, "Category Selection")
//                .addToBackStack("Category").commit();

    }

    @Override
    public void onDetach() {
        super.onDetach();
        unbinder.unbind();
    }
}
