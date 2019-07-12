package what.is.brainbuster.pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TriviaResponse{

	@SerializedName("response_code")
	private int responseCode;

	@SerializedName("results")
	private List<ResultsItem> results;

	public void setResponseCode(int responseCode){
		this.responseCode = responseCode;
	}

	public int getResponseCode(){
		return responseCode;
	}

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	@Override
 	public String toString(){
		return 
			"TriviaResponse{" + 
			"response_code = '" + responseCode + '\'' + 
			",results = '" + results + '\'' + 
			"}";
		}
}