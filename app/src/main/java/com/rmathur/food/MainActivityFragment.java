package com.rmathur.food;

import android.location.Location;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.rmathur.food.api.GoogleDirectionsAPI;
import com.rmathur.food.models.Leg;
import com.rmathur.food.models.Route;
import com.rmathur.food.models.Route_;
import com.rmathur.food.models.Step;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivityFragment extends Fragment {

    EditText edtQuery, edtFrom, edtTo, edtDistance;
    Button btnGo;

    public static final String BASE_URL = "https://maps.googleapis.com";
    public final long DEGREES_TO_METERS = 111000;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        edtQuery = (EditText) view.findViewById(R.id.edtQuery);
        edtFrom = (EditText) view.findViewById(R.id.edtFromLoc);
        edtTo = (EditText) view.findViewById(R.id.edtToLoc);
        edtDistance = (EditText) view.findViewById(R.id.edtDetourDist);
        btnGo = (Button) view.findViewById(R.id.btnGo);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = edtQuery.getText().toString();
                String from = edtFrom.getText().toString();
                String to = edtTo.getText().toString();
                final double distance = Double.parseDouble(edtDistance.getText().toString());

                RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(BASE_URL).build();
                GoogleDirectionsAPI apiService = restAdapter.create(GoogleDirectionsAPI.class);
                apiService.getDirections("AIzaSyB5oRSjf_z5XjxLX-Yp8mxEchS6sP4txcs", from, to, new Callback<Route>(){
                    @Override
                    public void success(Route route, Response response) {
                        List<Location> locationList = new ArrayList<Location>();

                        for (Route_ currRoute : route.getRoutes()) {
                            for (Leg currLeg : currRoute.getLegs()) {
                                for (Step currStep : currLeg.getSteps()) {
                                    Location startLoc = new Location("");
                                    startLoc.setLatitude(currStep.getStartLocation().getLat());
                                    startLoc.setLongitude(currStep.getStartLocation().getLng());
                                    locationList.add(startLoc);

                                    Location endLoc = new Location("");
                                    endLoc.setLatitude(currStep.getEndLocation().getLat());
                                    endLoc.setLongitude(currStep.getEndLocation().getLng());
                                    locationList.add(endLoc);

                                    if(currStep.getDistance().getValue() > distance) {
                                        double xLen = endLoc.getLatitude() - startLoc.getLatitude();
                                        double yLen = endLoc.getLongitude() - startLoc.getLongitude();
                                        double hLen = Math.sqrt(Math.pow(xLen, 2) + Math.pow(yLen, 2));
                                        double ratio = distance / (hLen * DEGREES_TO_METERS);
                                        double smallerXLen = xLen * ratio;
                                        double smallerYLen = yLen * ratio;
                                        int numTimes = (int) ((hLen * DEGREES_TO_METERS) / distance);

                                        for (int i = 0; i < numTimes; i++) {
                                            double smallerX = startLoc.getLatitude() + smallerXLen;
                                            double smallerY = startLoc.getLongitude() + smallerYLen;

                                            Location newLoc = new Location("");
                                            newLoc.setLatitude(smallerX);
                                            newLoc.setLongitude(smallerY);
                                            locationList.add(newLoc);
                                        }
                                    }

                                    for (Location loc : locationList) {
                                        Log.e("Point", "Latitude: " + loc.getLatitude() + ", Longitude: " + loc.getLongitude());
                                    }
                                }
                            }
                        }
                    }

                    @Override
                    public void failure(RetrofitError retrofitError) {
                        Log.e("fuck", "it errored");
                    }
                });
            }
        });
        return view;
    }
}
