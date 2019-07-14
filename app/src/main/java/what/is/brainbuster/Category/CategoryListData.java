package what.is.brainbuster.Category;

import java.util.ArrayList;
import java.util.List;

import what.is.brainbuster.R;

public class CategoryListData {


    private static final List<Integer> categoryList = new ArrayList<Integer>(){{
        add(R.drawable.general);
        add(R.drawable.books);
        add(R.drawable.film);
        add(R.drawable.music);
        add(R.drawable.musicals);
        add(R.drawable.television);
        add(R.drawable.videogames);
        add(R.drawable.boardgames);
        add(R.drawable.science);
        add(R.drawable.computer);
        add(R.drawable.mathematics);
        add(R.drawable.mythology);
        add(R.drawable.sports);
        add(R.drawable.geography);
        add(R.drawable.history);
        add(R.drawable.politics);
        add(R.drawable.art);
        add(R.drawable.celebrity);
        add(R.drawable.animals);
        add(R.drawable.vehciles);
        add(R.drawable.comic);
        add(R.drawable.gadgets);
        add(R.drawable.anime);
        add(R.drawable.cartoons);
    }};

public static List<Integer> getCategoryList() {return categoryList;}
}
