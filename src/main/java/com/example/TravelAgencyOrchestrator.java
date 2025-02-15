// package com.example;

// public class TravelAgencyOrchestrator {

//     private final HotelServer hotelServer;
//     private final AirlineServer airlineServer;
//     private final CarRentalServer carServer;

//     public TravelAgencyOrchestrator (HotelServer hotel, AirlineServer airline, CarRentalServer car) {
//         this.hotelServer = hotel;
//         this.airlineServer = airline;
//         this.carServer = car;
//     }

//     public boolean orchestrator (TripRequest request) {
//         String flightBooking = null;
//         String hotelBooking = null;
//         String carBooking = null;
        
//         try {
//             flightBooking = flightService.bookFlight(request);
//             System.out.println("Passagem comprada: " + flightBooking);

//             hotelBooking = hotelService.reserveHotel(request);
//             System.out.println("Hotel reservado: " + hotelBooking);

//             carBooking = carService.reserveCar(request);
//             System.out.println("Carro reservado: " + carBooking);

//             System.out.println("Viagem confirmada!");
//             return true;

//         } catch (Exception e) {
//             System.out.println("Erro na reserva: " + e.getMessage());
//             rollback(flightBooking, hotelBooking, carBooking);
//             return false;
//         }
//     }

//     private void rollback(String flightBooking, String hotelBooking, String carBooking) {
//         System.out.println("Iniciando rollback...");

//         if (carBooking != null) {
//             carService.cancelCar(carBooking);
//             System.out.println("Reserva do carro cancelada.");
//         }
//         if (hotelBooking != null) {
//             hotelService.cancelReservation(hotelBooking);
//             System.out.println("Reserva do hotel cancelada.");
//         }
//         if (flightBooking != null) {
//             flightService.cancelFlight(flightBooking);
//             System.out.println("Passagem aérea cancelada.");
//         }

//         System.out.println("Rollback concluído.");
//     }
// }
