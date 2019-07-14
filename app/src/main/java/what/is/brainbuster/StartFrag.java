package what.is.brainbuster;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class StartFrag extends Fragment {
    Unbinder unbinder;
    SettingsFrag settingsFrag;
    String category;
    RecyclerView recyclerViewCategory;
    private OnFragmentInteractionListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement onViewSelected");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.start_layout, container, false);
        unbinder = ButterKnife.bind(this, v);
        return v;
    }

    @OnClick(R.id.btn_start)
    public void startClicked() {
        listener.startGame();


//        setVisibility(View.GONE);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        unbinder.unbind();
    }

    interface OnFragmentInteractionListener {
        void startGame();
    }
}
