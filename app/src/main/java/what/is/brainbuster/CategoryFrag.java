package what.is.brainbuster;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import what.is.brainbuster.Category.CategoryAdapter;
import what.is.brainbuster.Category.CategoryImageAssets;

public class CategoryFrag extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.rv_category) RecyclerView recyclerViewCategory;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.category_layout, container, false);
        unbinder = ButterKnife.bind(this, v);
        ImageView categoryIconImage = v.findViewById(R.id.iv_category);
        CategoryAdapter categoryAdapter = new CategoryAdapter(getContext(), CategoryImageAssets.getCategoryList());
        categoryIconImage.
                new LinearLayoutManager(recyclerViewCategory.getContext()));
        recyclerViewCategory.setHasFixedSize(true);
        return v;

    }
}
