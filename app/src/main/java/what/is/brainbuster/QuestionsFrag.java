package what.is.brainbuster;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class QuestionsFrag extends Fragment {
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.questions_layout, container, false);
        unbinder = ButterKnife.bind(this, v);
        return v;
    }

    public interface OnStartClicked{
        void onStartClicked();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        unbinder.unbind();
    }
}
