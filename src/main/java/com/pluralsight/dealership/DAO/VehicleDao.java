package com.pluralsight.dealership.DAO;

import com.pluralsight.dealership.DataSource;
import com.pluralsight.dealership.models.Vehicle;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//create read update delete
public class VehicleDao {

    private BasicDataSource dataSource;

    public VehicleDao(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    //converts one row of SQL into vehicle object
    //
    private Vehicle mapVehicle(ResultSet rs) throws SQLException{
        return new Vehicle(
                rs.getInt("vin"),
                rs.getInt("vehicleMake"),
                rs.getString("vehicleModel"),
                rs.getString("vehicleType"),
                rs.getString("vehicleType"),
                rs.getString("vehicleColor"),
                rs.getInt("odometer"),
                rs.getDouble("price")
        );
    }

    public List<Vehicle> getByPriceRange(double min, double max) throws SQLException{

        //? - avoid sql injection
        String sql = "SELECT * FROM vehicles WHERE price BETWEEN ? AND ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setDouble(1, min);
            ps.setDouble(2, max);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                vehicles.add(mapVehicle(rs));
            }

        }
        return vehicles;
    }

    public List<Vehicle> getByMakeModel(String vehicleMake, String vehicleModel) throws SQLException{
        String sql = "SELECT * FROM vehicles WHERE vehicleMake = ? AND vehicleModel = ?";

        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setString(1, vehicleMake);
            ps.setString(2, vehicleModel);

            ResultSet rs = ps.executeQuery();


        }




    }

}
