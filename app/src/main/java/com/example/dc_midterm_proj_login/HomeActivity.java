package com.example.dc_midterm_proj_login;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.dc_midterm_proj_login.adapters.BookedAdapter;
import com.example.dc_midterm_proj_login.api.RequestPlaceholder;
import com.example.dc_midterm_proj_login.api.RetrofitBuilder;
import com.example.dc_midterm_proj_login.pojos.Booked;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    public RetrofitBuilder retrofitBuilder;
    public RequestPlaceholder requestPlaceholder;
    public RecyclerView bookedRecyclerView;
    public List<Booked> bookedList;
    public BookedAdapter bookedAdapter;
    private SwipeRefreshLayout swiperefresh;
    public Button back;
    public Button checkdin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        retrofitBuilder = new RetrofitBuilder();
        requestPlaceholder = retrofitBuilder.getRetrofit().create(RequestPlaceholder.class);

        swiperefresh = findViewById(R.id.swiperefresh);
        bookedRecyclerView = findViewById(R.id.bookedRecyclerView);
        bookedList = new ArrayList<>();
        bookedAdapter = new BookedAdapter(bookedList, this);
        bookedRecyclerView.setAdapter(bookedAdapter);
        bookedRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        back = findViewById(R.id.back);
        checkdin = findViewById(R.id.checkdin);

        checkdin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkdin.isClickable());
                openCheckedIn();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (back.isClickable());
                openExplore();
            }
        });

        swiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                populateBooked();
            }
        });

        populateBooked();


    }


    private void openExplore() {
        Intent intent = new Intent(HomeActivity.this, ExploreActivity.class);
        startActivity(intent);
    }

    private void openCheckedIn() {
        Intent intent = new Intent(HomeActivity.this,  CheckedIn.class);
        startActivity(intent);

    }


    public void populateBooked() {

        try {

            bookedList.clear();

            Call<List<Booked>> bookedCall = requestPlaceholder.getAllPosts("L2tfLs4URiKY9aDbMZ0FVNy4jf6wdjDxLuhBujOOK1Sv36ygf7uTJjNWMzNIPa9a", "14");

            bookedCall.enqueue(new Callback<List<Booked>>() {
                @Override
                public void onResponse(Call<List<Booked>> call, Response<List<Booked>> response) {

                    if (response.isSuccessful()) {
                        if (response.code() == 200) {
                            bookedList.addAll(response.body());

                            bookedAdapter.notifyDataSetChanged();//Notifying the bookedAdapter that the data was changed

                            swiperefresh.setRefreshing(false);

                        } else {
                            Log.e("ERR_GET_POSTS", response.message() + "");
                            Toast.makeText(HomeActivity.this, "Error Opening Booked Flights", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Log.e("ERR_GET_POSTS", response.message() + "");
                        Toast.makeText(HomeActivity.this, "Error Opening Booked Flights", Toast.LENGTH_SHORT).show();

                    }
                }


                @Override
                public void onFailure(Call<List<Booked>> call, Throwable t) {

                }
            });

        } catch (Exception e) {
            Log.e("ERR_GET_POSTS", e.getMessage());

        }

    }

}