package what.is.brainbuster.Category;

import java.util.ArrayList;
import java.util.List;

import what.is.brainbuster.R;

public class CategoryImageAssets {


    private static final CategoryList[] categoryList = new CategoryList[]{
        new CategoryList(R.drawable.general, "9", "General Knowledge"),
        new CategoryList(R.drawable.books, "10", "Books"),
        new CategoryList(R.drawable.film, "11", "Film"),
        new CategoryList(R.drawable.music, "12", "Music"),
        new CategoryList(R.drawable.musicals, "13", "Musicals and Theatre"),
        new CategoryList(R.drawable.television, "14", "Television"),
        new CategoryList(R.drawable.videogames, "15", "Video Games"),
        new CategoryList(R.drawable.boardgames, "16", "Board Games"),
        new CategoryList(R.drawable.science,"17", "Science & Nature"),
        new CategoryList(R.drawable.computer,"18", "Computers"),
        new CategoryList(R.drawable.mathematics, "19", "Mathematics"),
        new CategoryList(R.drawable.mythology, "20", "Mythology"),
        new CategoryList(R.drawable.sports, "21", "Sports"),
        new CategoryList(R.drawable.geography, "22", "Geography"),
        new CategoryList(R.drawable.history, "23", "History"),
        new CategoryList(R.drawable.politics, "24", "Politics"),
        new CategoryList(R.drawable.art, "25", "Art"),
        new CategoryList(R.drawable.celebrity, "26", "Celebrities"),
        new CategoryList(R.drawable.animals, "27", "Animals"),
        new CategoryList(R.drawable.vehciles, "28", "Vehicles"),
        new CategoryList(R.drawable.comic, "29", "Comics"),
        new CategoryList(R.drawable.gadgets, "30", "Gadgets"),
        new CategoryList(R.drawable.anime, "31", "Japanese Anime & Manga"),
        new CategoryList(R.drawable.cartoons, "32", "Cartoons & Animations"),
    };

public static CategoryList[] getCategoryList() {return categoryList;}
}
