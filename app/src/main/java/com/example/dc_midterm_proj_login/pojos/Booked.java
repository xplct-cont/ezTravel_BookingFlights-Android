package com.example.dc_midterm_proj_login.pojos;

public class Booked {
    private String id, origin, destination, flight_no, departure_date, arrival_date, passengers, carrier, status, travel_class, created_at, updated_at;

    public Booked() {
    }

    public Booked(String id, String origin, String destination, String flight_no, String departure_date, String arrival_date, String passengers, String carrier, String status, String travel_class, String created_at, String updated_at) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.flight_no = flight_no;
        this.departure_date = departure_date;
        this.arrival_date = arrival_date;
        this.passengers = passengers;
        this.carrier = carrier;
        this.status = status;
        this.travel_class = travel_class;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightNo() {
        return flight_no;
    }

    public void setFlightNo(String flightNo) {
        this.flight_no = flightNo;
    }

    public String getDepartureDate() {
        return departure_date;
    }

    public void setDepartureDate(String departureDate) {
        this.departure_date = departureDate;
    }

    public String getArrivalDate() {
        return arrival_date;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrival_date = arrivalDate;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getTravelClass() {
        return travel_class;
    }

    public void setTravelClass(String travelClass) {
        this.travel_class = travelClass;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
