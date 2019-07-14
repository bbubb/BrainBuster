package what.is.brainbuster.Category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import what.is.brainbuster.R;
import what.is.brainbuster.SettingsFrag;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private CategoryList[] categoryData;
    private Context context;
    private OnCategorySelection categoryToSettingsListener;
    SettingsFrag settingsFrag;

    public interface OnCategorySelection{
        void categorySelected(Integer category);
    }

    public CategoryAdapter (CategoryList[] categoryData, OnCategorySelection onCategorySelection){
        this.categoryData = categoryData;
        this.categoryToSettingsListener = onCategorySelection;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemList = inflater.inflate(R.layout.category_layout, parent, false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(itemList);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        final CategoryList categoryList = categoryData[position];
        holder.ivCategory.setImageResource(categoryData[position].getImgId());
        holder.itemView.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryToSettingsListener.categorySelected(category);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{
        ImageView ivCategory;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCategory = itemView.findViewById(R.id.iv_category);
        }
    }
}
