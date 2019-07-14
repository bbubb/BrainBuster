package what.is.brainbuster.Category;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import what.is.brainbuster.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private CategoryList[] categoryData;
    private OnCategorySelection categoryToSettingsListener;


    public interface OnCategorySelection{
        void categorySelected(String categoryQuery);
    }

    public CategoryAdapter (CategoryList[] categoryData){
        this.categoryData = categoryData;
//        this.categoryToSettingsListener = onCategorySelection;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemList = inflater.inflate(R.layout.category_item, parent, false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(itemList);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.ivCategory.setImageResource(categoryData[position].getImgId());
        holder.itemView.setTooltipText(categoryData[position].getCategoryDescription());
        holder.itemView.setOnClickListener(view -> categoryToSettingsListener.categorySelected(categoryData[position].getCategoryQuery()));
    }

    @Override
    public int getItemCount() {
        return categoryData.length;
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{
        public ImageView ivCategory;
        public MaterialCardView materialCardView;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            this.ivCategory = itemView.findViewById(R.id.iv_category);
            materialCardView = itemView.findViewById(R.id.cv_category);

        }
    }
}
