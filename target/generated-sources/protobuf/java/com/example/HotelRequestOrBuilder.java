// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: helloworld.proto

// Protobuf Java Version: 3.25.5
package com.example;

public interface HotelRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:helloworld.HotelRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string destination = 1;</code>
   * @return The destination.
   */
  java.lang.String getDestination();
  /**
   * <code>string destination = 1;</code>
   * @return The bytes for destination.
   */
  com.google.protobuf.ByteString
      getDestinationBytes();

  /**
   * <code>string check_in_date = 2;</code>
   * @return The checkInDate.
   */
  java.lang.String getCheckInDate();
  /**
   * <code>string check_in_date = 2;</code>
   * @return The bytes for checkInDate.
   */
  com.google.protobuf.ByteString
      getCheckInDateBytes();

  /**
   * <code>string check_out_date = 3;</code>
   * @return The checkOutDate.
   */
  java.lang.String getCheckOutDate();
  /**
   * <code>string check_out_date = 3;</code>
   * @return The bytes for checkOutDate.
   */
  com.google.protobuf.ByteString
      getCheckOutDateBytes();

  /**
   * <code>int32 num_people = 4;</code>
   * @return The numPeople.
   */
  int getNumPeople();

  /**
   * <code>int32 trip_id = 5;</code>
   * @return The tripId.
   */
  int getTripId();
}
