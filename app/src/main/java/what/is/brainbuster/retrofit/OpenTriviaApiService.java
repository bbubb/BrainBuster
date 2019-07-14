package what.is.brainbuster.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import what.is.brainbuster.pojo.TriviaResponse;

public interface OpenTriviaApiService {

    @GET("/api.php")
    Call<TriviaResponse> loadTriviaApi(@Query("amount") String numOfQuestions, @Query("category") String category, @Query("difficulty") String difficulty, @Query("type") String typeOfQuestion);

}
//https://opentdb.com/api.php?amount=10&category=9&difficulty=medium&type=multiple