package what.is.brainbuster;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.Unbinder;

public class SettingsFrag extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.settings_frame)
    FrameLayout settingsFrame;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.settings_layout, settingsFrame, false);
        unbinder = ButterKnife.bind(this, v);
        return v;
    }

    @OnItemClick

    @Override
    public void onDetach() {
        super.onDetach();
        unbinder.unbind();
    }
}
