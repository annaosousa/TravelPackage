// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: helloworld.proto

// Protobuf Java Version: 3.25.5
package com.example;

public interface TripRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:helloworld.TripRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * "one-way" ou "round-trip"
   * </pre>
   *
   * <code>string type = 1;</code>
   * @return The type.
   */
  java.lang.String getType();
  /**
   * <pre>
   * "one-way" ou "round-trip"
   * </pre>
   *
   * <code>string type = 1;</code>
   * @return The bytes for type.
   */
  com.google.protobuf.ByteString
      getTypeBytes();

  /**
   * <code>string origin = 2;</code>
   * @return The origin.
   */
  java.lang.String getOrigin();
  /**
   * <code>string origin = 2;</code>
   * @return The bytes for origin.
   */
  com.google.protobuf.ByteString
      getOriginBytes();

  /**
   * <code>string destination = 3;</code>
   * @return The destination.
   */
  java.lang.String getDestination();
  /**
   * <code>string destination = 3;</code>
   * @return The bytes for destination.
   */
  com.google.protobuf.ByteString
      getDestinationBytes();

  /**
   * <code>string departure_date = 4;</code>
   * @return The departureDate.
   */
  java.lang.String getDepartureDate();
  /**
   * <code>string departure_date = 4;</code>
   * @return The bytes for departureDate.
   */
  com.google.protobuf.ByteString
      getDepartureDateBytes();

  /**
   * <code>string return_date = 5;</code>
   * @return The returnDate.
   */
  java.lang.String getReturnDate();
  /**
   * <code>string return_date = 5;</code>
   * @return The bytes for returnDate.
   */
  com.google.protobuf.ByteString
      getReturnDateBytes();

  /**
   * <code>int32 num_people = 6;</code>
   * @return The numPeople.
   */
  int getNumPeople();
}
