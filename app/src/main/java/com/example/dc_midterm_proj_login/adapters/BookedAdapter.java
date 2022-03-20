package com.example.dc_midterm_proj_login.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dc_midterm_proj_login.HomeActivity;
import com.example.dc_midterm_proj_login.LoginActivity;
import com.example.dc_midterm_proj_login.R;
import com.example.dc_midterm_proj_login.pojos.Booked;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class BookedAdapter extends RecyclerView.Adapter<BookedAdapter.ViewHolder> {

    public List<Booked> bookedList;
    public Context context;

    public BookedAdapter(List<Booked> bookedList, Context context) {
        this.bookedList = bookedList;
        this.context = context;
    }

    @NonNull
    @Override
    public BookedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.booked_recyclerview_layout, parent, false);

        return  new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull BookedAdapter.ViewHolder holder, int position) {
       Booked booked = bookedList.get(position);

       holder.Origin.setText(booked.getOrigin());
       holder.Destination.setText(booked.getDestination());
       holder.flightno.setText(booked.getFlightNo());
       holder.carrier.setText(booked.getCarrier());
       holder.status.setText(booked.getStatus());
       holder.passengers.setText(booked.getPassengers());
       holder.departuredate.setText(booked.getDepartureDate());
       holder.arrivaldate.setText((booked.getArrivalDate()));
       holder.travelclass.setText(booked.getTravelClass());

    }

    @Override
    public int getItemCount() {
        return bookedList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView Origin, Destination, carrier, status, flightno, passengers, departuredate, arrivaldate, travelclass;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            Origin = itemView.findViewById(R.id.bookedOrigin);
            Destination = itemView.findViewById(R.id.bookedDestination);
            flightno = itemView.findViewById(R.id.bookedflightno);
            carrier = itemView.findViewById(R.id.bookedcarrier);
            status = itemView.findViewById(R.id.bookedstatus);
            passengers = itemView.findViewById(R.id.bookedpassengers);
            departuredate = itemView.findViewById(R.id.bookeddeparture);
            arrivaldate = itemView.findViewById(R.id.bookedarrival);
            travelclass = itemView.findViewById(R.id.bookedtravelclass);

        }

    }
}
