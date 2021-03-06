package com.example.changeit.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.example.changeit.AppRepository;
import com.example.changeit.ChangeItApp;
import com.example.changeit.db.FilterValues;
import com.example.changeit.model.Advertisement;

import java.util.List;

/**
 * A view model for the start(home) page of the application.
 *
 * @author Kerstin Wadman, Noa Tholén, Lisa Samuelsson, Moa Berglund, Izabell Arvidsson, Marcus Randevik, Amanda Styff
 * @since 2020-04-04
 *
 */
public class HomeViewModel extends AndroidViewModel {

    /**
     * MutableLiveData used for filtering rooms. The number indicates the preset value of the slider.
     */
    private MutableLiveData<Integer> maxRooms = new MutableLiveData<>(5);

    /**
     * MutableLiveData used for filtering rent. The number indicates the preset value of the slider.
     */
    private MutableLiveData<Integer> maxRent = new MutableLiveData<>(5000);

    /**
     * MutableLiveData used for filtering sqm. The number indicates the preset value of the slider.
     */
    private MutableLiveData<Integer> maxSqm = new MutableLiveData<>(45);

    /**
     * A list of advertisements.
     */
    private LiveData<List<Advertisement>> advertisements;

    /**
     * A filter which combines all filters into one.
     */
    private CustomLiveData filter = new CustomLiveData(maxRooms, maxRent, maxSqm);

    /**
     * An instance of the app repository.
     */
    private final AppRepository repository;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        repository = ((ChangeItApp) application).getRepository();

        // The switch map makes sure that the advertisements shown corresponds to the current filtration
        advertisements = Transformations.switchMap(filter, filterValues -> repository.getAdvertisements(filterValues));

    }

    public LiveData<List<Advertisement>> getAdvertisements() {
        return advertisements;
    }

    public Integer getMaxRooms() {
        return maxRooms.getValue();
    }

    public void setMaxRooms(int maxRooms) {
        this.maxRooms.setValue(maxRooms);
    }

    public Integer getMaxRent() {
        return maxRent.getValue();
    }

    public void setMaxRent(int maxRent) {
        this.maxRent.setValue(maxRent);
    }

    public Integer getMaxSqm() {
        return maxSqm.getValue();
    }

    public void setMaxSqm(int maxSqm) {
        this.maxSqm.setValue(maxSqm);
    }

    public void changeFavourite(Advertisement advertisement) {
        repository.changeFavourite(advertisement);
    }


    /**
     * A class which allows us to combine multiple filter values into one.
     */
    public class CustomLiveData extends MediatorLiveData<FilterValues> {
        public CustomLiveData(LiveData<Integer> maxRooms, LiveData<Integer> maxRent, LiveData<Integer> maxSqm) {

            addSource(maxRooms, newMaxRooms -> setValue(new FilterValues(newMaxRooms, maxRent.getValue(), maxSqm.getValue())));
            addSource(maxRent, newMaxRent -> setValue(new FilterValues(maxRooms.getValue(), newMaxRent, maxSqm.getValue())));
            addSource(maxSqm, newMaxSqm -> setValue(new FilterValues(maxRooms.getValue(), maxRent.getValue(), newMaxSqm)));

        }
    }
}