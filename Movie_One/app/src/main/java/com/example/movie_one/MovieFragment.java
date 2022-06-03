package com.example.movie_one;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movie_one.adapter.MovieAdapter;
import com.example.movie_one.databinding.FragmentMovieBinding;
import com.example.movie_one.interfaces.OnMovieItemClicked;
import com.example.movie_one.interfaces.ToolbarChanged;
import com.example.movie_one.models.Movie;
import com.example.movie_one.models.YtsData;
import com.example.movie_one.repository.MovieService;
import com.example.movie_one.utils.Define;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MovieFragment extends Fragment implements OnMovieItemClicked{
    private static MovieFragment instance;
    private FragmentMovieBinding movieBinding;
    private MovieService movieService;
    private static final String TAG = MovieFragment.class.getName();
    // 여기서 통신 요청을 할 예정이다.
    private MovieAdapter movieAdapter;
    private List<Movie> list = new ArrayList<Movie>();
    private int currentPage = 1;
    private ToolbarChanged callback;
    // 스크롤시 중복 이벤트 발생 해결 방안
    private boolean preventDuplicateScrollEvent = true;

    boolean isFirst = true;

    private MovieFragment(ToolbarChanged callback) {
        this.callback = callback;

    }

    public static MovieFragment getinstance(ToolbarChanged callback){
        if(instance == null){
            instance = new MovieFragment(callback);
        }
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieService = MovieService.retrofit.create(MovieService.class);
        callback.changeTitle(Define.FIRST_TITLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*
         onCreateView = 해당 프래그먼트에 대한 레이아웃을 반영하기 위해서은 해당 onCreate
                        View(프래그먼트 레이아웃의 루트)를 반드시 반환해야 한다.
                        xml로 정의된 레이아웃으로 부터 팽창시키기 위해 제공하는 객체 = inflator
                        activity 로부터 전달된 상위 ViewGroup = container
                        fragment가 재개되는 중인 경우 프래그먼트 이전의 인스턴트에 대한 데이터 제공
         */

        // findVeiwId를 대체하기 위해서 뷰바인딩 활용
        movieBinding = FragmentMovieBinding.inflate(inflater, container, false);

        // RecyclerView 만들어주기
        // 통신받기 전에 아직 없음 ->> 안드로이드는 입체적으로 생각
        setUpRecyclerView(list);
        Log.d("TAG", "currentPage : " + currentPage);
        if (isFirst) {
            requestMoviesData(currentPage);
        } else {
            progressbarGone();
        }


        return movieBinding.getRoot();
    }

    // 통신 해서 josn 객체를 받은 매개변수로 데이터를 넘길 예정

    /**
     * 서버와 통신을 하여서 데이터를 받아온다.
     *
     * @param requsetPage = 리미트를 걸었기 때문에 추가적인 데이터를 받고 싶을 때 페이지를 넘기면 된다.
     */
    private void requestMoviesData(int requsetPage) {
        int ITEM_LIMIT = 10;


        movieService.repoContributors("rating", ITEM_LIMIT, requsetPage).enqueue(new Callback<YtsData>() {
            @Override
            public void onResponse(Call<YtsData> call, Response<YtsData> response) {
                if (response.isSuccessful()) {
                    // 통신을 통해서 데이터를 넘겨 받았으면 어뎁터에 데이터를 전달하여서
                    // 화면을 갱신처리
                    List<Movie> list = response.body().getData().getMovies();
                    movieAdapter.addItemList(list);// 데이터를 받아와서 adapter 에게 데이터를 전달
                    ++currentPage;
                    preventDuplicateScrollEvent = true;
                    isFirst = false;
                    progressbarGone();
                }
            }

            @Override
            public void onFailure(Call<YtsData> call, Throwable t) {
                progressbarGone();
                Log.d(TAG, t.getMessage());
                // xml -> 오류화면 표시해줘라
            }
        });
    }

    /**
     * 리사이클러 뷰를 해당 프레그먼트에 셋팅
     * <p>
     * 필요한 것들
     * 1. 어뎁터
     * 2. 매니져
     * 3. xml 파일에 선언한 리사이클러 뷰에다가 세팅
     *
     * @param movieList
     */
    private void setUpRecyclerView(List<Movie> movieList) {
        movieAdapter = new MovieAdapter();
        movieAdapter.addList(movieList);
        movieAdapter.setClicked(this);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        movieBinding.movieRecyclerView.setAdapter(movieAdapter);
        movieBinding.movieRecyclerView.setLayoutManager(manager);
        movieBinding.movieRecyclerView.hasFixedSize();
        // + 이벤트 리스너
        movieBinding.movieRecyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {


            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                if (preventDuplicateScrollEvent == true) {
                    {
                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) (movieBinding.movieRecyclerView.getLayoutManager());
                        int lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                        Log.d("TAG", lastVisibleItemPosition + "");
                        // adapter의 list의 크기를 가지고 온다.
                        // 한번 통신을 했을 때 (10)
                        // 인덱스 값은 9 이다.
                        int itemTotalCount = movieBinding.movieRecyclerView.getAdapter().getItemCount() - 1;
                        if (lastVisibleItemPosition == itemTotalCount) {
                            if (currentPage != 1) {
                                Log.d("TAG", "왜 뜨냐");
                                // 네트워크 요청이 계속 될수 있으므로 조심해야 한다.
                                requestMoviesData(currentPage);
                                preventDuplicateScrollEvent = false;
                            }
                        }
                    }
                }
            }
        });
    }

    private void progressbarGone() {
        movieBinding.progressIndicator.setVisibility(View.GONE);
    }


    @Override
    public void selectedItem(Movie movie) {
        Intent intent = new Intent(getContext(), MovieDetailActivity.class);
        intent.putExtra(Define.PARAM_NAME_1, movie);
        // 직렬화란 오브젝트를 바이트 단위로 변환해서 던진다.
        startActivity(intent);
    }
}