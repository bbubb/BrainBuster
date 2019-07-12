package what.is.brainbuster.retrofit;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenTriviaApiService {

    @GET("api.php")
    Call<List<Objects>> loadTriviaApi(@Query("amount") int numOfQuestions, @Query("category") int category, @Query("difficulty") String difficulty, @Query("type") String typeOfQuestion);

}
//https://opentdb.com/api.php?amount=10&category=9&difficulty=medium&type=multiple