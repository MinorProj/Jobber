package comorgsminorproj.httpsgithub.jobber;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;

/**
 * Created by MK on 26-11-2017.
 */

public interface ElasticSearchAPI {

    @GET("_search/")
    Call<HitsObject> search(
            @HeaderMap Map<String, String> headers,
            @Query("default_operator") String operator,
            @Query("q") String query
<<<<<<< HEAD
            );
=======
    );
>>>>>>> jobber2 updated
}
