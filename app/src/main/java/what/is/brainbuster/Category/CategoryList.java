package what.is.brainbuster.Category;

import androidx.fragment.app.Fragment;

public class CategoryList {
    private String categoryDescription, categoryQuery;
    private int imgId;

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public String getCategoryQuery() {
        return categoryQuery;
    }

    public void setCategoryQuery(String categoryQuery) {
        this.categoryQuery = categoryQuery;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public CategoryList (int imgId, String categoryQuery, String categoryDescription){
        this.imgId = imgId;
        this.categoryQuery = categoryQuery;
        this.categoryDescription = categoryDescription;
    }


}
