package vn.edu.usth.weather;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
public class ViewPagerAdapter extends FragmentStateAdapter {
    private static final int PAGE_COUNT = 3;
    private final String[] titles = new String[] {"HANOI, VIETNAM", "PARIS, FRANCE","TOULOUSE, FRANCE"};
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new WeatherAndForecastFragment();
            case 1: return new WeatherAndForecastFragment();
            case 2: return new WeatherAndForecastFragment();
        }
        return new WeatherAndForecastFragment();
    }
    @Override
    public int getItemCount() {
        return PAGE_COUNT;
    }
    public String getPageTitle(int page) {
        return titles[page];
    }
}