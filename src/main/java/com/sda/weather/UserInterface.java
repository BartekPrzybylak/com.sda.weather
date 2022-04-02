package com.sda.weather;

import location.LocationController;

import java.util.Scanner;

public class UserInterface {

    private final LocationController locationController;

    public UserInterface(LocationController locationController) {
        this.locationController = locationController;
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);


        while(true){
            System.out.println("Co chcesz zrobić? ");
            System.out.println("1. dodaj lokalizację ");
            System.out.println("0. zamknij ");

            int option = scanner.nextInt();

            switch(option){
                case 1:
                    createLocation();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("błąd, podaj właściwą komendę");
            }
        }
    }

    private void createLocation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj nazwę miasta: ");
        String city = scanner.nextLine();
        System.out.println("Podaj długość geograficzną: ");
        Long longitude = scanner.nextLong();
        System.out.println("Podaj szerokość geograficzną: ");
        Long latitude = scanner.nextLong();
        System.out.println("Podaj kraj: ");
        String country = scanner.nextLine();
        System.out.println("Podaj region: ");
        String region = scanner.nextLine();

        String requestBody = String.format("{\"city\":%s\",\"longtitude\":%d\",\"latitude\":%d\",\"country\":%s\",\"region\":%s\"}", city, longitude, latitude, country, region);
        System.out.println("Wysłany http request" + requestBody);
        String responseBody = locationController.createLocation(requestBody);
        System.out.println("Odebrany http response: " + responseBody);
    }
}
