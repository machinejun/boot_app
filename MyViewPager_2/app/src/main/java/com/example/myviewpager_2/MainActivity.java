package com.example.myviewpager_2;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.core.content.ContextCompat;
        import androidx.viewpager2.widget.ViewPager2;

        import android.os.Bundle;
        import android.widget.ImageView;
        import android.widget.LinearLayout;

        import com.example.myviewpager_2.MovieSliderAdapter;
        import com.example.myviewpager_2.R;

        import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> images = new ArrayList<>();
    private ViewPager2 myViewPager2;
    private LinearLayout indicatorContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images.add("https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20220426_19%2F16509365610560EIGm_JPEG%2Fmovie_image.jpg");
        images.add("https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20220426_89%2F1650936584302EbdIF_JPEG%2Fmovie_image.jpg");
        images.add("https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20220426_87%2F1650936606581h5FqT_JPEG%2Fmovie_image.jpg");
        images.add("https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20220426_216%2F1650936633838obfoa_JPEG%2Fmovie_image.jpg");
        images.add("https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20220428_22%2F1651129118622VnVUM_PNG%2Fmovie_image.jpg");

        myViewPager2 = findViewById(R.id.myViewPager2);
        myViewPager2.setOffscreenPageLimit(2);
        myViewPager2.setAdapter(new MovieSliderAdapter(this, images));

        indicatorContainer = findViewById(R.id.indicatorContainer);
        newIndicator(images.size());

        myViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setIndicator(position);
            }
        });
    }

    private void newIndicator(int count) {
        ImageView[] indicators = new ImageView[count];

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        layoutParams.setMargins(8, 8, 8, 8);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(this);
            indicators[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.indicator_inactive));
            indicators[i].setLayoutParams(layoutParams);

            indicatorContainer.addView(indicators[i]);
        }
    }

    private void setIndicator(int position) {
        int indicatorCount = indicatorContainer.getChildCount();
        for (int i = 0; i < indicatorCount; i++) {
            ImageView indicator = (ImageView) indicatorContainer.getChildAt(i);

            if (i == position) {
                indicator.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.indicator_active));
            } else {
                indicator.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.indicator_inactive));
            }
        }
    }

}
